package simple_Calculator.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import simple_Calculator.Calculator;

public class SubtractionTest {

	@Test
	public void test() {
		assertEquals(-1, Calculator.subtraction(1, 2), 0.000001);
		assertEquals(0, Calculator.subtraction(0, 0), 0.000001);
		assertEquals(3, Calculator.subtraction(1, -2), 0.000001);
		assertEquals(-7, Calculator.subtraction(-5, 2), 0.000001);
		assertEquals(4, Calculator.subtraction(-3, -7), 0.000001);
	}

}
