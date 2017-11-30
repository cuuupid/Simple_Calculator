package simple_Calculator;

public class Calculator {
	public static double addition(double a, double b) {
		return a + b;
	}

	public static double subtraction(double a, double b) {
		// Implement functionality for subtraction
		return 0;
	}

	public static double multiplication(double a, double b) {
		// Implement functionality for multiplication
		return a*b;
	}

	public static double division(double a, double b) {
		// Implement functionality for division
		return 0;
	}

	public static double powerOf(double base, int exponent) {
		// Implement functionality for powerOf
		if (exponent == 0) {
			return 1.0;
		} else if (base == 0) {
			return 0.0;
		} else if (base == 1) {
			return 1.0;
		} else if (exponent > 0) {
			return powerOfPositiveExponent(base, exponent);
		} else if (exponent < 0) {
			return powerOfNegativeExponent(base, exponent);
		} else {
			throw new ArithmeticException();
		}
	}

	private static double powerOfPositiveExponent(double base, int exponent) {
		if (exponent == 1) {
			return base;
		} else {
			int exp1 = exponent / 2;
			int exp2 = exponent - exp1;
			return powerOfPositiveExponent(base, exp1) * powerOfPositiveExponent(base, exp2);
		}
	}

	private static double powerOfNegativeExponent(double base, int exponent) {
		return 1.0 / powerOfPositiveExponent(base, -exponent);
	}

	public static double square(double a) {
		// Implement functionality for square function
		return 0;
	}

	public static double root(double a) {
		// Implement functionality for root function
		return 0;
	}
}
