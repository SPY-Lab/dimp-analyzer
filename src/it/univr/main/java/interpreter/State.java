package interpreter;


import java.util.Objects;

import domains.AbstractValue;
import interpreter.Exception.EvaluationException;

/**
 * Class representing the state of a program's point.
 * It consists of a pair: store and heap.
 * If it's null, the correspondent point of the execution cannot be reached.
 */
public class State {

	private AbstractStore store;
	private AbstractHeap heap;
	private boolean isnull;

	/**
	 * State constructor.
	 * Initialize fields with empty store and heap.
	 */
	public State() {
		this.store = new AbstractStore();
		this.heap = new AbstractHeap();
		this.isnull = false;
	}

	/**
	 * State constructor.
	 *
	 * @param store store of the state
	 * @param heap heap of the state
	 */
	public State(AbstractStore store, AbstractHeap heap) {
		this.store = store;
		this.heap = heap;
		this.isnull = false;
	}

	/**
	 * Factory field.
	 * Return an empty null state.
	 *
	 * @return a null state
	 */
	public static State nullState(){
		State s = new State();
		s.isnull = true;
		return s;
	}

	/**
	 * Update value of given identifier of this state.
	 * Generate a new state with store updated and same heap.
	 *
	 * @param id identifier to be updated
	 * @param value new value for the id
	 * @return updated state
	 */
	public State update(String id, AbstractValue value){
		return new State(store.update(id, value), heap);
	}

	/**
	 * Widening operation between two states.
	 * If one is null, return the other, otherwise return a new state with
	 * widening of their stores as store and widening of their heaps as heap.
	 *
	 * @param s the other state
	 * @return widening between the two states
	 */
	public State widening(State s) {
		if ( isnull )
			return s;
		if ( s.isnull)
			return this;

		return new State( store.widening(s.store), heap.widening(s.heap));
	}

	/**
	 * Least upper bound operation between two states.
	 * If one is null, return the other, otherwise return a new state with
	 * lub of their stores as store and lub of their heaps as heap.
	 *
	 * @param s the other state
	 * @return least upper bound between the two states
	 */
	public State leastUpperBound(State s){
		if ( isnull )
			return s;
		if ( s.isnull)
			return this;

		return new State(store.leastUpperBound(s.store), heap.leastUpperBound(s.heap));
	}

	/**
	 * Return value contained in store associated with the identifier.
	 *
	 * @param text identifier
	 * @return value associated with the identifier
	 */
	public AbstractValue getValue(String text) throws EvaluationException {
		return store.getValue(text);
	}

	/**
	 * Check if state is null.
	 *
	 * @return yes iff state is null
	 */
	public boolean isNull() {
		return isnull;
	}

	@Override
	public String toString() {
		if ( isnull)
			return "NULL!";

		return "State{" +
				"store=" + store +
				", heap=" + heap +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		State state = (State) o;
		return store.equals(state.store) &&
				heap.equals(state.heap) &&
				isnull == state.isnull;
	}

	@Override
	public int hashCode() {
		return Objects.hash(store, heap);
	}

	public AbstractStore getStore() {
		return store;
	}

	public AbstractHeap getHeap() {
		return heap;
	}
}
