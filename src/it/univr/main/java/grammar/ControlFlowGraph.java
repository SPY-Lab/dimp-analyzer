package grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import org.antlr.v4.runtime.ParserRuleContext;

import grammar.antlr.*;
import grammar.graphStream.CfgPrinter;

/**
 * Represents a Control Flow Graph.
 */
public class ControlFlowGraph extends MudynBaseVisitor {
	private TreeSet<Node> nodes; /** Nodes of this CFG. */
	private HashSet<Edge> edges; /** Edges between nodes. */
	private HashSet<Node> entryNode; /** Set of entry nodes of this CFG. */
	private HashSet<Node> exitNode; /** Set of exit nodes of this CFG. */
	private HashMap<Node, ArrayList<Edge>> entryEdge; /** Associates each node with the list of its entry edges. */
	private CfgPrinter mCfgPrinter; /** Printer for this CFG. */

	/** Empty CFG constructor. Initialize each field with an empty set. */
	public ControlFlowGraph() {
		nodes = new TreeSet<Node>();
		edges = new HashSet<Edge>();
		entryNode = new HashSet<Node>();
		exitNode = new HashSet<Node>();
	}

	/** CFG constructor. */
	public ControlFlowGraph(TreeSet<Node> nodes, HashSet<Edge> edges, HashSet<Node> entryNode, HashSet<Node> exitNode) {
		this.nodes = nodes;
		this.edges = edges;
		this.entryNode = entryNode;
		this.exitNode = exitNode;
	}

	/**
	 * Factory method.
	 * Generate and return a CFG with a single node, which is also its entry node and exit node.
	 *
	 * @param i id to be assigned to the single node
	 * @return a CFG with a single node with id i
	 */
	public static ControlFlowGraph singleNodeCFG(int i) {
		ControlFlowGraph cfg = new ControlFlowGraph();
		Node n = new Node(i);
		cfg.addNode(n);
		cfg.addEntryNode(n);
		cfg.addExitNode(n);
		return cfg;
	}

	public TreeSet<Node> getNodes() {
		return nodes;
	}

	/**
	 * Add nodes to this CFG.
	 *
	 * @param n node or nodes to be added
	 */
	public void addNode(Node ... n){
		this.nodes.addAll(Arrays.asList(n));
	}

	/**
	 * Add nodes to entry node set.
	 *
	 * @param n node or nodes to be added
	 */
	public void addEntryNode(Node ... n){
		this.entryNode.addAll(Arrays.asList(n));
	}

	/**
	 * Add nodes to exit node set.
	 *
	 * @param n node or nodes to be added
	 */
	public void addExitNode(Node ... n){
		this.exitNode.addAll(Arrays.asList(n));
	}

	/**
	 * Add edges to this CFG.
	 *
	 * @param e edge or edges to be added
	 */
	public void addEdge(Edge ... e){
		this.edges.addAll(Arrays.asList(e));
	}

	@Override
	public String toString() {
		return "\t\tNodi\n\t\t" + nodes.toString() + "\n\t\tArchi\n\t\t" + edges.toString() + "\n\t\tIniziali: " + entryNode + ". Finali: " + exitNode;
	}

	/**
	 * Concatenate this CFG exit nodes with child CFG entry nodes with new empty edges.
	 *
	 * @param child CFG to be concatenated
	 * @see #concat(ControlFlowGraph)
	 */
	public void concatOld(ControlFlowGraph child) {
		nodes.addAll(child.nodes);
		edges.addAll(child.edges);
		for (Node u : exitNode)
			for (Node v : child.entryNode)
				edges.add(new Edge(u, v, null));
		exitNode = child.exitNode;
	}

	/**
	 * Concatenate this CFG with given CFG.
	 * For each exit node generate an edge with the successors of each entry node of child CFG.
	 * If the child's edge between entry node and successor has a label, assign the same label to the new edge.
	 * Then, remove all entry nodes of child CFG.
	 *
	 * @param child CFG to be concatenated
	 */
	public void concat(ControlFlowGraph child){
		if (child.nodes.size() == 1 || child.isLoop())
			concatOld(child);
		else {
			for (Edge e : child.edges) {
				if (child.entryNode.contains(e.getFrom()))
					for (Node u : exitNode) {
						edges.add(new Edge(u, e.getTo(), e.getLabel()));
						nodes.add(e.getTo());
					}
				else {
					edges.add(e);
					nodes.add(e.getFrom());
					nodes.add(e.getTo());
				}
			}
			exitNode = child.exitNode;
		}
	}

	/**
	 * Check if any edge's destination is an entry node.
	 *
	 * @return yes if an edge goes in an entry node, no otherwise.
	 */
	private boolean isLoop() {
		for (Edge e : edges)
			if (entryNode.contains(e.getTo()))
				return true;
		return false;
	}

	/**
	 * Append given CFG to root node with a new edge.
	 *
	 * @param root node to which append the CFG
	 * @param child CFG to append
	 * @param label label of new edge
	 */
	public void appendToNode(Node root, ControlFlowGraph child, ParserRuleContext label) {
		// System.out.println("entry node del figlio" + child.entryNode + " e i suoi archi " + child.edges);
		HashSet<Node> exitNodesTmp = exitNode;
		exitNode = new HashSet<>();
		exitNode.add(root);
		concat(child);
		exitNode.addAll(exitNodesTmp);
	}

	/**
	 * Return entry edges of node n.
	 *
	 * @param n node of which return entry edges
	 * @return entry edges of node n
	 */
	public ArrayList<Edge> getEdgeTo(Node n){
		if ( entryEdge == null )
			buildEntryEdge();
		return entryEdge.get(n);
	}

	/**
	 * Build map between nodes and list of entry edges.
	 */
	private void buildEntryEdge() {
		entryEdge = new HashMap<>();

		for (Node n : entryNode)
			entryEdge.put(n, new ArrayList<>());

		for( Edge e : edges){
			if ( ! entryEdge.keySet().contains(e.getTo()))
				entryEdge.put(e.getTo(), new ArrayList<>());
			entryEdge.get(e.getTo()).add(e);
		}
	}

	public HashSet<Edge> getEdges() {
		return edges;
	}

	public HashSet<Node> getEntryNode() {
		return entryNode;
	}

	public HashSet<Node> getExitNodes() {
		return exitNode;
	}

	public Node getFirstNode() {
		return nodes.first();
	}

	public CfgPrinter getPrinter() {
		if (mCfgPrinter == null)
			mCfgPrinter = new CfgPrinter(this);
		return mCfgPrinter;
	}
}