package simple_Calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Decoder {
	private final int NONE = 0; // Brackets
	private final int LOW = 1; // Addition and subtraction
	private final int MEDIUM = 2; // Multiplication and division
	private final int HIGH = 3; // Power Of
	private final int UNARY = 4; // sqrt and -

	private final char[] brackets = { '(', ')' };
	private final char[] lowPresedenceOperators = { '+', '-' };
	private final char[] mediumPresedenceOperators = { 'x', '*', '/', '÷' };
	private final char[] highPresedenceOperators = { '^' };
	private final char[] rightAssociativeOperators = { '^' };
	private final char[] unaryOperators = {};

	public String shuntingYardAlgorithm(String expression) {
		Stack<String> operators = new Stack<>();
		Queue<String> output = new LinkedList<>();

		String[] tokens = prepareStringAndTokenize(expression);
		for (String token : tokens) {
			if (isNumber(token)) {
				output.add(token);
				continue;
			}
			// The token is a operator or a bracket.
			int presedence = getPresedence(token);
			if (!token.equals(")") && !token.equals("(")) {
				// while (there is an operator at the top of the operator stack with
				// greater precedence) or (the operator at the top of the operator stack has
				// equal precedence and the operator is left associative) and
				// (the operator at the top of the stack is not a left bracket):
				// pop operators from the operator stack, onto the output queue.
				// push the read operator onto the operator stack.
				while (!operators.isEmpty() && presedence <= getPresedence(operators.peek())
						&& !tokenExistsInArray(token, rightAssociativeOperators)) {
					output.add(operators.pop());
				}
				operators.push(token);
			}
			//If left bracket just push it to stack
			if (token.equals("(")) {
				operators.push(token);
			}
			//If right bracket we pop the operator stack to output
			//until we find left bracket and then throw the brackets away.
			else if (token.equals(")")) {
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
		//When done pop all remaining operators to output
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

	private String[] prepareStringAndTokenize(String expression) {
		String tokens = expression.replace('x', '*').replace('÷', '/').replace(',', '.');
		return tokens.split("\\s+");
	}
	
	public double calculatePostfixNotationString(String expression) {
		/* push numbers to stack. if operator pop numbers and use the operator with them and push answer to stack and repeat.
		 * operator = x, right = stack.pop() left = stack.pop() stack.push(left x right)*/
		String[] tokens = prepareStringAndTokenize(expression);
		Stack<Double> stack = new Stack<>();
		for (String token : tokens) {
			if (isNumber(token)) {
				stack.push(Double.parseDouble(token));
			} else {
				double right = stack.pop();
				double left = 0;
				if (!stack.isEmpty()) {
					left = stack.pop();
				}
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
					stack.push(left / right);
					break;
				case "^":
					if ((int) right != right) {
						throw new IllegalArgumentException("We don't tolerate none integer exponents");
					}
					stack.push(Calculator.powerOf(left, (int) right));
					break;
				default:
					throw new IllegalArgumentException("String contains unexpected characters");
				}
			}
		}
		if (stack.size() != 1) {
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
		} else if (tokenExistsInArray(token, unaryOperators)) {
			return UNARY;
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
}
