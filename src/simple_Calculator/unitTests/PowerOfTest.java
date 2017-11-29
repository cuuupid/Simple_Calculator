package simple_Calculator.unitTests;


import static org.junit.Assert.*;

import org.junit.Test;

import simple_Calculator.Calculator;

public class PowerOfTest {

	@Test
	public void test() {		
		assertEquals(1, Calculator.powerOf(10, 0), 0.00001);
		assertEquals(10, Calculator.powerOf(10, 1), 0.00001);
		assertEquals(100, Calculator.powerOf(10, 2), 0.00001);
		assertEquals(1000, Calculator.powerOf(10, 3), 0.00001);
		assertEquals(10000, Calculator.powerOf(10, 4), 0.00001);
		assertEquals(100000, Calculator.powerOf(10, 5), 0.00001);
		assertEquals(1000000, Calculator.powerOf(10, 6), 0.00001);
		assertEquals(0.1, Calculator.powerOf(10, -1), 0.00001);
		assertEquals(0.01, Calculator.powerOf(10, -2), 0.00001);
		assertEquals(0.001, Calculator.powerOf(10, -3), 0.00001);
		assertEquals(0.0001, Calculator.powerOf(10, -4), 0.00001);
		assertEquals(0.00001, Calculator.powerOf(10, -5), 0.00001);	
		assertEquals(1, Calculator.powerOf(0, 0), 0.00001);
	}

}
