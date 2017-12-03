package simple_Calculator.unitTests;

import static org.junit.Assert.*;


import simple_Calculator.Calculator;

public class SquareTest {

	@org.junit.Test
	public void squareWith_PostiveInteger(){
		assertEquals(16, Calculator.square(4), 0.0000001);
	}

	@org.junit.Test
	public void squareWith_Postivedouble(){
		assertEquals(18.49, Calculator.square(4.3), 0.0000001);
	}

	@org.junit.Test
	public void squareWith_NegativeInteger(){
		assertEquals(16, Calculator.square(-4), 0.0000001);
	}

	@org.junit.Test
	public void squareWith_NegativeDouble(){
		assertEquals(18.49, Calculator.square(-4.3), 0.0000001);
	}

	@org.junit.Test
	public void squareWith_Zero(){
		assertEquals(0, Calculator.square(0), 0.0000001);
	}

	@org.junit.Test(expected = ArithmeticException.class)
	public void squareWith_Overflow(){
		Calculator.square(Double.MAX_VALUE);
	}

}
