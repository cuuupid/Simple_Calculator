package simple_Calculator;

import java.util.Arrays;

public class Tokenizer {
	private static final char[] operators = { '(', ')', '+', '-', '*', '/', '^' };
	private static final String opRegex = "[\\^()+*/-]";
	private static final String nrRegexDecimal = "\\d*\\.\\d*";
	private static final String nrRegexInteger = "-?\\d+";
	private static final String nrPlaceholder = " !NUMBER! ";

	public static String[] tokenizeInfixString(String str) {
		String infixString = new String(str);
		infixString = removeWhitespace(infixString);
		infixString = replaceOperators(infixString);
		String[] numbers = extractNumbers(infixString);
		String[] tokens = createArrayWithSpotsForNumbers(infixString);
		
		buildCompleteTokenArray(numbers, tokens);

		return tokens;
	}

	private static void buildCompleteTokenArray(String[] numbers, String[] tokens) {
		for (int i = 0, numberCounter = 0; i < tokens.length; i++) {
			if (tokens[i].equals(nrPlaceholder.trim())) {
				tokens[i] = numbers[numberCounter++];
			} else if (!tokenExistsInArray(tokens[i], operators)) {
				throw new IllegalArgumentException("Unknown character in String!");
			}
		}
	}

	private static String[] createArrayWithSpotsForNumbers(String infixString) {
		infixString = infixString.replaceAll(nrRegexDecimal, nrPlaceholder);
		infixString = infixString.replaceAll(nrRegexInteger, nrPlaceholder);
		String[] rv = infixString.trim().split("\\s+");
		return rv;
	}

	private static String[] extractNumbers(String infixString) {
		String[] numbers = infixString.trim().split(opRegex);
		return numbers;
	}

	private static String replaceOperators(String infixString) {
		infixString = infixString.replace('x', '*').replace('÷', '/').replace(',', '.');
		return infixString;
	}

	private static String removeWhitespace(String infixString) {
		infixString = infixString.replaceAll("\\s+", "");
		return infixString;
	}

	private static boolean tokenExistsInArray(String token, char[] array) {
		if (token.length() != 1) {
			System.out.println(token);
			throw new IllegalArgumentException("Token is not a single charcter!");
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == token.charAt(0)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.asList(tokenizeInfixString("123.42*32 + 123 * 3.00012^123")));
	}
}
