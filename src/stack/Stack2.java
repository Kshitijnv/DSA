package stack;

import java.util.Scanner;

public class Stack2 {
//Fixed Stack
	private int top;
	private int[] arr;

	public Stack2(int size) {
		this.top = -1;
		arr = new int[size];
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			// Can user defined also the size implement here
			Stack2 myStack = new Stack2(5);
			while (!exit) {
				try {
					System.out.println("Enter a choice:\n" + "1.Push an element\n" + "2.Pop an element\n"
							+ "3.Find top element\n" + "4.Check the stack is empty or not\n"
							+ "5.Check the stack is Full or not\n" + "0.Exit ");
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
					case 5:
						System.out.println(myStack.isFull());
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
		return top == -1;
	}

	private boolean isFull() {
		return top == arr.length - 1;
	}

	private void peek() {
		if (isEmpty())
			throw new RuntimeException("Stack is empty,Nothing to show");
		System.out.println("Top ->" + arr[top]);
	}

	private void pop() {
		if (isEmpty())
			throw new RuntimeException("Stack is underflow, Nothing to pop");
		System.out.println("Popped element: " + arr[top]);
		top--;
	}

	private void push(int value) {
		if (isFull())
			throw new RuntimeException("Stack is OverFlow,Can't be push new element");
		top++;
		arr[top] = value;
	}

}
