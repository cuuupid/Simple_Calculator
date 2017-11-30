package simple_Calculator.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.javafx.css.CalculatedValue;

import simple_Calculator.Calculator;

public class SquareTest {

	@Test
	public void test() {
		assertEquals(4, Calculator.square(2), 0.00001);
		assertEquals(0, Calculator.square(0), 0.00001);
		assertEquals(4, Calculator.square(-2), 0.00001);
		assertEquals(1000000, Calculator.square(1000), 0.00001);
		assertEquals(1000000, Calculator.square(-1000), 0.00001);
		assertEquals(Double.POSITIVE_INFINITY, Calculator.square(1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0), 1);
	
	}

}
