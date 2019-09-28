package interpreter;


import java.util.HashMap;
import java.util.Objects;
import java.util.function.BiConsumer;

import domains.AbstractValue;

public class AbstractHeap {

	private HashMap<AbstractLocation, AbstractValue> heap;

	public AbstractHeap() {
		heap = new HashMap<>();
	}

	public AbstractHeap widening(AbstractHeap heap) {
		// create a new abstract heap as the widending between this and the other heap
		AbstractHeap result = new AbstractHeap();
		// do the widening for each id
		for ( AbstractLocation id : this.heap.keySet() ){
			AbstractValue newvalue;
			// keep the same if there isn't the same id in s
			if ( heap.heap.keySet().contains(id))
				newvalue = this.heap.get(id).widening(heap.heap.get(id));
			else
				newvalue = this.heap.get(id);
			result.heap.put(id, newvalue);
		}
		// Add all the elements of the second heap not in this
		for ( AbstractLocation id : heap.heap.keySet()) {
			if (!this.heap.keySet().contains(id)) {
				result.heap.put(id, heap.heap.get(id));
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return heap.toString();
	}

	public AbstractHeap leastUpperBound(AbstractHeap h) {
		AbstractHeap result = new AbstractHeap();

		for ( AbstractLocation id : this.heap.keySet()){
			AbstractValue newvalue;
			if ( h.heap.keySet().contains(id))
				newvalue = this.heap.get(id).leastUpperBound(h.heap.get(id));
			else
				newvalue = this.heap.get(id);
			result.heap.put(id, newvalue);
		}
		// Add all the elements of the second heap not in this
		for ( AbstractLocation id : h.heap.keySet()) {
			if (!this.heap.keySet().contains(id)) {
				result.heap.put(id, h.heap.get(id));
			}
		}
		return result;
	}

	public boolean equals(AbstractHeap o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AbstractHeap that = (AbstractHeap) o;
		return heap.equals(that.heap);
	}

	@Override
	public int hashCode() {
		return Objects.hash(heap);
	}

	public void forEach(BiConsumer<AbstractLocation, AbstractValue> action){
		heap.forEach(action);
	}
}
