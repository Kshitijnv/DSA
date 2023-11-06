package stack;

import java.util.Scanner;

public class Stack {
//Grow able Stack
	static class Node {
		private int data;
		private Node next;

		public Node() {
			super();
			this.data = 0;
			this.next = null;
		}

		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}

	}

	private Node top;

	public Stack() {
		this.top = null;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			Stack myStack = new Stack();
			while (!exit) {
				try {
					System.out.println("Enter a choice:\n" + "1.Push an element\n" + "2.Pop an element\n"
							+ "3.Find top element\n" + "4.Check the stack is empty or not\n"
									+ "0.Exit ");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("enter a value to push");
						myStack.push(sc.nextInt());
						break;
					case 2:
						myStack.pop();
						break;
					case 3:
						myStack.peek();
						break;
					case 4:
						System.out.println(myStack.isEmpty());
						break;
					case 0:
						exit = true;
						System.out.println("Thanks,Exiting!!!!");
						break;
					default:
						System.out.println("Invalid choice!!!!");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
					System.out.println("Please try again!!!");
				}
			}
		}
	}

	private boolean isEmpty() {
		return top == null;
	}

	private void peek() {
		if (!isEmpty())
			System.out.println("Top ->" + top.data);
		else
			System.out.println("Stack is empty,Nothing to show");
	}

	private void pop() {
		if (!isEmpty()) {
			System.out.println("Popped element: "+ top.data);
			top = top.next;
		}
			
		else
			System.out.println("Stack is underflow, Nothing to pop");
	}

	private void push(int value) {
		Node newNode = new Node(value);
		newNode.next = top;
		top = newNode;
	}

}
