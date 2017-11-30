package simple_Calculator.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import simple_Calculator.Calculator;

public class MultiplicationTest {

	@Test
	public void test() {
		assertEquals(25, Calculator.multiplication(5, 5), 0.000001);
		assertEquals(6, Calculator.multiplication(-3, -2), 0.000001);
		assertEquals(-10, Calculator.multiplication(-2, 5), 0.000001);
		assertEquals(0, Calculator.multiplication(3, 0), 0.000001);
		assertEquals(-25, Calculator.multiplication(5, -5), 0.000001);

	}
	
	

}
