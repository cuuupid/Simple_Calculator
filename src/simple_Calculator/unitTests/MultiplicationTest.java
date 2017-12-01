package simple_Calculator.unitTests;

import static org.junit.Assert.*;


import simple_Calculator.Calculator;

public class MultiplicationTest {

	@org.junit.Test
	public void multiplicationWith_PositiveIntegers() throws Exception{
		assertEquals(20, Calculator.multiplication(5, 4), 0.0000001);
	}

	@org.junit.Test
	public void multiplicationWith_PositiveDoubles() throws Exception{
		assertEquals(23.3781, Calculator.multiplication(5.23, 4.47), 0.0000001);
	}

	@org.junit.Test
	public void multiplicationWith_ZeroAndPositiveInteger() throws Exception{
		assertEquals(0, Calculator.multiplication(0, 3), 0.0000001);
		assertEquals(0, Calculator.multiplication(3, 0), 0.0000001);
	}

	@org.junit.Test
	public void multiplicationWith_ZeroAndNegativeInteger() throws Exception{
		assertEquals(0, Calculator.multiplication(0, -3), 0.0000001);
		assertEquals(0, Calculator.multiplication(-3, 0), 0.0000001);
	}

	@org.junit.Test
	public void multiplicationWith_ZeroAndPositiveDouble() throws Exception{
		assertEquals(0, Calculator.multiplication(0, 4.423), 0.0000001);
		assertEquals(0, Calculator.multiplication(3.352, 0), 0.0000001);
	}

	@org.junit.Test
	public void multiplicationWith_ZeroAndNegativeDouble() throws Exception{
		assertEquals(0, Calculator.multiplication(0, -4.423), 0.0000001);
		assertEquals(0, Calculator.multiplication(-3.352, 0), 0.0000001);
	}

	@org.junit.Test
	public void multiplicationWith_NegativeIntegers() throws Exception{
		assertEquals(60, Calculator.multiplication(-20, -3), 0.0000001);
	}

	@org.junit.Test
	public void multiplicationWith_NegativeDoubles() throws Exception{
		assertEquals(14.19783, Calculator.multiplication(-3.21, -4.423), 0.0000001);
	}

	@org.junit.Test
	public void multiplicationWith_Zeroes() throws Exception{
		assertEquals(0, Calculator.multiplication(0, 0), 0.0000001);
	}

	@org.junit.Test
	public void multiplicationWith_PositiveAndNegativeIntegers() throws Exception{
		assertEquals(-48, Calculator.multiplication(-12, 4), 0.0000001);
		assertEquals(-48, Calculator.multiplication(4, -12), 0.0000001);
	}

	@org.junit.Test
	public void multiplicationWith_PositiveAndNegativeDoubles() throws Exception{
		assertEquals(-55.40643, Calculator.multiplication(-12.231, 4.53), 0.0000001);
		assertEquals(-55.40643, Calculator.multiplication(4.53, -12.231), 0.0000001);
	}

	@org.junit.Test
	public void multiplicationCallingItself() throws Exception{
		assertEquals(360, Calculator.multiplication(Calculator.multiplication(4, 5), Calculator.multiplication(6, 3)), 0.0000001);
	}

	@org.junit.Test(expected = ArithmeticException.class)
	public void multiplicationWithOverflow() throws Exception{
		Calculator.multiplication(Double.MAX_VALUE, Double.MAX_VALUE);
	}

	@org.junit.Test(expected = ArithmeticException.class)
	public void multiplicationWithUnderflow() throws Exception{
		Calculator.multiplication(Double.MAX_VALUE, -Double.MAX_VALUE);
	}
}
