package domains;

/**
 * Abstract class of abstract values.
 * Defines the main common methods: greatest lower bound, least upper bound, widening.
 */
public abstract class AbstractValue {


	public AbstractValue leastUpperBound(AbstractValue d) {
		return TopAV.getInstance();
	}

	public AbstractValue greatestLowerBound(AbstractValue d) {
		return BottomAV.getInstance();
	}

	public AbstractValue widening(AbstractValue d) {
		return TopAV.getInstance();
	}

	public boolean isBottom(){
		return (this == BottomAV.getInstance());
	}

}
