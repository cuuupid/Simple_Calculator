package simple_Calculator.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import simple_Calculator.Calculator;

public class AdditionTest {

	@Test
	public void test() {
		assertEquals(3, Calculator.addition(1, 2), 0.000001);
		assertEquals(0, Calculator.addition(0, 0), 0.000001);
		assertEquals(-1, Calculator.addition(1, -2), 0.000001);
		assertEquals(-3, Calculator.addition(-5, 2), 0.000001);
		assertEquals(-10, Calculator.addition(-3, -7), 0.000001);
	}

}
