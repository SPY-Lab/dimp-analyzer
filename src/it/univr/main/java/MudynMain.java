
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import grammar.CFGGenerator;
import grammar.ControlFlowGraph;
import grammar.antlr.MudynLexer;
import grammar.antlr.MudynParser;
import interpreter.AbstractInterpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MudynMain {

	public static void main(String[] argv){
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		String file = argv[0];
		ParseTree tree = parse(file);
		CFGGenerator mCFCfgGenerator = new CFGGenerator(tree);
		ControlFlowGraph cfg = mCFCfgGenerator.getCFG();

		AbstractInterpreter interpreter = new AbstractInterpreter(cfg);
		interpreter.fixPoint();
	}

	/**
	 * Parse the given JavaScript program into a parse tree.
	 *
	 * @param file file containing the JS program
	 * @return parse tree of the program
	 */
	private static ParseTree parse(String file) {

		try {
			InputStream stream = new FileInputStream(file);
			MudynLexer lexer = new MudynLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));
			//lexer = new MudynLexer(CharStreams.fromString("x=1;"));
			MudynParser parser = new MudynParser(new CommonTokenStream(lexer));
			return parser.dimp();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}