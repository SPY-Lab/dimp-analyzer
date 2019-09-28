package domains;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AbstractBooleanTest {

	@Test
	public void or(){
		AbstractBoolean tt = AbstractBoolean.True();
		AbstractBoolean ff = AbstractBoolean.False();
		AbstractBoolean top = AbstractBoolean.TopBool();

		assertEquals(tt, tt.or(tt));
		assertEquals(tt, tt.or(ff));
		assertEquals(tt, ff.or(tt));
		assertEquals(ff, ff.or(ff));
		assertEquals(tt, tt.or(top));
		assertEquals(top, ff.or(top));
		assertEquals(tt, top.or(tt));
		assertEquals(top, top.or(ff));
	}

	@Test
	public void and(){
		AbstractBoolean tt = AbstractBoolean.True();
		AbstractBoolean ff = AbstractBoolean.False();
		AbstractBoolean top = AbstractBoolean.TopBool();

		assertEquals(tt, tt.and(tt));
		assertEquals(ff, tt.and(ff));
		assertEquals(ff, ff.and(tt));
		assertEquals(ff, ff.and(ff));
		assertEquals(top, tt.and(top));
		assertEquals(ff, ff.and(top));
		assertEquals(top, top.and(tt));
		assertEquals(ff, top.and(ff));
	}

	@Test
	public void not(){
		AbstractBoolean tt = AbstractBoolean.True();
		AbstractBoolean ff = AbstractBoolean.False();
		AbstractBoolean top = AbstractBoolean.TopBool();

		assertEquals(ff, tt.not());
		assertEquals(tt, ff.not());
		assertEquals(top, top.not());
	}

	@Test
	public void leastUpperBound(){
		AbstractBoolean tt = AbstractBoolean.True();
		AbstractBoolean ff = AbstractBoolean.False();
		AbstractBoolean top = AbstractBoolean.TopBool();

		assertEquals(tt, tt.leastUpperBound(tt));
		assertEquals(ff, ff.leastUpperBound(ff));
		assertEquals(top, tt.leastUpperBound(ff));
		assertEquals(top, ff.leastUpperBound(tt));
		assertEquals(top, top.leastUpperBound(top));
		assertEquals(top, tt.leastUpperBound(top));
		assertEquals(top, ff.leastUpperBound(top));
		assertEquals(top, top.leastUpperBound(tt));
		assertEquals(top, top.leastUpperBound(ff));
	}

	@Test
	public void greatestLowerBound() {
		AbstractBoolean tt = AbstractBoolean.True();
		AbstractBoolean ff = AbstractBoolean.False();
		AbstractBoolean top = AbstractBoolean.TopBool();
		BottomAV bottom = BottomAV.getInstance();

		assertEquals(tt, tt.greatestLowerBound(tt));
		assertEquals(ff, ff.greatestLowerBound(ff));
		assertEquals(tt, tt.greatestLowerBound(top));
		assertEquals(tt, top.greatestLowerBound(tt));
		assertEquals(ff, ff.greatestLowerBound(top));
		assertEquals(ff, top.greatestLowerBound(ff));
		assertEquals(top, top.greatestLowerBound(top));
		assertEquals(tt, tt.greatestLowerBound(tt));
		assertEquals(bottom, tt.greatestLowerBound(ff));
		assertEquals(bottom, ff.greatestLowerBound(tt));
	}
	
	@Test
	public void widening(){
		AbstractBoolean tt = AbstractBoolean.True();
		AbstractBoolean ff = AbstractBoolean.False();
		AbstractBoolean top = AbstractBoolean.TopBool();
		BottomAV bottom = BottomAV.getInstance();

		assertEquals(tt, tt.widening(tt));
		assertEquals(ff, ff.widening(ff));
		assertEquals(top, tt.widening(ff));
		assertEquals(top, ff.widening(tt));
		assertEquals(top, top.widening(top));
		assertEquals(top, tt.widening(top));
		assertEquals(top, ff.widening(top));
		assertEquals(top, top.widening(tt));
		assertEquals(top, top.widening(ff));
	}

	@Test
	public void toStringTest(){
		AbstractBoolean tt = AbstractBoolean.True();
		AbstractBoolean ff = AbstractBoolean.False();
		AbstractBoolean top = AbstractBoolean.TopBool();
		BottomAV bottom = BottomAV.getInstance();

		assertEquals("true", tt.toString());
		assertEquals("false", ff.toString());
		assertEquals("TopBool", top.toString());
		assertEquals("BottomValue", bottom.toString());
	}

	@Test
	public void equalsTest(){
		AbstractBoolean tt = AbstractBoolean.True();
		AbstractBoolean ff = AbstractBoolean.False();
		AbstractBoolean top = AbstractBoolean.TopBool();
		BottomAV bottom = BottomAV.getInstance();

		assertEquals(tt, tt.equalsValues(tt));
		assertEquals(tt, ff.equalsValues(ff));
		assertEquals(ff, tt.equalsValues(ff));
		assertEquals(ff, ff.equalsValues(tt));
		assertEquals(top, top.equalsValues(tt));
		assertEquals(top, top.equalsValues(ff));
		assertEquals(top, tt.equalsValues(top));
		assertEquals(top, ff.equalsValues(top));
	}
}
