package simple_Calculator.unitTests;


import static org.junit.Assert.*;

import simple_Calculator.Calculator;

public class PowerOfTest {

	@org.junit.Test
	public void powerOfWith_PositiveInteger_PositiveExp(){
		assertEquals(100000, Calculator.powerOf(10, 5), 0.0000001);
	}

	@org.junit.Test
	public void powerOfWith_PositiveDouble_PositiveExp(){
		assertEquals(127628.15625, Calculator.powerOf(10.5, 5), 0.0000001);
	}

	@org.junit.Test
	public void powerOfWith_PositiveInteger_NegativeExp(){
		assertEquals(0.00001, Calculator.powerOf(10, -5), 0.0000001);
	}

	@org.junit.Test
	public void powerOfWith_PositiveDouble_NegativeExp(){
		assertEquals(0.064, Calculator.powerOf(2.5, -3), 0.0000001);
	}

	@org.junit.Test
	public void powerOfWith_NegativeInteger_PositiveExp(){
		assertEquals(-100000, Calculator.powerOf(-10, 5), 0.0000001);
	}

	@org.junit.Test
	public void powerOfWith_NegativeDouble_PositiveExp(){
		assertEquals(-127628.15625, Calculator.powerOf(-10.5, 5), 0.0000001);
	}

	@org.junit.Test
	public void powerOfWith_NegativeInteger_NegativeExp(){
		assertEquals(-0.00001, Calculator.powerOf(-10, -5), 0.0000001);
	}

	@org.junit.Test
	public void powerOfWith_NegativeDouble_NegativeExp(){
		assertEquals(-0.064, Calculator.powerOf(-2.5, -3), 0.0000001);
	}

	@org.junit.Test
	public void powerOfWith_ZeroBase_PositiveExp(){
		assertEquals(0, Calculator.powerOf(0, 3), 0.0000001);
	}

	@org.junit.Test
	public void powerOfWith_ZeroBase_NegativeExp(){
		assertEquals(0, Calculator.powerOf(0, -3), 0.0000001);
	}

	@org.junit.Test
	public void powerOfWith_ZeroBase_ZeroExp(){
		assertEquals(1, Calculator.powerOf(0, 0), 0.0000001);
	}

	@org.junit.Test
	public void powerOfWith_PositiveBase_ZeroExp(){
		assertEquals(1, Calculator.powerOf(4, 0), 0.0000001);
	}

	@org.junit.Test
	public void powerOfWith_NegativeBase_ZeroExp(){
		assertEquals(1, Calculator.powerOf(-10, 0), 0.0000001);
	}

	@org.junit.Test(expected = ArithmeticException.class)
	public void powerOfWith_Overflow(){
		Calculator.powerOf(Double.MAX_VALUE, 3);
	}

}
