package simple_Calculator.unitTests;

import static org.junit.Assert.*;

import simple_Calculator.Calculator;

public class SubtractionTest {

	@org.junit.Test
	public void subtractionWith_TwoPositiveIntegers_ResultPositive() {
		assertEquals(5, Calculator.subtraction(10, 5), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_TwoPositiveIntegers_ResultNegative() {
		assertEquals(-5, Calculator.subtraction(5, 10), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_TwoPositiveDoubles_ResultPositive() {
		assertEquals(0.3, Calculator.subtraction(5.4, 5.1), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_ZeroAndPositiveInteger_ResultPositive() {
		assertEquals(10, Calculator.subtraction(10, 0), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_ZeroAndPositiveInteger_ResultNegative() {
		assertEquals(-10, Calculator.subtraction(0, 10), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_ZeroAndPositiveDouble_ResultPositive() {
		assertEquals(10.3, Calculator.subtraction(10.3, 0), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_ZeroAndPositiveDouble_ResultNegative() {
		assertEquals(-10.3, Calculator.subtraction(-0, 10.3), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_TwoNegativeIntegers_ResultPositive() {
		assertEquals(2, Calculator.subtraction(-7, -9), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_TwoNegativeIntegers_ResultNegative() {
		assertEquals(-2, Calculator.subtraction(-9, -7), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_TwoNegativeDoubles_ResultPositive() {
		assertEquals(0.3, Calculator.subtraction(-5.1, -5.4), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_TwoNegativeDoubles_ResultNegative() {
		assertEquals(-0.3, Calculator.subtraction(-5.4, -5.1), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_ZeroAndNegativeInteger_ResultPositive() {
		assertEquals(5, Calculator.subtraction(0, -5), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_ZeroAndNegativeInteger_ResultNegative() {
		assertEquals(-5, Calculator.subtraction(-5, 0), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_ZeroAndNegativeDouble_ResultPositive() {
		assertEquals(10.45, Calculator.subtraction(0, -10.45), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_ZeroAndNegativeDouble_ResultNegative() {
		assertEquals(-10.45, Calculator.subtraction(-10.45, 0), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_Zeroes() {
		assertEquals(0, Calculator.subtraction(0, 0), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_PositiveAndNegativeIntegers_ResultPositive() {
		assertEquals(125, Calculator.subtraction(100, -25), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_PositiveAndNegativeIntegers_ResultNegative() {
		assertEquals(-125, Calculator.subtraction(-25, 100), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_PositiveAndNegativeDoubles_ResultPositive() {
		assertEquals(88.795, Calculator.subtraction(23.672, -65.123), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_PositiveAndNegativeDoubles_ResultNegative() {
		assertEquals(-88.795, Calculator.subtraction(-65.123, 23.672), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_PositiveAndNegativeIntegers_ResultZero() {
		assertEquals(0, Calculator.subtraction(50, 50), 0.0000001);
	}

	@org.junit.Test
	public void subtractionWith_PositiveAndNegativeDoubles_ResultZero() {
		assertEquals(0, Calculator.subtraction(50.76, 50.76), 0.0000001);
	}

	@org.junit.Test
	public void subtractionCallingItself() {
		assertEquals(10, Calculator.subtraction(Calculator.subtraction(20,5), Calculator.subtraction(15, 10)), 0.0000001);
	}

	@org.junit.Test(expected = ArithmeticException.class)
	public void subtractionWithUnderflow() {
		Calculator.subtraction(-Double.MAX_VALUE, Double.MAX_VALUE);
	}

}
