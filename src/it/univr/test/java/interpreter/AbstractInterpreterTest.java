package interpreter;

import domains.FA;
import domains.Interval;
import grammar.*;
import grammar.antlr.MudynLexer;
import grammar.antlr.MudynParser;

import static org.junit.Assert.assertEquals;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

public class AbstractInterpreterTest {

    private String string1 = "x=1;";
    private String string2 = "x=1;x=x+ 1;";
    private String string3 = "x=1;x=\"a\";";
    private String string4 = "x=1;a=234;";

    private MudynParser parser1 = new MudynParser(new CommonTokenStream(new MudynLexer(CharStreams.fromString(string1))));
    private MudynParser parser2 = new MudynParser(new CommonTokenStream(new MudynLexer(CharStreams.fromString(string2))));
    private MudynParser parser3 = new MudynParser(new CommonTokenStream(new MudynLexer(CharStreams.fromString(string3))));
    private MudynParser parser4 = new MudynParser(new CommonTokenStream(new MudynLexer(CharStreams.fromString(string4))));

    @Test
    public void fixPoint() {
        CFGGenerator generator;
        AbstractInterpreter interpreter;
        // String 1
        generator = new CFGGenerator(parser1.dimp());
        interpreter = new AbstractInterpreter(generator.getCFG());
        interpreter.fixPoint();
        assertEquals(interpreter.getLastState(), new State().update("x", new Interval("1", "1")));
        // String 2
        generator = new CFGGenerator(parser2.dimp());
        interpreter = new AbstractInterpreter(generator.getCFG());
        interpreter.fixPoint();
        assertEquals(interpreter.getLastState(), new State().update("x", new Interval("2", "2")));
        // String 3
        generator = new CFGGenerator(parser3.dimp());
        interpreter = new AbstractInterpreter(generator.getCFG());
        interpreter.fixPoint();
        assertEquals(interpreter.getLastState(), new State().update("x", new FA("a")));
        // String 4
        generator = new CFGGenerator(parser4.dimp());
        interpreter = new AbstractInterpreter(generator.getCFG());
        interpreter.fixPoint();
        assertEquals(interpreter.getLastState(),
                new State().update("x", new Interval("1", "1"))
                           .update("a", new Interval("234", "234")));
    }
}