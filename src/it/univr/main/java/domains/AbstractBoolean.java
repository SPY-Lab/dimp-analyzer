package domains;

/**
 * Abstract boolean class.
 * An abstract boolean can be created by passing to the constructor one of the following integers:
 * 
 * 0 => false
 * 1 => true
 * 2 => top
 * 
 * @author <a href="mailto:my_email@email.exmaple.com">Vincenzo Arceri</a>
 */

public class AbstractBoolean extends AbstractValue {

	/** True static value */
	private static byte ABS_TRUE = 1;
	
	/** False static value */
	private static byte ABS_FALSE = 0;
	
	/** Top boolean static value */
	private static byte ABS_TOPBOOL = 2;

	/** Abstract boolean value */
	private byte value;

	/**
	 * Abstract boolean constructor.
	 * 
	 * @param value byte identifying an abstract boolean.
	 */
	private AbstractBoolean(byte value) {
		this.value = value;
	}

	/**
	 * Factory method.
	 * @return new Abstract Boolean with value set true.
	 */
	public static AbstractBoolean True() { return new AbstractBoolean(ABS_TRUE); }

	/**
	 * Factory method.
	 * @return new Abstract Boolean with value set false.
	 */
	public static AbstractBoolean False() {  return new AbstractBoolean(ABS_FALSE); }

	/**
	 * Factory method.
	 * @return new Abstract Boolean with value set top.
	 */
	public static AbstractBoolean TopBool() { return new AbstractBoolean(ABS_TOPBOOL); }

	/**
	 * Check if this is finite concrete, i.e. is true or false.
	 * 
	 * @return true iff the abstract boolean value is not top, false otherwise.
	 */
	/*
	public boolean isFiniteConcrete() {
		return this.value == ABS_TRUE || this.value == ABS_FALSE;
	}
	*/

	public boolean isTrue() {
		return value == ABS_TRUE;
	}

	public boolean isFalse() {
		return value == ABS_FALSE;
	}

	public boolean isTopBool() {
		return value == ABS_TOPBOOL;
	}


	/**
	 * Negation of an abstract booleans.
	 *
	 * @return the negation of this abstract boolean.
	 */
	public AbstractBoolean not() {
		if (this.isTrue())
			return new AbstractBoolean(ABS_FALSE);
		else if (this.isFalse())
			return new AbstractBoolean(ABS_TRUE);
		else
			return new AbstractBoolean(ABS_TOPBOOL);
	}

	/**
	 * Or operation between two abstract booleans.
	 *
	 * @param other the other abstract boolean value
	 * @return the or result between this and other
	 */
	public AbstractBoolean or(AbstractBoolean other) {
		if (this.isTrue() || other.isTrue()) 
			return new AbstractBoolean(ABS_TRUE);
		else if (this.isTopBool() || other.isTopBool()) 
			return new AbstractBoolean(ABS_TOPBOOL); 
		else
			return new AbstractBoolean(ABS_FALSE);
	}

	/**
	 * And operation between two abstract booleans.
	 * 
	 * @param other the other abstract boolean value
	 * @return the and result between this and other
	 */
	public AbstractBoolean and(AbstractBoolean other) {
		if (other.isFalse() || this.isFalse())
			return new AbstractBoolean(ABS_FALSE);
		else if (other.isTrue() && this.isTrue())
			return new AbstractBoolean(ABS_TRUE);

		return new AbstractBoolean(ABS_TOPBOOL);
	}

	public String toString() {
		if (value == 0)
			return "false";
		else if (value == 1)
			return "true";
		else if ( value == 2)
			return "TopBool";
		else
			return "BottomBool";
	}

	/*
	@Override
	public EvaluationExpression evaluate(AbstractEnvironment m) throws VariableNotDeclaredException, NotImplementedException {
		return new EvaluationExpression(this);
	}
	 */

	public boolean equals(Object other) {
		if (other instanceof AbstractBoolean)
			return value == ((AbstractBoolean) other).value;
		return false;
	}

	/**
	 * Equivalence between abstract booleans.
	 * Returns a new Abstract Boolean with value:
	 *   top if this or other are top
	 *   true if this and other have the same value
	 *   false otherwise
	 *
	 * @param other the other abstract boolean
	 * @return a new Abstract Boolean with computed value
	 */
	public AbstractBoolean equalsValues(Object other) {
        if (other instanceof AbstractBoolean){
            if (this.isTopBool() || ((AbstractBoolean) other).isTopBool())
                return TopBool();
            if (this.equals(other))
                return True();
            return False();
        }
        return False();
    }

	/**
	 * Replication of the abstract boolean.
	 *
	 * @return a new abstract boolean with the same value of this.
	 */
	/*
	public AbstractBoolean clone() {
		return new AbstractBoolean(value);
	}
	 */

	/*
	public AbstractBoolean toPrimitiveBoolean() {
		return clone();
	}
	 */

	/*
	public Interval toPrimitiveNumber() {
		if (isTrue())
			return new Interval("1", "1");
		else if (isFalse())
			return new Interval("0", "0");
		else if (isTopBool())
			return new Interval("-Inf", "+Inf");
		else
			return new Interval("-", "-");
	}
	 */

	/**
	 * Least upper bound operation on two abstract booleans.
	 * If this and that have the same value, return it, otherwise return top.
	 *
	 * @param d the other abstract boolean value
	 * @return the least upper bound between this and d
	 */
	@Override
	public AbstractValue leastUpperBound(AbstractValue d) {
		if ( this.value == ((AbstractBoolean) d).value)
			return new AbstractBoolean(this.value);
		else
			return new AbstractBoolean(ABS_TOPBOOL);
	}

	/**
	 * Greatest lower bound operation on two abstract booleans.
	 * If this or that are top, return top.
	 * If this and that have the same value, return it, otherwise return top.
	 *
	 * @param d the other abstract boolean value
	 * @return the greatest lower bound between this and d
	 */
	@Override
	public AbstractValue greatestLowerBound(AbstractValue d) {
		if (this.isTopBool())
			return d;
		else if (((AbstractBoolean) d).isTopBool())
			return this;
		else if( this.value == ((AbstractBoolean) d).value)
			return new AbstractBoolean(this.value);
		else
			return BottomAV.getInstance();
	}

	/**
	 * Widening operation on two abstract booleans,
	 *
	 * @param d the other abstract boolean
	 * @return the greatest lower bound between this and d
	 */
	@Override
	public AbstractValue widening(AbstractValue d) {
		return this.leastUpperBound(d);
	}
}
