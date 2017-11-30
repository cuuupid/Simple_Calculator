package simple_Calculator.unitTests;

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
