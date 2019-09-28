package domains;


import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class IntervalTest {
    public Interval a = new Interval("4", "7");
    public Interval b = new Interval("5", "8");
    public Interval c = new Interval("12", "14");
    public Interval d = new Interval("-Inf", "2");
    public Interval e = new Interval("8", "+Inf");
    public Interval top = Interval.topInterval();
    

    @Test
    public void less() {
        assertEquals(a.less(b), AbstractBoolean.TopBool());
        assertEquals(a.less(c), AbstractBoolean.True());
        assertEquals(c.less(a), AbstractBoolean.False());
        assertEquals(c.less(top), AbstractBoolean.TopBool());
        assertEquals(top.less(b), AbstractBoolean.TopBool());
        assertEquals(d.less(a), AbstractBoolean.True());
        assertEquals(a.less(d), AbstractBoolean.False());
        assertEquals(a.less(e), AbstractBoolean.True());
        assertEquals(e.less(a), AbstractBoolean.False());
        assertEquals(e.less(d), AbstractBoolean.False());
        assertEquals(d.less(e), AbstractBoolean.True());
    }

    @Test
    public void greater() {
        assertEquals(a.greater(b), AbstractBoolean.TopBool());
        assertEquals(a.greater(c), AbstractBoolean.False());
        assertEquals(c.greater(a), AbstractBoolean.True());
        assertEquals(c.greater(top), AbstractBoolean.TopBool());
        assertEquals(top.greater(b), AbstractBoolean.TopBool());
        assertEquals(d.greater(a), AbstractBoolean.False());
        assertEquals(a.greater(d), AbstractBoolean.True());
        assertEquals(a.greater(e), AbstractBoolean.False());
        assertEquals(e.greater(a), AbstractBoolean.True());
        assertEquals(e.greater(d), AbstractBoolean.True());
        assertEquals(d.greater(e), AbstractBoolean.False());
    }

    @Test
    public void leastUpperBound() {
        assertEquals(a.leastUpperBound(b), new Interval("4", "8"));
        assertEquals(a.leastUpperBound(b), b.leastUpperBound(a));
        assertEquals(a.leastUpperBound(c), new Interval("4", "14"));
        assertEquals(b.leastUpperBound(d), new Interval("-Inf", "8"));
        assertEquals(d.leastUpperBound(e), top);
        assertEquals(c.leastUpperBound(top), top);
    }

    @Test
   public void greatestLowerBound() {
        assertEquals(a.greatestLowerBound(b), new Interval("5", "7"));
        assertEquals(a.greatestLowerBound(b), b.greatestLowerBound(a));
        assertEquals(a.greatestLowerBound(c), BottomAV.getInstance());
        assertEquals(b.greatestLowerBound(d), BottomAV.getInstance());
        assertEquals(d.greatestLowerBound(top), d);
        assertEquals(e.greatestLowerBound(c), c);
    }

    @Test
    public void widening() {
        assertEquals(a.widening(b), new Interval("4", "+Inf"));
        assertEquals(a.widening(c), new Interval("4", "+Inf"));
        assertEquals(b.widening(d), new Interval("-Inf", "8"));
        assertEquals(d.widening(top), top);
        assertEquals(e.widening(c), new Interval("8", "+Inf"));
    }

    @Test
    public void plus() {
        assertEquals(a.plus(b), new Interval("9", "15"));
        assertEquals(a.plus(b), b.plus(a));
        assertEquals(a.plus(c), new Interval("16", "21"));
        assertEquals(b.plus(d), new Interval("-Inf", "10"));
        assertEquals(d.plus(e), top);
        assertEquals(c.plus(top), top);
    }

    @Test
    public void diff() {
        assertEquals(a.diff(b), new Interval("-4", "2"));
        assertEquals(a.diff(c), new Interval("-10", "-5"));
        assertEquals(b.diff(d), new Interval("3", "+Inf"));
        assertEquals(d.diff(e), new Interval("-Inf", "-6"));
        assertEquals(c.diff(top), top);
    }

    @Test
    public void mul() {
        assertEquals(a.mul(b), new Interval("20", "56"));
        assertEquals(a.mul(b), b.mul(a));
        assertEquals(a.mul(c), new Interval("48", "98"));
        assertEquals(b.mul(d), new Interval("-Inf", "16"));
        assertEquals(d.mul(e), top);
        assertEquals(c.mul(top), top);
    }

}