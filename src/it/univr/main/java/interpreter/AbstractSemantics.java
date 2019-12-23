package interpreter;


import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import org.antlr.v4.runtime.RecognitionException;

import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.IRFactory;


import domains.*;
import grammar.CFGGenerator;
import grammar.ControlFlowGraph;
import grammar.Edge;
import grammar.antlr.CustomNegationContext;
import grammar.antlr.MudynLexer;
import grammar.antlr.MudynParser;
import interpreter.Exception.EvaluationException;
import it.univr.fsm.equations.RegularExpression;

/**
 * Class responsible for next state evaluation.
 * It consists of static methods which compute next state  given current state and edge.
 */
public class AbstractSemantics {

	/**
	 * Compute state given current state and an edge.
	 * If edge is not labeled return current state, otherwise invoke evaluation of edge's label depending on its type.
	 *
	 * @param e edge to evaluate
	 * @param s current state
	 * @return state s modified by label of edge e
	 * @throws EvaluationException
	 */
	public static State evaluate(Edge e, State s) throws EvaluationException {

		if ( s.isNull() )
			return s;

		if (e.getLabel() instanceof MudynParser.ExpContext)
			return evaluateGuard( (MudynParser.ExpContext) e.getLabel(), s);

		else if (e.getLabel() instanceof MudynParser.AssignmentStmtContext)
			return evaluateAssignment((MudynParser.AssignmentStmtContext) e.getLabel(), s);

		else if (e.getLabel() instanceof MudynParser.EvalContext)
			return evaluateEval((MudynParser.EvalContext) e.getLabel(), s);
		
		else if (e.getLabel() instanceof MudynParser.SkipContext)
			return s;

		else if (e.getLabel() == null ) {
			return s;
		}

		throw new EvaluationException("Invalid edge label " + e.getLabelString());
	}

	/*
						EDGES
	 */

	/**
	 * Evaluate expression label, if it's false return null state, otherwise return current state.
	 *
	 * @param label expression guard
	 * @param s current state
	 * @return nullstate if s is evaluated false, s otherwise
	 * @throws EvaluationException
	 */
	private static State evaluateGuard(MudynParser.ExpContext label, State s) throws EvaluationException{
		AbstractValue guardValue = evaluateExp(label, s);

		if ( ((AbstractBoolean) guardValue).isFalse() )
			return State.nullState();

		return s;
	}

	/**
	 * Evaluate assignment statement and modify current state.
	 *
	 * @param label assignment statement
	 * @param s current state
	 * @return current state modified by assignment
	 * @throws EvaluationException
	 */
	private static State evaluateAssignment(MudynParser.AssignmentStmtContext label, State s) throws EvaluationException {
		AbstractValue rhs = evaluateExp(label.exp(), s);
		String lhs = label.ID().getText();
		return s.update(lhs, rhs);
	}

	/**
	 * Evaluate eval instruction.
	 * Generate a regular expression corresponding to eval string argument, then generate a CFG based on this regex.
	 * Instance an abstract interpreter and compute fixpoint for eval instruction.
	 *
	 * @param comm eval instruction
	 * @param s current state
	 * @return fixpoint state of eval expression
	 * @throws EvaluationException
	 */
	private static State evaluateEval(MudynParser.EvalContext comm, State s) throws EvaluationException {
		AbstractInterpreter evalInterpreter = new AbstractInterpreter(getEvalCfg(comm, s), s);
		System.out.println("STATI INTERPRETER " + evalInterpreter.getStates());
		evalInterpreter.fixPoint();
		return evalInterpreter.getLastState();
	}

	public static ControlFlowGraph getEvalCfg(MudynParser.EvalContext comm, State s) throws EvaluationException{
		FA value = (FA) evaluateExp(comm.exp(), s);
		RegularExpression r = value.stmSyn().toRegex();
//		System.err.println(r);
//		RegexToCFG evalCfg = new RegexToCFG(r);

		MudynParser parserEval = new MudynParser(new CommonTokenStream(new MudynLexer(CharStreams.fromString(r.getProgram()))));
		CFGGenerator cfggen = new CFGGenerator(parserEval.comm());
		
		ControlFlowGraph g = cfggen.getCFG();
		
		for (Edge e : g.getEdges()) {
			if (!check(e.getLabelString())) {
				MudynParser p = new MudynParser(new CommonTokenStream(new MudynLexer(CharStreams.fromString("skip;"))));
				e.setParseContext(p.comm());
			} else {
				System.err.println(e.getLabelString());
			}
		}
		
		return g;
	}

	/*
							EXPRESSIONS
	 */

	/**
	 * Evaluate expression, returning computed abstract value.
	 *
	 * @param exp expression
	 * @param s current state
	 * @return abstract value obtained from expression
	 * @throws EvaluationException
	 */
	private static AbstractValue evaluateExp(MudynParser.ExpContext exp, State s) throws EvaluationException{

		/**
		 * Basics
		 */
		if (exp instanceof MudynParser.IdNameContext)
			return s.getValue(exp.getText());

		else if ( exp instanceof MudynParser.ParenthesisContext)
			return evaluateExp(((MudynParser.ParenthesisContext) exp).exp(), s);

		/**
		 * Integers
		 */

		else if ( exp instanceof MudynParser.IntContext)
			return evaluateInt((MudynParser.IntContext) exp, s);

		else if ( exp instanceof MudynParser.LenStringContext)
			return evaluateLenString( (MudynParser.LenStringContext) exp, s);

		else if ( exp instanceof MudynParser.CastStringToIntContext)
			return evaluateCastStringToInt( (MudynParser.CastStringToIntContext) exp, s);

		else if ( exp instanceof MudynParser.SumContext)
			return evaluateSum( (MudynParser.SumContext) exp, s);

		else if ( exp instanceof MudynParser.SotContext)
			return evaluateSot( (MudynParser.SotContext) exp, s);

		else if ( exp instanceof MudynParser.MolContext)
			return evaluateMol( (MudynParser.MolContext) exp, s);

		else if ( exp instanceof MudynParser.IndexOfContext )
			return evaluateIndexOf( (MudynParser.IndexOfContext) exp, s);

		/**
		 * Booleans
		 */

		else if ( exp instanceof MudynParser.BooleansContext)
			return evaluateBooleans( (MudynParser.BooleansContext) exp);

		else if ( exp instanceof MudynParser.LogicAndContext)
			return evaluateLogicAnd ( (MudynParser.LogicAndContext) exp, s);

		else if ( exp instanceof MudynParser.LogicOrContext)
			return evaluateLogicOr ( (MudynParser.LogicOrContext) exp, s);

		else if ( exp instanceof MudynParser.NegationContext)
			return ((AbstractBoolean) evaluateExp(((MudynParser.NegationContext) exp).exp(), s)).not();

		else if (exp instanceof MudynParser.EqualExpContext)
			return evaluateEqual( (MudynParser.EqualExpContext) exp, s);

		else if (exp instanceof MudynParser.GreaterExpContext)
			return evaluateGreater ( (MudynParser.GreaterExpContext) exp, s);

		else if (exp instanceof MudynParser.LessExpContext)
			return evaluateLess ( (MudynParser.LessExpContext) exp, s);

		else if ( exp instanceof CustomNegationContext)
			return evaluateCustomNegation( (CustomNegationContext) exp, s);

		/**
		 * Strings
		 */

		else if ( exp instanceof MudynParser.StringGenericContext)
			return evaluateStringGeneric( (MudynParser.StringGenericContext) exp, s);

		else if ( exp instanceof MudynParser.ConcatContext)
			return evaluateConcat( (MudynParser.ConcatContext) exp, s);

		else if ( exp instanceof MudynParser.SubstringsContext)
			return evaluateSubstrings( (MudynParser.SubstringsContext) exp, s);

		else if ( exp instanceof MudynParser.CharAtContext)
			return evaluateCharAt( (MudynParser.CharAtContext) exp, s);
			
		throw new EvaluationException("Expression unresolvable " + exp.getText());
	}


	/*
					INTEGERS
	 */

	/**
	 * Return new interval with lower value equals to upper value.
	 *
	 * @param aexp value to be assigned to interval
	 * @param s current state
	 * @return new interval
	 */
	private static AbstractValue evaluateInt(MudynParser.IntContext aexp, State s) {
		return new Interval(aexp.getText(), aexp.getText());
	}

	/**
	 * Return interval representing string length.
	 *
	 * @param aexp string of which compute length
	 * @param s current state
	 * @return length of the string
	 * @throws EvaluationException
	 */
	private static AbstractValue evaluateLenString(MudynParser.LenStringContext aexp, State s) throws EvaluationException {
		FA string = (FA) evaluateExp(aexp.exp(), s);
		return string.length();
	}

	private static AbstractValue evaluateCastStringToInt(MudynParser.CastStringToIntContext aexp, State s) throws EvaluationException {
		// TODO to be implemented
		throw new EvaluationException("Cast string to int not implemented");
	}

	/**
	 * Evaluate sum between two expressions.
	 *
	 * @param aexp two expressions of which compute sum
	 * @param s current state
	 * @return sum between intervals representing the two expressions
	 * @throws EvaluationException
	 */
	private static AbstractValue evaluateSum(MudynParser.SumContext aexp, State s) throws EvaluationException {
		AbstractValue n1 = evaluateExp(aexp.exp(0), s);
		if (n1.isBottom())
			return n1;
		AbstractValue n2 = evaluateExp(aexp.exp(1), s);
		if (n2.isBottom())
			return n2;
		return ((Interval)n1).plus((Interval) n2);
	}

	/**
	 * Evaluate subtraction between two expressions.
	 *
	 * @param aexp two expressions of which compute subtraction
	 * @param s current state
	 * @return subtraction between intervals representing the two expressions
	 * @throws EvaluationException
	 */
	private static AbstractValue evaluateSot(MudynParser.SotContext aexp, State s) throws EvaluationException {
		AbstractValue n1 = evaluateExp(aexp.exp(0), s);
		if (n1.isBottom())
			return n1;
		AbstractValue n2 = evaluateExp(aexp.exp(1), s);
		if (n2.isBottom())
			return n2;
		return ((Interval)n1).diff((Interval) n2);
	}

	/**
	 * Evaluate product between two expressions.
	 *
	 * @param aexp two expressions of which compute product
	 * @param s current state
	 * @return product between intervals representing the two expressions
	 * @throws EvaluationException
	 */
	private static AbstractValue evaluateMol(MudynParser.MolContext aexp, State s) throws EvaluationException {
		AbstractValue n1 = evaluateExp(aexp.exp(0), s);
		if (n1.isBottom())
			return n1;
		AbstractValue n2 = evaluateExp(aexp.exp(1), s);
		if (n2.isBottom())
			return n2;
		return ((Interval)n1).mul((Interval) n2);
	}

	private static AbstractValue evaluateIndexOf(MudynParser.IndexOfContext aexp, State s) throws EvaluationException {
		// TODO to be implemented
		FA caller = (FA) evaluateExp(aexp.exp(0), s);
		FA callee = (FA) evaluateExp(aexp.exp(1), s);
		throw new EvaluationException("Index of not implemented");
	}

	/*
					BOOLEANS
	 */

	/**
	 * Evaluate boolean expression.
	 *
	 * @param bexp boolean expression
	 * @return abstract boolean representing expression value
	 * @throws EvaluationException
	 */
	private static AbstractValue evaluateBooleans(MudynParser.BooleansContext bexp) throws EvaluationException{
		if ( bexp.getText().equals("true") )
			return AbstractBoolean.True();
		else if ( bexp.getText().equals("false") )
			return AbstractBoolean.False();
		throw new EvaluationException("Invalid boolean " + bexp.getText());
	}

	/**
	 * Evaluate logic and between boolean expressions.
	 *
	 * @param bexp boolean expressions
	 * @param s current state
	 * @return computed abstract value
	 * @throws EvaluationException
	 */
	private static AbstractValue evaluateLogicAnd(MudynParser.LogicAndContext bexp, State s) throws EvaluationException{
		return ( (AbstractBoolean) evaluateExp(bexp.exp(0), s)).and( (AbstractBoolean) evaluateExp(bexp.exp(1),s));
	}

	/**
	 * Evaluate logic or between boolean expressions.
	 *
	 * @param bexp boolean expressions
	 * @param s current state
	 * @return computed abstract value
	 * @throws EvaluationException
	 */
	private static AbstractValue evaluateLogicOr(MudynParser.LogicOrContext bexp, State s) throws EvaluationException {
		return ( (AbstractBoolean) evaluateExp(bexp.exp(0), s)).or( (AbstractBoolean) evaluateExp(bexp.exp(1),s));
	}

	/**
	 * Evaluate negated expression.
	 *
	 * @param bexp boolean expression
	 * @param s current state
	 * @return abstract value representing negated boolean expression
	 * @throws EvaluationException
	 */
	private static AbstractValue evaluateCustomNegation(CustomNegationContext bexp, State s) throws EvaluationException{
		// evaluate exp whitout negation
		AbstractBoolean evaluated = (AbstractBoolean) evaluateExp( bexp.getChild(), s);
		return evaluated.not();
	}

	/**
	 * Evaluate equal operation between two expressions.
	 *
	 * @param exp two expressions
	 * @param s current state
	 * @return abstract value representing result of equal operation
	 * @throws EvaluationException if expressions are not instance of same class,
	 *                             where class is interval, string or booleans
	 */
	private static AbstractValue evaluateEqual(MudynParser.EqualExpContext exp, State s) throws EvaluationException {
		//casi

		AbstractValue rhs =  evaluateExp(exp.exp(0), s);
		AbstractValue lhs =  evaluateExp(exp.exp(1), s);

		if ( rhs instanceof Interval && lhs instanceof Interval){
			Interval i1 = (Interval) rhs,
					i2 = (Interval) lhs;
			return i1.less(i2).not().and(i1.greater(i2).not());
		}
		else if ( rhs instanceof FA && lhs instanceof FA) {
			if (rhs.equals(lhs))
				return AbstractBoolean.True();
			else
				return AbstractBoolean.False();
		}
		else if( rhs instanceof AbstractBoolean && lhs instanceof AbstractBoolean) {
			return ((AbstractBoolean) rhs).equalsValues(lhs);
		}

		throw new EvaluationException("Equals between incomparable types");
	}

	/**
	 * Evaluate greater operation between two intervals.
	 *
	 * @param exp two expression
	 * @param s current state
	 * @return abstract value representing result of greater operation
	 * @throws EvaluationException if expressions are not intervals
	 */
	private static AbstractValue evaluateGreater(MudynParser.GreaterExpContext exp, State s) throws EvaluationException {
		AbstractValue rhs =  evaluateExp(exp.exp(0), s);
		AbstractValue lhs =  evaluateExp(exp.exp(1), s);

		if ( rhs instanceof Interval && lhs instanceof Interval){
			Interval i1 = (Interval) rhs,
					i2 = (Interval) lhs;
			return i1.greater(i2);
		}

		throw new EvaluationException("Expression unresolvable " + exp.getText());
	}

	/**
	 * Evaluate less operation between two intervals.
	 *
	 * @param exp two expression
	 * @param s current state
	 * @return abstract value representing result of less operation
	 * @throws EvaluationException if expressions are not intervals
	 */
	private static AbstractValue evaluateLess(MudynParser.LessExpContext exp, State s) throws EvaluationException {
		AbstractValue rhs =  evaluateExp(exp.exp(0), s);
		AbstractValue lhs =  evaluateExp(exp.exp(1), s);

		if ( rhs instanceof Interval && lhs instanceof Interval){
			Interval i1 = (Interval) rhs,
					i2 = (Interval) lhs;
			return i1.less(i2);
		}

		throw new EvaluationException("Expression unresolvable " + exp.getText());
	}

	/*
					STRINGS
	 */

	/**
	 * Evaluate string expression.
	 *
	 * @param sexp expression
	 * @param s current state
	 * @return Abstract value representing string
	 */
	private static AbstractValue evaluateStringGeneric(MudynParser.StringGenericContext sexp, State s) {
		String value = sexp.getText().substring(1, sexp.getText().length()-1);
		return new FA(value);
	}

	/**
	 * Evaluate concatenation operation between two strings.
	 *
	 * @param sexp two expressions
	 * @param s current state
	 * @return abstract value of first string concatenated with second one
	 * @throws EvaluationException
	 */
	private static AbstractValue evaluateConcat(MudynParser.ConcatContext sexp, State s) throws EvaluationException {
		FA first = (FA) evaluateExp(sexp.exp(0), s);
		FA second = (FA) evaluateExp(sexp.exp(1), s);
		return first.concat(second);
	}

	/**
	 * Evaluate substring operation on string.
	 *
	 * @param sexp string expression and interval
	 * @param s current state
	 * @return substring of given string depending on interval indices
	 * @throws EvaluationException
	 */
	private static AbstractValue evaluateSubstrings(MudynParser.SubstringsContext sexp, State s) throws EvaluationException {
		FA string = (FA) evaluateExp(sexp.exp(0), s);
		Interval begin = (Interval) evaluateExp(sexp.exp(1), s);
		Interval end = (Interval) evaluateExp(sexp.exp(2), s);
		return string.substring(begin, end);
	}

	/**
	 * Evaluate charAt operation.
	 *
	 * @param sexp string expression and interval
	 * @param s current state
	 * @return character of string in position indicated by given interval
	 * @throws EvaluationException
	 */
	private static AbstractValue evaluateCharAt(MudynParser.CharAtContext sexp, State s) throws EvaluationException {
		Interval value = (Interval) evaluateExp(sexp.exp(1),s);
		FA string = (FA) evaluateExp(sexp.exp(0), s);
		return string.charAt(value);
	}
	
	public static boolean parseError = false;
	public static boolean check(String input) {
		if (input.trim().equals("true") || input.trim().equals("top") ||  input.trim().equals("!(top)") )
			return true;
		try {
			MudynParser parser = new MudynParser(new CommonTokenStream(new MudynLexer(CharStreams.fromString(input))));
			parser.removeErrorListeners();
			parser.addErrorListener(new BaseErrorListener() {
				
				@Override
				public void syntaxError(Recognizer<?, ?> recognizer,
                        Object offendingSymbol,
                        int line, int charPositionInLine,
                        String msg, RecognitionException e) {
					parseError = true;
					throw new AssertionError("ANTLR - syntax-error - line: " + line + ", position: " + line + ", message: " + msg);
				}
			});
			
			parser.comm();
		} catch (AssertionError e ){
			System.out.println("Questo è parseError: " + parseError);
			parseError = false;
			return false;
		}
		return true;
	}
}
