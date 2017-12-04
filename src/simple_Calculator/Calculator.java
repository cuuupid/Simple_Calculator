package simple_Calculator;

public class Calculator {
	public static double addition(double a, double b) {
		double rv = a + b;
		if (rv == Double.POSITIVE_INFINITY || rv == Double.NEGATIVE_INFINITY) {
			throw new ArithmeticException("Overflow!");
		} else {
			return rv;
		}
	}

	public static double subtraction(double a, double b) {
		double rv = a - b;
		if (rv == Double.POSITIVE_INFINITY || rv == Double.NEGATIVE_INFINITY) {
			throw new ArithmeticException("Overflow!");
		} else {
			return rv;
		}
	}

	public static double multiplication(double a, double b) {
		double rv = a * b;
		if (rv == Double.POSITIVE_INFINITY || rv == Double.NEGATIVE_INFINITY) {
			throw new ArithmeticException("Overflow!");
		} else {
			return rv;
		}
	}

	public static double division(double a, double b) {
		if (b == 0) {
			throw new IllegalArgumentException("Can't divide by zero");
		}
		double rv = a / b;
		if (rv == Double.POSITIVE_INFINITY || rv == Double.NEGATIVE_INFINITY) {
			throw new ArithmeticException("Overflow!");
		} else {
			return rv;
		}
	}

	public static double powerOf(double base, int exponent) {
		if (exponent == 0) {
			return 1.0;
		} else if (base == 0) {
			return 0.0;
		} else if (base == 1) {
			return 1.0;
		} else if (exponent > 0) {
			double rv = powerOfPositiveExponent(base, exponent);
			if (rv == Double.POSITIVE_INFINITY || rv == Double.NEGATIVE_INFINITY) {
				throw new ArithmeticException("Overflow!");
			} else {
				return rv;
			}
		} else if (exponent < 0) {
			double rv = powerOfNegativeExponent(base, exponent);
			if (rv == Double.POSITIVE_INFINITY || rv == Double.NEGATIVE_INFINITY) {
				throw new ArithmeticException("Overflow!");
			} else {
				return rv;
			}
		} else {
			throw new ArithmeticException("ERROR!");
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
		double rv = a * a;
		if (rv == Double.POSITIVE_INFINITY || rv == Double.NEGATIVE_INFINITY) {
			throw new ArithmeticException("Overflow!");
		} else {
			return rv;
		}
	}

	public static double root(double a) {
		// Implement functionality for root function
		if (a < 0) {
			throw new IllegalArgumentException("You can not take the root of a negative number");
		}

		return Math.sqrt(a);
	}

}
