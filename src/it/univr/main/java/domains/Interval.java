package domains;

import java.util.ArrayList;
import java.util.HashSet;

public class Interval extends AbstractValue {

	/**
	 * Bounds of the interval
	 */
	private String low;
	private String high;

	/** Static instance of top interval */
	private static Interval top = new Interval("-Inf", "+Inf");;

	/**
	 * Basic constructor. To express infinity use "+Inf" and "-Inf";
	 * @param low lower bound
	 * @param high higher bound
	 */
	public Interval(String low, String high) {
		this.low = low;
		this.high = high;
	}

	/**
	 * Builds a top interval
	 * @return top interval
	 */
	public static Interval topInterval(){
		return top;
	}

	public String getLow() {
		return low;
	}

	public String getHigh() {
		return high;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	@Override
	public String toString() {
		return "[" + low + ", " + high +  "]";
	}

	/**
	 * Calculates the least upper bound between this and another Interval.
	 * It does not overwrite the status of the "this" interval.
	 * @param v the other interval
	 * @return The result of the lub
	 */
	@Override
	public AbstractValue leastUpperBound(AbstractValue v) {
		if ( !(v instanceof Interval) )
			throw new IllegalArgumentException("v should be of type Interval");
		Interval i = (Interval) v;

		if (i.equals(top))
			return i;
		else if (i.isBottom())
			return this;

		String newLow, newHigh;

		if (this.getLow().equals("-Inf") || i.getLow().equals("-Inf"))
			newLow = "-Inf";
		else
			newLow = String.valueOf(Long.min(Long.parseLong(this.getLow()), Long.parseLong(i.getLow())));

		if (this.getHigh().equals("+Inf") || i.getHigh().equals("+Inf"))
			newHigh = "+Inf";
		else
			newHigh = String.valueOf(Long.max(Long.parseLong(this.getHigh()), Long.parseLong(i.getHigh())));

		Interval res = new Interval(newLow, newHigh);
		return amItop() ? top : res ;
	}

	/**
	 * Calculates the greatest lower bound between this and another Interval.
	 * It does not overwrite the status of the "this" interval.
	 * @param d the other interval
	 * @return The result of the glb
	 */
	@Override
	public AbstractValue greatestLowerBound(AbstractValue d) {
		if ( !(d instanceof Interval) )
			throw new IllegalArgumentException("v should be of type Interval");
		Interval i = (Interval) d;

		if (i.isBottom())
			return i;
		else if (i.equals(top))
			return this;

		String newLow = "-Inf", newHigh = "+Inf";

		//Calcolare limite inferiore

		if ( this.getLow().equals("-Inf")){
			if( !i.getLow().equals("-Inf"))
				if(Integer.parseInt(this.getHigh()) > Integer.parseInt(i.getLow()))
					newLow = String.valueOf(Integer.max(Integer.parseInt(this.getLow()), Integer.parseInt(i.getLow())));
				else
					return BottomAV.getInstance();
		}else if ( i.getLow().equals("-Inf")){
			if( !this.getLow().equals("-Inf"))
				if(Integer.parseInt(i.getHigh()) > Integer.parseInt(this.getLow()))
					newLow = String.valueOf(Integer.max(Integer.parseInt(i.getLow()), Integer.parseInt(this.getLow())));
				else
					return BottomAV.getInstance();
		}else if(!this.getLow().equals("-Inf") && !i.getLow().equals("-Inf")){
			newLow = String.valueOf(Integer.max(Integer.parseInt(this.getLow()), Integer.parseInt(i.getLow())));
		}

		// Calcolare limite superiore

		if ( this.getHigh().equals("+Inf")) {
			if (!i.getHigh().equals("+Inf"))
				newHigh = i.getHigh();
		}else if ( i.getHigh().equals("+Inf")) {
			if (!this.getHigh().equals("+Inf"))
				newHigh = this.getHigh();
		}else if(!this.getHigh().equals("+Inf") && !i.getHigh().equals("+Inf")){
			newHigh = String.valueOf(Integer.min(Integer.parseInt(this.getHigh()), Integer.parseInt(i.getHigh())));
		}

		Interval res = new Interval(newLow, newHigh);

		// Checks whether low > high
		if ((!newLow.equals("-Inf") && (!newHigh.equals("+Inf")) && Integer.parseInt(newLow) > Integer.parseInt(newHigh)))
			return BottomAV.getInstance();

		return amItop() ? top : res;
	}

	/**
	 * Calculates the widening between this and another Interval.
	 * It does not overwrite the status of the "this" interval.
	 * @param v the other interval
	 * @return The result of the widening
	 */
	public AbstractValue widening(AbstractValue v) {
		if ( !(v instanceof Interval) )
			throw new IllegalArgumentException("v should be of type Interval");
		Interval i = (Interval) v;

		Long maxI1 = this.getHigh().equals("+Inf") ? Integer.MAX_VALUE : Long.parseLong(this.getHigh());
		Long maxI2 = i.getHigh().equals("+Inf") ? Integer.MAX_VALUE : Long.parseLong(i.getHigh());
		Long minI1 = this.getLow().equals("-Inf") ? Integer.MIN_VALUE : Long.parseLong(this.getLow());
		Long minI2 = i.getLow().equals("-Inf") ? Integer.MIN_VALUE : Long.parseLong(i.getLow());

		String newLow, newHigh;
		if (minI2 < minI1)
			newLow = "-Inf";
		else
			newLow = this.getLow();

		if (maxI2 > maxI1)
			newHigh = "+Inf";
		else
			newHigh = this.getHigh();

		return new Interval(newLow, newHigh);
	}

	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Interval interval = (Interval) o;
		return low.equals(interval.low) &&
				high.equals(interval.high);
	}

	/**
	 * Check if the low value is -Inf.
	 * @return true if this low value is -Inf, false otherwise.
	 */
	public boolean isNegativeInfinite() {
		return this.getLow().equals("-Inf");
	}
	
	/**
	 * Check if the high value is +Inf.
	 * @return true if this high value is +Inf, false othewise.
	 */
	public boolean isPositiveInfinite() {
		return this.getHigh().equals("+Inf");
	}

	/*public boolean isInfinite(String s) {
		return isPositiveInfinite() || isNegativeInfinite();
	}
	*/

	/*
	public boolean isTopInterval() {
		return this.isNegativeInfinite() && this.isPositiveInfinite();
	}
	*/

	public ArrayList<Long> getIntergers() {
		long start = Long.parseLong(this.getLow());
		long end = Long.parseLong(this.getHigh());

		ArrayList<Long> result = new ArrayList<Long>();

		result.add(start);

		for (long i = start; i <= end; ++i) 
			if (!result.contains(i))
				result.add(i);


		return result;
	}

	@Override
	public int hashCode() {
		return (getLow() + getHigh()).hashCode();
	}

	@Override
	public Interval clone() {
		return new Interval(this.getLow(), this.getHigh());
	}

	/**
	 * Sums two intervals in a new one
	 * @param other interval
	 * @return the sum
	 */
	public Interval plus(Interval other) {
		Interval result = new Interval("", "");

		if (isNegativeInfinite() || other.isNegativeInfinite())
			result.setLow("-Inf");
		else {
			result.setLow(String.valueOf(Long.parseLong(this.getLow()) + Long.parseLong(other.getLow())));
		}

		if (isPositiveInfinite() || other.isPositiveInfinite())
			result.setHigh("+Inf");
		else {
			result.setHigh(String.valueOf(Long.parseLong(this.getHigh()) + Long.parseLong(other.getHigh())));
		}

		return result;
	}

	/**
	 * Calculates the difference between two intervals in a new one
	 * @param other interval
	 * @return the difference
	 */
	public Interval diff(Interval other) {
		return this.plus(other.mul(new Interval("-1", "-1")));
	}

	/**
	 * Multiplies two intervals in a new one
	 * @param other interval
	 * @return the product interval
	 */
	public Interval mul(Interval other) {
		HashSet<String> boundSet = new HashSet<>();

		String x1 = this.getLow();
		String x2 = this.getHigh();
		String y1 = other.getLow();
		String y2 = other.getHigh();

		// x1y1
		if (x1.equals("-Inf")) {
			if (y1.equals("-Inf"))
				boundSet.add("+Inf");
			else {
				if (Long.parseLong(y1) > 0)
					boundSet.add("-Inf");
				else if (Long.parseLong(y1) < 0)
					boundSet.add("+Inf");
				else
					boundSet.add("0");
			}
		} else if (y1.equals("-Inf")) {
			if (x1.equals("-Inf"))
				boundSet.add("+Inf");
			else {
				if (Long.parseLong(x1) > 0)
					boundSet.add("-Inf");
				else if (Long.parseLong(x1) < 0)
					boundSet.add("+Inf");
				else
					boundSet.add("0");
			}
		} else  {
			boundSet.add(String.valueOf(Long.parseLong(x1) * Long.parseLong(y1)));
		}

		// x1y2
		if (x1.equals("-Inf")) {
			if (y2.equals("+Inf"))
				boundSet.add("-Inf");
			else {
				if (Long.parseLong(y2) > 0)
					boundSet.add("-Inf");
				else if (Long.parseLong(y2) < 0)
					boundSet.add("+Inf");
				else 
					boundSet.add("0");
			}
		} else if (y2.equals("+Inf")) {
			if (x1.equals("-Inf"))
				boundSet.add("-Inf");
			else {
				if (Long.parseLong(x1) > 0)
					boundSet.add("+Inf");
				else if (Long.parseLong(x1) < 0)
					boundSet.add("-Inf");
				else 
					boundSet.add("0");
			}
		} else  {
			boundSet.add(String.valueOf(Long.parseLong(x1) * Long.parseLong(y2)));
		}

		// x2y1
		if (x2.equals("+Inf")) {
			if (y1.equals("-Inf"))
				boundSet.add("-Inf");
			else {
				if (Long.parseLong(y1) > 0)
					boundSet.add("+Inf");
				else if (Long.parseLong(y1) < 0)
					boundSet.add("-Inf");
				else 
					boundSet.add("0");
			}
		} else if (y1.equals("-Inf")) {
			if (x2.equals("+Inf"))
				boundSet.add("-Inf");
			else {
				if (Long.parseLong(x2) > 0)
					boundSet.add("-Inf");
				else if (Long.parseLong(x2) < 0)
					boundSet.add("+Inf");
				else 
					boundSet.add("0");
			}
		} else  {
			boundSet.add(String.valueOf(Long.parseLong(x2) * Long.parseLong(y1)));
		}

		// x2y2
		if (x2.equals("+Inf")) {
			if (y2.equals("+Inf"))
				boundSet.add("+Inf");
			else {
				if (Long.parseLong(y2) > 0)
					boundSet.add("+Inf");
				else if (Long.parseLong(y2) < 0)
					boundSet.add("-Inf");
				else
					boundSet.add("0");
			}
		} else if (y2.equals("+Inf")) {
			if (x2.equals("+Inf"))
				boundSet.add("+Inf");
			else {
				if (Long.parseLong(x2) > 0)
					boundSet.add("+Inf");
				else if (Long.parseLong(x2) < 0)
					boundSet.add("-Inf");
				else 
					boundSet.add("0");
			}
		} else  {
			boundSet.add(String.valueOf(Long.parseLong(x2) * Long.parseLong(y2)));
		}

		return new Interval(getMinValue(boundSet), getMaxValue(boundSet));
	}

	/**
	 * Return minimum value between set of values.
	 *
	 * @param set Set of strings containing integer values, "+Inf" or "-Inf".
	 * @return "-Inf" if present,
	 * 	       "+Inf" if all values have this value,
	 * 	       minimum concrete value found otherwise
	 */
	protected String getMinValue(HashSet<String> set) {
		Long min = Long.MAX_VALUE;
		int count = 0;

		for (String bound : set) 
			if (bound.equals("-Inf"))
				return "-Inf";
			else if (bound.equals("+Inf")) 
				count++;
			else if (Long.parseLong(bound) < min)
				min = Long.parseLong(bound);

		return count == 4 ? "+Inf" : String.valueOf(min);
	}

	/**
	 * Return maximum value between set of values.
	 *
	 * @param set Set of strings containing integer values, "+Inf" or "-Inf".
	 * @return "+Inf" if present,
	 * 	       "-Inf" if all values have this value,
	 * 	       maximum concrete value found otherwise
	 */
	protected String getMaxValue(HashSet<String> set) {
		Long max = Long.MIN_VALUE;
		int count = 0;

		for (String bound : set) 
			if (bound.equals("+Inf"))
				return "+Inf";
			else if (bound.equals("-Inf")) 
				count++;
			else if (Long.parseLong(bound) > max)
				max = Long.parseLong(bound);

		return count == 4 ? "-Inf" : String.valueOf(max);
	}

	/*
	public void changeSign() {
		Interval i = this.mul(new Interval("-1", "-1"));
		this.setLow(i.getLow());
		this.setHigh(i.getHigh());
	}
	*/

	/*
	public Interval div(Interval i2) {
		double denomLow = 1.0 / Integer.parseInt(i2.getLow());
		double denomHigh =  1.0 / Integer.parseInt(i2.getHigh());

		return new Interval(
				String.valueOf(Integer.parseInt(this.getLow()) * denomHigh),
				String.valueOf(Integer.parseInt(this.getHigh()) * denomLow));
	}
	 */

	/**
	 * Checks if the interval is top
	 * @return
	 */
	public boolean amItop(){
		if (this.getHigh().equals("+Inf") && this.getLow().equals("-Inf"))
			return true;
		return false;
	}

	/**
	 * Tells if this interval is less than other generating an abstract boolean
	 * @param other interval
	 * @return true, false or topbool;
	 */
	public AbstractBoolean less(Interval other){
		try {
			// If this.max < this.min then True
			if ((!this.high.equals("+Inf"))
					&& (!other.low.equals("-Inf"))
					&& Integer.parseInt(this.high) < Integer.parseInt(other.low))
				return AbstractBoolean.True();

			// If this.min > other.max then False
			if ((!other.high.equals("+Inf"))
					&& (!this.low.equals("-Inf"))
					&& Integer.parseInt(this.low) > Integer.parseInt(other.high))
				return AbstractBoolean.False();

		} catch (NumberFormatException e){
			return AbstractBoolean.TopBool();
		}

		return AbstractBoolean.TopBool();
	}

	/**
	 * Tells if this interval is greater than other generating an abstract boolean
	 * @param other interval
	 * @return true, false or topbool;
	 */
	public AbstractBoolean greater(Interval other){
		try {
			// If this.max > this.min then True
			if ((!this.low.equals("-Inf"))
					&& (!other.high.equals("+Inf"))
					&& Integer.parseInt(this.low) > Integer.parseInt(other.high))
				return AbstractBoolean.True();

			// If this.min < other.max then False
			if ((!other.low.equals("-Inf"))
					&& (!this.high.equals("+Inf"))
					&& Integer.parseInt(this.high) < Integer.parseInt(other.low))
				return AbstractBoolean.False();

		} catch (NumberFormatException e){
			return AbstractBoolean.TopBool();
		}

		return AbstractBoolean.TopBool();
	}

	/**
	 * Check if this is finite concrete, that is if its concretization is a finite set.
	 * @return true if the concretization of this is a finite set, false otherwise.
	 */
	public boolean isFiniteConcrete() {
		try {
			Long.parseLong(getLow());
			Long.parseLong(getHigh());
			return !low.equals("-Inf") && !high.equals("+Inf");
		} catch (NumberFormatException n){
			return false;
		}
	}
}
