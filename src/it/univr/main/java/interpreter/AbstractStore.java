package interpreter;

import domains.*;
import interpreter.Exception.EvaluationException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * Class representing an abstract store.
 * It consist of a mapping between string identifiers and respective abstract values.
 */
public class AbstractStore {

	private HashMap<String, AbstractValue> store;

	/**
	 * Empty abstract store constructor.
	 */
	public AbstractStore() {
		this.store = new HashMap<>();
		store.put("top", AbstractBoolean.TopBool());
	}

	/**
	 * Return a new abstract store with the same values of this.
	 *
	 * @return a clone of this abstract store
	 */
	@Override
	protected AbstractStore clone() {
		AbstractStore result = new AbstractStore();
		result.store.putAll(store);
		return result;
	}

	/**
	 * Generate a new store in which identifier is updated with given new value.
	 *
	 * @param id identifier to update
	 * @param value new value for identifier
	 * @return new updated abstract store
	 */
	public AbstractStore update(String id, AbstractValue value) {
		// Clone the store and updates the value of id
		AbstractStore result = this.clone();
		result.store.put(id, value);
		return result;
	}

	/**
	 * Widening operation between two stores.
	 * Generate an empty abstract store.
	 * For each identifier in the stores, if it's contained in only one store, add it to new store, otherwise
	 * add the widening of its values.
	 *
	 * @param s the other store
	 * @return widening of the two stores
	 */
	public AbstractStore widening(AbstractStore s) {
		// create a new abstract store as the widending between this and the other store
		AbstractStore result = new AbstractStore();
		// do the widening for each id
		for ( String id : this.store.keySet() ){
			AbstractValue newvalue;
			// keep the same if there isn't the same id in s
			if ( s.store.keySet().contains(id))
				newvalue = this.store.get(id).widening(s.store.get(id));
			else
				newvalue = this.store.get(id);
			result.store.put(id, newvalue);
		}
		// Add all the elements of the second store not in this
		for ( String id : s.store.keySet()) {
			if (!this.store.keySet().contains(id)) {
				result.store.put(id, s.store.get(id));
			}
		}
		return result;
	}

	/**
	 * Return stored value associated with the identifier.
	 *
	 * @param id identifier
	 * @return value of identifier
	 */
    public AbstractValue getValue(String id) throws EvaluationException {
    	if (store.containsKey(id))
	    	return store.get(id);
    	throw new EvaluationException("Variable " + id + " used before initialization");
    }

	@Override
	public String toString() {
		HashMap<String, AbstractValue> clone = (HashMap<String, AbstractValue>) store.clone();
		clone.remove("top");
		return clone.toString();
	}

	public boolean equals(AbstractStore o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AbstractStore that = (AbstractStore) o;
		return store.equals(that.store);
	}

	@Override
	public int hashCode() {
		return Objects.hash(store);
	}

	public AbstractStore leastUpperBound(AbstractStore s) {
		AbstractStore result = new AbstractStore();

		for ( String id : this.store.keySet()){
			AbstractValue newvalue;
			if ( s.store.keySet().contains(id))
				newvalue = this.store.get(id).leastUpperBound(s.store.get(id));
			else
				newvalue = this.store.get(id);
			result.store.put(id, newvalue);
		}
		// Add all the elements of the second store not in this
		for ( String id : s.store.keySet()) {
			if (!this.store.keySet().contains(id)) {
				result.store.put(id, s.store.get(id));
			}
		}
		return result;
	}


	public void forEach(BiConsumer<String, AbstractValue> action){
    	store.forEach(action);
	}
}
