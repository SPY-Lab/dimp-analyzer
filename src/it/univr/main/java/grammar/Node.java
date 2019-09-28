package grammar;

/**
 * Represent a node of Control Flow Graph.
 */
public class Node implements Comparable<Node>{
	private int id;

	public Node(int id) {
		this.id = id;
	}

    public String getId() {
		return String.valueOf(id);
    }

	@Override
	public String toString() {
		return String.valueOf(id);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Node && id == (((Node)obj).id);
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(id, o.id);
	}
}
