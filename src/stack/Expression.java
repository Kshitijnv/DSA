package stack;

import java.util.Stack;

public class Expression {

	static String infixToPostfix(String infix) {

		// Implement a stack of operator(character)
		Stack<Character> myStack = new Stack<Character>();

		// Create a String Builder to appending the string
		StringBuilder postfix = new StringBuilder();

		// 1.Traverse infix from left to right
		for (int i = 0; i < infix.length(); i++) {
			Character sym = infix.charAt(i);

			// 2.if operand found append to post fix
			if (Character.isDigit(sym)) {
				postfix.append(sym);
			}
			// 4 if operator is opening ( then push into stack
			else if (sym == '(')
				myStack.push(sym);

			// 5 if closing ) found then pop operations from stack & append to post fix
			// until we get a single opening (
			else if (sym == ')') {
				while (myStack.peek() != '(')
					postfix.append(myStack.pop());
				myStack.pop();
			}
			// 3. if operator found, push to stack
			// 3.1 BUT if priority of topmost operator in stack is higher than or equal to
			// the upcoming(current) symbol
			// then pop the operator and append to post fix and push the current symbol to
			// stack
			else {
				while (!myStack.isEmpty() && pri(myStack.peek()) >= pri(sym))
					postfix.append(myStack.pop());
				myStack.push(sym);
			}
		}
		// 6 if all symbols from infix completed , pop one by one all operation & append
		// to post fix
		while (!myStack.isEmpty())
			postfix.append(myStack.pop());

		return postfix.toString();
	}

	private static int pri(Character operator) {
		switch (operator) {
		case '$':
			return 3;
		case '/':
			return 2;
		case '*':
			return 2;
		case '%':
			return 2;
		case '+':
			return 1;
		case '-':
			return 1;
		}
		return 0;
	}

	private static int solvePreFix(String prefix) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = prefix.length() - 1; i >= 0; i--) {
			char sym = prefix.charAt(i);
			if (Character.isDigit(sym)) {
				String operand = Character.toString(sym);
				s.push(Integer.parseInt(operand));
			} else {
				int a = s.pop();
				int b = s.pop();
				int c = calc(a, b, sym);
				s.push(c);
			}
		}
		return s.pop();
	}

	private static int solvePostfix(String postfix) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < postfix.length(); i++) {
			char sym = postfix.charAt(i);
			if (Character.isDigit(sym)) {
				String operand = Character.toString(sym);
				s.push(Integer.parseInt(operand));
			} else {
				int b = s.pop();
				int a = s.pop();
				int c = calc(a, b, sym);
				s.push(c);
			}
		}
		return s.pop();
	}

	private static int calc(int a, int b, char sym) {
		switch (sym) {
		case '$':
			return (int) Math.pow(a, b);
		case '/':
			return a / b;
		case '*':
			return a * b;
		case '+':
			return a + b;
		case '-':
			return a - b;
		}
		return 0;
	}

	private static String infixtoPrefix(String infix) {
		// Implement a stack of operator(character)
		Stack<Character> myStack = new Stack<Character>();

		// Create a String Builder to appending the string
		StringBuilder prefix = new StringBuilder();

		// 1.Traverse infix from right to left
		for (int i = infix.length() - 1; i >= 0; i--) {
			Character sym = infix.charAt(i);

			// 2.if operand found append to post fix
			if (Character.isDigit(sym)) {
				prefix.append(sym);
			}
			// 4 if operator is Closing ) then push into stack
			else if (sym == ')')
				myStack.push(sym);

			// 5 if Opening ( found then pop operations from stack & append to post fix
			// until we get a single Closing )
			else if (sym == '(') {
				while (myStack.peek() != ')')
					prefix.append(myStack.pop());
				myStack.pop();
			}
			// 3. if operator found, push to stack
			// 3.1 BUT if priority of topmost operator in stack is higher than or equal to
			// the upcoming(current) symbol
			// then pop the operator and append to post fix and push the current symbol to
			// stack
			else {
				while (!myStack.isEmpty() && pri(myStack.peek()) > pri(sym))
					prefix.append(myStack.pop());
				myStack.push(sym);
			}
		}
		// 6 if all symbols from infix completed , pop one by one all operation & append
		// to post fix
		while (!myStack.isEmpty())
			prefix.append(myStack.pop());
		// 7 Reverse the string then return
		return prefix.reverse().toString();
	}

	public static void main(String[] args) {
		String infix = "5+9-4*(8-6/2]+1$(7-3)";

//		String postfix = infixToPostfix(infix);
//		System.out.println("Postfix : " + postfix);
//		int result = solvePostfix(postfix);
//		System.out.println("By Postfix Result is: " + result);
//
//		String prefix = infixtoPrefix(infix);
//		System.out.println("Prefix : " + prefix);
//		result = solvePreFix(prefix);
//		System.out.println("By Prefix Result is: " + result);
		boolean balanced = isBalanced(infix);
		System.out.println("Balanced :" + balanced);
	}

	private static boolean isBalanced(String exp) {
		Stack<Character> s = new Stack<Character>();
		String open = "({[", close = ")}]";
		// 1.Traverse expression from left to right
		for (int i = 0; i < exp.length(); i++) {
			char sym = exp.charAt(i);
			// 2.If opening ({[ found then push into stack
			if (open.indexOf(sym) != -1)
				s.push(sym);
			// 3.if closing found then pop 1 sym from stack
			else if (close.indexOf(sym) != -1) {
				//5.Expression isn't finsihed but stack is empty then return false;
				if (s.isEmpty())
					return false;
				char popped = s.pop();
				// 3.1 Compare pop sym from opening sym index if yes, continue else return false
				if (open.indexOf(popped) != close.indexOf(sym))
					return false;

			}
		}

		return s.isEmpty();
	}
}
