package grammar;

import org.antlr.v4.runtime.tree.ParseTree;

import grammar.antlr.CustomNegationContext;
import grammar.antlr.MudynBaseVisitor;
import grammar.antlr.MudynParser;

import java.util.concurrent.atomic.AtomicInteger;

public class CFGGenerator extends MudynBaseVisitor<ControlFlowGraph> {

    private ParseTree tree;
    private ControlFlowGraph cfg;
    private AtomicIntegerSingleton nodeGenerator;

	/**
	 * CFGGenerator constructor.
	 *
	 * @param tree parse tree of JS program.
	 */
	public CFGGenerator(ParseTree tree) {
        this.tree = tree;
        cfg = null;
        nodeGenerator = AtomicIntegerSingleton.getInstance();
    }

	/**
	 * Return CFG obtained visiting the parse tree.
	 *
	 * @return CFG of given tree.
	 */
	public ControlFlowGraph getCFG() {
		if (cfg == null)
        	cfg = visit(tree);
        return cfg;
    }

	// ++++++++++ Parser statement +++++++++++

	/**
	 * Concatenate two CFG into a new control flow graph.
	 *
	 * @param aggregate first CFG
	 * @param nextResult second CFG
	 * @return first CFG concatenated with second one.
	 */
	@Override
	protected ControlFlowGraph aggregateResult(ControlFlowGraph aggregate, ControlFlowGraph nextResult) {
		if (nextResult != null)
			aggregate.concat(nextResult);
		return aggregate;
	}

	/**
	 * Return a new, empty CFG.
	 * @return a new, empty CFG.
	 */
	@Override
	protected ControlFlowGraph defaultResult() {
		return new ControlFlowGraph();
	}

	// ++++++++++ Mudyn Statements +++++++++++

	@Override
	public ControlFlowGraph visitProgramExecution(MudynParser.ProgramExecutionContext ctx) {
		System.out.println("Visito ProgramExecutionContext " + ctx.getText());
		ControlFlowGraph child = visit(ctx.comm());
        System.out.println("Il cfg è\n" + child);
		return child;
	}

	/**
	 * Generate CFG of given assignment context.
	 * It consist of two nodes, connected by an edge with given context as label.
	 *
	 * @param ctx assignment context
	 * @return CFG representing given context
	 */
	@Override
	public ControlFlowGraph visitAssignmentStmt(MudynParser.AssignmentStmtContext ctx) {
		System.out.println("Visito " + ctx.getText());
		ControlFlowGraph cfg = new ControlFlowGraph();
        Node n1 = new Node(nodeGenerator.getAndIncrement()),
             n2 = new Node(nodeGenerator.getAndIncrement());
        Edge e = new Edge(n1, n2, ctx);
        cfg.addNode(n1, n2);
		cfg.addEdge(e);
		cfg.addEntryNode(n1);
		cfg.addExitNode(n2);
		return cfg;
	}

	/**
	 * Generate CFG of given block context.
	 * If block is empty, return a new CFG with a single node,
	 * otherwise visit the block context.
	 *
	 * @param ctx block of instructions context
	 * @return CFG representing given block context
	 */
	@Override
	public ControlFlowGraph visitBlock(MudynParser.BlockContext ctx) {
		System.out.println("Visito " + ctx.getText());
		if (ctx.comm() != null)
			return visit(ctx.comm());
		Node theChosenOne = new Node(nodeGenerator.getAndIncrement());
		ControlFlowGraph empty = new ControlFlowGraph();
		empty.addNode(theChosenOne);
		empty.addEntryNode(theChosenOne);
		empty.addExitNode(theChosenOne);
		return empty;
	}
	
	@Override
	public ControlFlowGraph visitSkip(MudynParser.SkipContext ctx) {
		System.out.println("Visito " + ctx.getText());
		ControlFlowGraph cfg = new ControlFlowGraph();
        Node n1 = new Node(nodeGenerator.getAndIncrement()),
             n2 = new Node(nodeGenerator.getAndIncrement());
        Edge e = new Edge(n1, n2, ctx);
        cfg.addNode(n1, n2);
		cfg.addEdge(e);
		cfg.addEntryNode(n1);
		cfg.addExitNode(n2);
		return cfg;
	}

	/**
	 * Generate CFG of given instruction composition context.
	 * Return a new CFG consisting of CFG obtained visiting the first instruction
	 * of the composition, concatenated to the CFG obtained visiting the second one.
	 *
	 * @param ctx two instruction composition context
	 * @return CFG representing given composition context
	 */
	public ControlFlowGraph visitComposition(MudynParser.CompositionContext ctx) {
		System.out.println("Visito " + ctx.getText());
		ControlFlowGraph cfg = visit(ctx.comm(0));
        cfg.concat(visit(ctx.comm(1)));
        return cfg;
	}

	/**
	 * Generate CFG of given eval context.
	 * It consist of two nodes, connected by an edge with given eval context as label.
	 *
	 * @param ctx eval context
	 * @return CFG representing given eval context
	 */
	public ControlFlowGraph visitEval(MudynParser.EvalContext ctx) {
		System.out.println("Visito EvalContext " + ctx.getText());
		ControlFlowGraph cfg = new ControlFlowGraph();
		Node n1 = new Node(nodeGenerator.getAndIncrement()),
			 n2 = new Node(nodeGenerator.getAndIncrement());
		Edge e = new Edge(n1, n2, ctx);
		cfg.addNode(n1, n2);
		cfg.addEdge(e);
		cfg.addEntryNode(n1);
		cfg.addExitNode(n2);
		return cfg;
	}

	/**
	 * Generate CFG of given if statement context.
	 * It consist of a root node, two CFG and an exit node.
	 * These two CFG are obtained visiting the two blocks of if statement,
	 * related to the cases of true guard and false guard.
	 * Root node is connected to these CFG with an edge labeled with condition
	 * and negated condition, respectively. Both are connected to exit node
	 * with empty-labeled edges.
	 *
	 * @param ctx if statement context
	 * @return CFG representing given if statement context
	 */
	@Override
	public ControlFlowGraph visitIfStmt(MudynParser.IfStmtContext ctx) {
		System.out.println("Visito " + ctx.getText());
		ControlFlowGraph ifCfg = new ControlFlowGraph();
		Node root = new Node(nodeGenerator.getAndIncrement()),
			 trueNode = new Node(nodeGenerator.getAndIncrement()),
			 falseNode = new Node(nodeGenerator.getAndIncrement());

		ifCfg.addNode(root, trueNode, falseNode);
		ifCfg.addEntryNode(root);
		ifCfg.addEdge(new Edge(root, trueNode, ctx.exp()));
		ifCfg.addEdge(new Edge(root, falseNode, new CustomNegationContext( ctx.exp())));

		ControlFlowGraph thenCfg = visit(ctx.block(0)),
						 elseCfg = visit(ctx.block(1));

		ifCfg.appendToNode(trueNode, thenCfg, null);
		ifCfg.appendToNode(falseNode, elseCfg, null);

		Node exit = new Node(nodeGenerator.getAndIncrement());
		ControlFlowGraph exitCfg = new ControlFlowGraph();
		exitCfg.addNode(exit);
		exitCfg.addEntryNode(exit);
		exitCfg.addExitNode(exit);

		ifCfg.concat(exitCfg);
		return ifCfg;
	}

	/**
	 * Generate CFG of given while context.
	 * It consist of a root node, CFG of while statement block and an exit node.
	 * The root node is first and last node of while cycle, and its connected with
	 * the exit node too.
	 *
	 * @param ctx while context
	 * @return CFG representing given while context
	 */
	@Override
	public ControlFlowGraph visitWhileStmt(MudynParser.WhileStmtContext ctx) {
		System.out.println("Visito " + ctx.getText());
		ControlFlowGraph wCfg = new ControlFlowGraph();

		Node root = new Node(nodeGenerator.getAndIncrement()),
			 trueNode = new Node(nodeGenerator.getAndIncrement());

		wCfg.addNode(root, trueNode);
		wCfg.addEntryNode(root);
		wCfg.addEdge(new Edge(root, trueNode, ctx.exp()));

		ControlFlowGraph doCfg = visit(ctx.block());
		System.out.println("blocco\n" + doCfg);

		ControlFlowGraph doneCfg = new ControlFlowGraph();
		doneCfg.addNode(root);
		doneCfg.addEntryNode(root);

		doCfg.concat(doneCfg);

		wCfg.appendToNode(trueNode, doCfg, null);

		Node exit = new Node(nodeGenerator.getAndIncrement());
		wCfg.addNode(exit);
		wCfg.addExitNode(exit);
		wCfg.addEdge(new Edge(root, exit, new CustomNegationContext( ctx.exp() )));

		System.out.println(wCfg);

		return wCfg;
	}

}