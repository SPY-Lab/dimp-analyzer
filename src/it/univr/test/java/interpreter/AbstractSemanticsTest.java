package interpreter;


import static org.junit.Assert.assertEquals;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import domains.AbstractBoolean;
import domains.FA;
import domains.Interval;
import grammar.Edge;
import grammar.Node;
import grammar.antlr.CustomNegationContext;
import grammar.antlr.MudynLexer;
import grammar.antlr.MudynParser;
import interpreter.Exception.EvaluationException;

public class AbstractSemanticsTest {

    /*
                ASSIGNMENT
     */
    @Test
    public void evaluateAssignment() throws EvaluationException {
        State s = new State();
        s = s.update("x", new Interval("5", "5"));
        State s_1 = new State();
        s_1 = AbstractSemantics.evaluate(createCommEdge("x = 5;"), s_1);
        assertEquals(s, s_1);

        s = s.update("x", new FA("ciao"));
        s_1 = AbstractSemantics.evaluate(createCommEdge("x = \"ciao\";"), s_1);
        assertEquals(s, s_1);

        s = s.update("x", AbstractBoolean.True());
        s_1 = AbstractSemantics.evaluate(createCommEdge("x = true;"), s_1);
        assertEquals(s, s_1);
    }

    /*
                EMPTY EDGE
     */

    @Test
    public void evaluateEmptyEdge() throws EvaluationException {
        State s = new State();
        State s_1 = AbstractSemantics.evaluate(new Edge(new Node(1), new Node(2), null), s);
        assertEquals(s, s_1);
    }

    /*
                GUARDS
     */
    @Test
    public void evaluateNumberEquals() throws EvaluationException {
        State s = new State();
        s = s.update("x", new Interval("3", "5"));
        s = s.update("y", new Interval("-Inf", "4"));
        s = s.update("a", new FA("x = x + 1;"));
        // equals true
        Edge e = createGuardEdge("x == 4");
        State s_1 = AbstractSemantics.evaluate(e, s);
        assertEquals(s, s_1);
        // equals false
        e = createGuardEdge("x == 2");
        s_1 = AbstractSemantics.evaluate(e, s);
        assertEquals(s_1, State.nullState());
        // Equals top bool
        e = createGuardEdge("y == x");
        s_1 = AbstractSemantics.evaluate(e, s);
        assertEquals(s_1, s);
        // Different types
        e = createGuardEdge("y == a");
        try {
            s_1 = AbstractSemantics.evaluate(e, s);
        } catch (EvaluationException exc) {
            assertEquals(exc.getMessage(), "Equals between incomparable types");
        }
    }

    @Test
    public void evaluateStringEquals() throws EvaluationException {
        State s = new State();
        s = s.update("x", new FA("ciao"));
        s = s.update("y", new FA("cia").concat(new FA("o")));
        // equals true
        Edge e = createGuardEdge("x == y");
        State s_1 = AbstractSemantics.evaluate(e, s);
        assertEquals(s, s_1);
        // equals true
        e = createGuardEdge("x == \"ciao\"");
        s_1 = AbstractSemantics.evaluate(e, s);
        assertEquals(s_1, s);
        // Equals false
        e = createGuardEdge("y == \"cia\"");
        s_1 = AbstractSemantics.evaluate(e, s);
        assertEquals(s_1, State.nullState());
    }

    @Test
    public void evaluateBooleanEquals() throws EvaluationException {
        State s = new State();
        s = s.update("x", AbstractBoolean.True());
        s = s.update("y", AbstractBoolean.False());
        s = s.update("z", AbstractBoolean.TopBool());
        // equals true
        Edge e = createGuardEdge("x == true");
        State s_1 = AbstractSemantics.evaluate(e, s);
        assertEquals(s, s_1);
        // equals false
        e = createGuardEdge("x == y");
        s_1 = AbstractSemantics.evaluate(e, s);
        assertEquals(s_1, State.nullState());
        // Equals top bool
        e = createGuardEdge("z == true");
        s_1 = AbstractSemantics.evaluate(e, s);
        assertEquals(s_1, s);
    }

    /*
            PARENTHESIS
     */

    @Test
    public void evaluateParenthesis() throws EvaluationException {
        State s = new State();
        s = s.update("x", new Interval("4", "4"));
        s = AbstractSemantics.evaluate(createCommEdge("x = 3 * (x - 2);"), s);
        assertEquals(s.getValue("x"), new Interval("6", "6"));
    }

    /*
            INTEGERS
     */

    @Test
    public void evaluateLenString() throws EvaluationException {
        State s = new State();
        State s_1 = new State();
        s = s.update("x", new Interval("4", "4"));
        s_1 = s_1.update("a", new FA("ciao"));
        s_1 = AbstractSemantics.evaluate(createCommEdge("x = len(a);"), s_1);
        assertEquals(s.getValue("x"), s_1.getValue("x"));
    }

    @Test
    public void evaluateIntOperations() throws EvaluationException {
        State s = new State();
        s = s.update("x", new Interval("4", "4"));
        s = AbstractSemantics.evaluate(createCommEdge("x = x + 1;"), s);
        assertEquals(s.getValue("x"), new Interval("5", "5"));

        s = AbstractSemantics.evaluate(createCommEdge("x = x - 1;"), s);
        assertEquals(s.getValue("x"), new Interval("4", "4"));

        s = AbstractSemantics.evaluate(createCommEdge("x = x * 2;"), s);
        assertEquals(s.getValue("x"), new Interval("8", "8"));
    }

    /*
            BOOLEANS
     */

    @Test
    public  void evaluateAtomicBooleans() throws EvaluationException {
        State s = new State();
        s = AbstractSemantics.evaluate(createCommEdge("x = true;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.True());

        s = AbstractSemantics.evaluate(createCommEdge("x = false;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.False());
    }

    @Test
    public void evaluateBoolOperations() throws EvaluationException {
        State s = new State();
        s = s.update("t", AbstractBoolean.True());
        s = s.update("f", AbstractBoolean.False());
        s = s.update("top", AbstractBoolean.TopBool());

        // AND

        s = AbstractSemantics.evaluate(createCommEdge("x = t && t;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.True());

        s = AbstractSemantics.evaluate(createCommEdge("x = t && f;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.False());

        s = AbstractSemantics.evaluate(createCommEdge("x = top && f;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.False());

        s = AbstractSemantics.evaluate(createCommEdge("x = top && t;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.TopBool());

        // OR

        s = AbstractSemantics.evaluate(createCommEdge("x = f || t;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.True());

        s = AbstractSemantics.evaluate(createCommEdge("x = f || f;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.False());

        s = AbstractSemantics.evaluate(createCommEdge("x = top || f;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.TopBool());

        s = AbstractSemantics.evaluate(createCommEdge("x = top || t;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.True());

        // NEGATION

        s = AbstractSemantics.evaluate(createCommEdge("x = ! f;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.True());

        s = AbstractSemantics.evaluate(createCommEdge("x = ! t;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.False());

        s = AbstractSemantics.evaluate(createCommEdge("x = ! top;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.TopBool());

        // Custom negation context
        State s_1 = new State();

        s_1 = AbstractSemantics.evaluate(createCustomNegationEdge("t == t"), s);
        assertEquals(s_1, State.nullState());

        s_1 = AbstractSemantics.evaluate(createCustomNegationEdge("t == f"), s);
        assertEquals(s, s_1);

        s_1 = AbstractSemantics.evaluate(createCustomNegationEdge("f == top"), s);
        assertEquals(s, s_1);

        // Evaluation in null state

        s_1 = State.nullState();
        s_1 = AbstractSemantics.evaluate(createCustomNegationEdge("f == top"), s_1);
        assertEquals(s_1, State.nullState());
    }

    @Test
    public void evaluateLessInteger() throws EvaluationException {
        State s = new State();
        s = s.update("n", new Interval("2", "2"));
        s = s.update("N", new Interval("4", "4"));
        s = s.update("top", Interval.topInterval());

        s = AbstractSemantics.evaluate(createCommEdge("x = n < N;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.True());

        s = AbstractSemantics.evaluate(createCommEdge("x = N < n;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.False());

        s = AbstractSemantics.evaluate(createCommEdge("x = top < n;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.TopBool());

        s = AbstractSemantics.evaluate(createCommEdge("x = N < top;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.TopBool());
    }

    @Test
    public void evaluateGreaterInteger() throws EvaluationException {
        State s = new State();
        s = s.update("n", new Interval("2", "2"));
        s = s.update("N", new Interval("4", "4"));
        s = s.update("top", Interval.topInterval());

        s = AbstractSemantics.evaluate(createCommEdge("x = n > N;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.False());

        s = AbstractSemantics.evaluate(createCommEdge("x = N > n;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.True());

        s = AbstractSemantics.evaluate(createCommEdge("x = top > n;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.TopBool());

        s = AbstractSemantics.evaluate(createCommEdge("x = N > top;"), s);
        assertEquals(s.getValue("x"), AbstractBoolean.TopBool());
    }

    /*
            STRINGS
     */

    @Test
    public void evaluateStringConcat() throws EvaluationException {
        State s = new State();
        s = s.update("a", new FA("ci"));
        s = s.update("b", new FA("ao"));

        s = AbstractSemantics.evaluate(createCommEdge("x = a.b;"), s);
        assertEquals(s.getValue("x"), new FA("ciao"));

        s = AbstractSemantics.evaluate(createCommEdge("x = \"\".a.b;"), s);
        assertEquals(s.getValue("x"), new FA("ciao"));
    }

    @Test
    public void evaluateSubString() throws EvaluationException {
        State s = new State();
        s = s.update("a", new FA("ciao"));
        s = s.update("b", new Interval("2", "2"));

        s = AbstractSemantics.evaluate(createCommEdge("x = substring(a,0,b);"), s);
        assertEquals(s.getValue("x"), new FA("ci"));
    }

    @Test
    public void evaluateCharAt() throws EvaluationException {
        State s = new State();
        s = s.update("a", new FA("ciao"));
        s = s.update("b", new Interval("2", "2"));

        s = AbstractSemantics.evaluate(createCommEdge("x = a.charAt(b);"), s);
        assertEquals(s.getValue("x"), new FA("a"));
    }

    /*
            EVAL
     */

    @Test
    public void evaluateEval() throws EvaluationException {
        State s = new State();
        s = s.update("a", new FA("x = x + 1;"));
        s = s.update("x", new Interval("2", "2"));

        s = AbstractSemantics.evaluate(createCommEdge("eval(a);"), s);
        assertEquals(s.getValue("x"), new Interval("3", "3"));
    }

    @Test
    public void evaluateEvalIf() throws EvaluationException {
        State s = new State();
        s = s.update("a", new FA("if (x < 3) {x = x + 1;} else {x = x - 1;}"));
        System.out.println(((FA) s.getValue("a")).stmSyn().toRegex());
        s = s.update("x", new Interval("2", "4"));

        s = AbstractSemantics.evaluate(createCommEdge("eval(a);"), s);
        assertEquals(s.getValue("x"), new Interval("1", "5"));
    }

    @Test
    public void evaluateEvalWhile() throws EvaluationException {
        State s = new State();
        s = s.update("a", new FA("while (x < 3) {x = x + 1;}"));
        System.out.println(((FA) s.getValue("a")).stmSyn().toRegex());
        s = s.update("x", new Interval("2", "4"));

        s = AbstractSemantics.evaluate(createCommEdge("eval(a);"), s);
        assertEquals(s.getValue("x"), new Interval("2", "+Inf"));
    }


    /*
            AUXILIARY METHODS
     */
    private Edge createGuardEdge(String label){
        MudynParser.ExpContext ctx = new MudynParser(new CommonTokenStream(new MudynLexer(CharStreams.fromString(label)))).exp();
        return new Edge(new Node(1), new Node(2), ctx);
    }

    private Edge createCommEdge(String label){
        MudynParser.CommContext ctx = new MudynParser(new CommonTokenStream(new MudynLexer(CharStreams.fromString(label)))).comm();
        return new Edge(new Node(1), new Node(2), ctx);
    }

    private Edge createCustomNegationEdge(String label) {
        MudynParser.ExpContext ctx = new MudynParser(new CommonTokenStream(new MudynLexer(CharStreams.fromString(label)))).exp();
        return new Edge(new Node(1), new Node(2), new CustomNegationContext(ctx));
    }
}