package simple_Calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Decoder {
	private final int NONE = 0; // Brackets
	private final int LOW = 1; // Addition and subtraction
	private final int MEDIUM = 2; // Multiplication and division
	private final int HIGH = 3; // Power Of

	private final char[] brackets = { '(', ')' };
	private final char[] lowPresedenceOperators = { '+', '-' };
	private final char[] mediumPresedenceOperators = { 'x', '*', '/', '÷' };
	private final char[] highPresedenceOperators = { '^' };
	private final char[] rightAssociativeOperators = { '^' };

	public String generatePostfixNotationString(String expression) {
		Stack<String> operators = new Stack<>();
		Queue<String> output = new LinkedList<>();
		
		String infixString = prepareString(expression);
		System.out.println(infixString);
		String[] tokens = infixString.split("\\s+");
		for (String token : tokens) {
			if (isNumber(token)) {
				output.add(token);
				continue;
			}
			int presedence = getPresedence(token);
			if (!token.equals(")")) {
				while (!operators.isEmpty() && presedence <= getPresedence(operators.peek()) && !token.equals("(")
						&& !tokenExistsInArray(token, rightAssociativeOperators)) {
					output.add(operators.pop());
				}
				operators.push(token);
			} else if (token.equals(")")) {
				while (!operators.peek().equals("(")) {
					output.add(operators.pop());
				}
				if (operators.isEmpty()) {
					System.out.println("mismatched parentheses");
					return "mismatched parentheses";
				}
				operators.pop();
			}
		}
		while (!operators.isEmpty()) {
			String t = operators.pop();
			if (tokenExistsInArray(t, brackets)) {
				System.out.println("mismatched parentheses");
				return "mismatched parentheses";
			}
			output.add(t);
		}
		String returnString = "";
		for (String token : output) {
			returnString += token + " ";
		}
		return returnString.trim();
	}

	private String prepareString(String expression) {
		String infixString = expression.replace('x', '*').replace('÷', '/').replace(',', '.');
		return infixString;
	}

	public double calculatePostfixNotationString(String expression) {
		String[] tokens = expression.split("\\s+");
		Stack<Double> stack = new Stack<>();
		for (String token : tokens) {
			if (isNumber(token)) {
				stack.push(Double.parseDouble(token));
			} else {
				double right = stack.pop();
				double left = stack.pop();
				switch (token) {
				case "+":
					stack.push(Calculator.addition(left, right));
					break;
				case "-":
					stack.push(Calculator.subtraction(left, right));
					break;
				case "*":
					stack.push(Calculator.multiplication(left, right));
					break;
				case "/":
					stack.push(Calculator.division(left, right));
					break;
				case "^":
					if((int)right != right){
						throw new IllegalArgumentException("We dont tolerate none integer exponents");
					}
					stack.push(Calculator.powerOf(left, (int)right));
					break;
				default:
					throw new IllegalArgumentException("String contains unexpected characters");
				}
			}
		}
		if(stack.size() != 1){
			throw new IllegalArgumentException("Not a valid expression!");
		}
		return stack.pop();
	}

	private boolean isNumber(String token) {
		return token.matches("\\d*\\.?\\d*") || token.matches("\\d*\\,\\d*");
	}

	private int getPresedence(String token) {
		if (tokenExistsInArray(token, lowPresedenceOperators)) {
			return LOW;
		} else if (tokenExistsInArray(token, mediumPresedenceOperators)) {
			return MEDIUM;
		} else if (tokenExistsInArray(token, highPresedenceOperators)) {
			return HIGH;
		} else if (tokenExistsInArray(token, brackets)) {
			return NONE;
		} else {
			throw new IllegalArgumentException("The token is not a known operator!");
		}
	}

	private boolean tokenExistsInArray(String token, char[] array) {
		if (token.length() != 1) {
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
		Decoder decoder = new Decoder();
		System.out.println(decoder.prepareString("3,0 ^ 5 + 4 x 2 / ( 1 - 5 ) ^ 2 ^ 3"));
		System.out.println(decoder.generatePostfixNotationString("7 x 2 - ( 3 - 9 ) ^ 2"));
	}
}
