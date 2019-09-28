package grammar;

import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Represent an edge between two nodes of CFG.
 */
public class Edge {

	/*
	classi etichettare archi:
	- AssignmentStmtContext
	- EvalContext
	- BooleanExpressionContext
	*/

	private Node v1, v2; /** this edge goes from node v1 to node v2 */

	/** Label of this edge, contains instruction, boolean condition or null. */
	private ParserRuleContext label;

	/**
	 * Edge constructor.
	 *
	 *
	 * @param v1 node from which this edge starts
	 * @param v2 node in which this edge ends
	 * @param label label of the edge
	 */
	public Edge(Node v1, Node v2, ParserRuleContext label) {
		this.v1 = v1;
		this.v2 = v2;
		this.label = label;
	}

	/**
	 * Returns the label of this edge.
	 * If it's null, returns an empty string. If it's an empty string, return "else".
	 *
	 * @return string representing this edge label
	 */
    public String getLabelString() {
		if (label == null)
			return "";
		return label.getText().equals("") ? "else" : label.getText();
    }
    
   public void setParseContext(ParserRuleContext l) {
	   label = l;
   }

	/**
	 * Return node from which this edge starts.
	 *
	 * @return node from which this edge starts.
	 */
	public Node getFrom() {
		return v1;
	}

	/**
	 * Returns node in which this edge ends.
	 *
	 * @return node in which this edge ends.
	 */
	public Node getTo(){
		return v2;
	}

	@Override
	public String toString() {
		return v1.toString() + " -> " + v2.toString();
	}

	public ParserRuleContext getLabel() {
		return label;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Edge && ((Edge)obj).v1.equals(v1) && ((Edge)obj).v2.equals(v2);
	}

	@Override
	public int hashCode() {
		return v1.hashCode() ^ v2.hashCode();
	}
}
