// Generated from Mudyn.g4 by ANTLR 4.7.2

package grammar.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MudynParser}.
 */
public interface MudynListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ProgramExecution}
	 * labeled alternative in {@link MudynParser#dimp}.
	 * @param ctx the parse tree
	 */
	void enterProgramExecution(MudynParser.ProgramExecutionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProgramExecution}
	 * labeled alternative in {@link MudynParser#dimp}.
	 * @param ctx the parse tree
	 */
	void exitProgramExecution(MudynParser.ProgramExecutionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicOr}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterLogicOr(MudynParser.LogicOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicOr}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitLogicOr(MudynParser.LogicOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Substrings}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSubstrings(MudynParser.SubstringsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Substrings}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSubstrings(MudynParser.SubstringsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterGreaterExp(MudynParser.GreaterExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitGreaterExp(MudynParser.GreaterExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectNumber}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterObjectNumber(MudynParser.ObjectNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectNumber}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitObjectNumber(MudynParser.ObjectNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNegation(MudynParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNegation(MudynParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringGeneric}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterStringGeneric(MudynParser.StringGenericContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringGeneric}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitStringGeneric(MudynParser.StringGenericContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexOf}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIndexOf(MudynParser.IndexOfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexOf}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIndexOf(MudynParser.IndexOfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectBoolean}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterObjectBoolean(MudynParser.ObjectBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectBoolean}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitObjectBoolean(MudynParser.ObjectBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Booleans}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBooleans(MudynParser.BooleansContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Booleans}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBooleans(MudynParser.BooleansContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterEqualExp(MudynParser.EqualExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitEqualExp(MudynParser.EqualExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LenString}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterLenString(MudynParser.LenStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LenString}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitLenString(MudynParser.LenStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSum(MudynParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSum(MudynParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mol}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterMol(MudynParser.MolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mol}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitMol(MudynParser.MolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterInt(MudynParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitInt(MudynParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterConcat(MudynParser.ConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitConcat(MudynParser.ConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdName}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIdName(MudynParser.IdNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdName}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIdName(MudynParser.IdNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(MudynParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(MudynParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CastStringToInt}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCastStringToInt(MudynParser.CastStringToIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CastStringToInt}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCastStringToInt(MudynParser.CastStringToIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCharAt(MudynParser.CharAtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCharAt(MudynParser.CharAtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectString}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterObjectString(MudynParser.ObjectStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectString}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitObjectString(MudynParser.ObjectStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterLessExp(MudynParser.LessExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitLessExp(MudynParser.LessExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sot}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSot(MudynParser.SotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sot}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSot(MudynParser.SotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicAnd}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterLogicAnd(MudynParser.LogicAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicAnd}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitLogicAnd(MudynParser.LogicAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterComposition(MudynParser.CompositionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitComposition(MudynParser.CompositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(MudynParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(MudynParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MudynParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MudynParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(MudynParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(MudynParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Skip}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterSkip(MudynParser.SkipContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Skip}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitSkip(MudynParser.SkipContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(MudynParser.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(MudynParser.AssignmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Eval}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterEval(MudynParser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Eval}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitEval(MudynParser.EvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MudynParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MudynParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MudynParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MudynParser.BlockContext ctx);
}