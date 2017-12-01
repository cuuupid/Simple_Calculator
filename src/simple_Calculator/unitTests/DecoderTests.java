package simple_Calculator.unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import simple_Calculator.Decoder;

public class DecoderTests {

	@Test
	public void test() {
		Decoder decoder = new Decoder();
		assertEquals("7 2 * 3 9 - 2 ^ -", decoder.generatePostfixNotationString("7 x 2 - ( 3 - 9 ) ^ 2"));
		assertEquals("7 7 - 7 - 7 2 * - 3 9 - 2 ^ -", decoder.generatePostfixNotationString("7 - 7 - 7 - 7 x 2 - ( 3 - 9 ) ^ 2"));
		assertEquals("3 4 2 * 1 5 - 2 3 ^ ^ / +", decoder.generatePostfixNotationString("3 + 4 x 2 ÷ ( 1 - 5 ) ^ 2 ^ 3"));
		assertEquals("3 5 ^ 4 2 * 1 5 - 2 3 ^ ^ / +", decoder.generatePostfixNotationString("3 ^ 5 + 4 x 2 / ( 1 - 5 ) ^ 2 ^ 3"));
		
		double ans = decoder.calculatePostfixNotationString(decoder.generatePostfixNotationString("7 x 2 - ( 3 - 9 ) ^ 2"));
		assertEquals(-22, ans, 0.000001);
		ans = decoder.calculatePostfixNotationString(decoder.generatePostfixNotationString("7 - 7 - 7 - 7 x 2 - ( 3 - 9 ) ^ 2"));
		assertEquals(-57, ans, 0.000001);
		ans = decoder.calculatePostfixNotationString(decoder.generatePostfixNotationString("3 + 4 x 2 / ( 1 - 5 ) ^ 2 ^ 3"));
		assertEquals(3.00012207031, ans, 0.000001);
		ans = decoder.calculatePostfixNotationString(decoder.generatePostfixNotationString("3 ^ 5 + 4 x 2 / ( 1 - 5 ) ^ 2 ^ 3"));
		assertEquals(243.00012207, ans, 0.000001);
		ans = decoder.calculatePostfixNotationString(decoder.generatePostfixNotationString("3.0 + 4.0 * 2 / ( 1 - 5 ) ^ 2.0 ^ 3"));
		assertEquals(3.00012207031, ans, 0.000001);
		ans = decoder.calculatePostfixNotationString(decoder.generatePostfixNotationString("3,000 ^ 5.0 + 4 x 2 ÷ ( 1 - 5 ) ^ 2,0000 ^ 3.0"));
		assertEquals(243.00012207, ans, 0.000001);
	}

}
