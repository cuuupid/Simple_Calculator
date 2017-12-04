package simple_Calculator.unitTests;

<<<<<<< HEAD
import simple_Calculator.Calculator;

import static org.junit.Assert.*;

public class RootTest {
    @org.junit.Test
    public void rootWith_PositiveInteger() {
        assertEquals(3.16227766, Calculator.root(10), 0.0000001);
    }

    @org.junit.Test
    public void rootWith_PositiveDouble() {
        assertEquals(2.28035085, Calculator.root(5.2), 0.0000001);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void rootWith_NegativeInteger() {
        Calculator.root(-5);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void rootWith_NegativeDouble() {
        Calculator.root(-5.2);
    }

    @org.junit.Test
    public void rootWith_Zero() {
        assertEquals(0, Calculator.root(0), 0.0000001);
    }

}
=======
import static org.junit.Assert.*;

import org.junit.Test;

import simple_Calculator.Calculator;

public class RootTest {

	@Test
	public void test() {
		assertEquals(5, Calculator.root(25), 0.000000001);
		assertEquals(0, Calculator.root(0), 0.000000001);
		assertEquals(7, Calculator.root(49), 0.000000001);
		assertEquals(Math.sqrt(10), Calculator.root(10), 0.000000001);
		assertEquals(Math.sqrt(0.1), Calculator.root(0.1), 0.000000001);
		assertEquals(Math.sqrt(1000000000.9132891), Calculator.root(1000000000.9132891), 0.000000001);

	}

}
>>>>>>> 5cc707f3033efb688ea8dd60bdbc06c7fd4f49d6
