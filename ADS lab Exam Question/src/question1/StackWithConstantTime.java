package question1;

public class StackWithConstantTime {
	private int arr[];
	private int top;
	private int max;

	public StackWithConstantTime(int size) {
		top = -1;
		arr = new int[size];
		max = -1;
	}

	public int[] getArr() {
		return arr;
	}

	public int getTop() {
		return top;
	}

	void push(int val) {
		if (top == -1) {
			arr[++top] = val;
			max = val;
		} else if (top < arr.length) {
			if (max < val) {
				arr[++top] = 2*val - max;
				max = val;
			}
			else
			arr[++top] = val;
		} else
			System.out.println("Stack is Full!!, cant be push");
	}

	void pop() {
		if (top != -1) {
			if(arr[top]>max) {
				System.out.println("Popped : " + max);
				max = 2*max - arr[top];
				top--;
			}else
				System.out.println("Popped : " + arr[top--]);
		}
		else
			System.out.println("Stack is empty!!!, can't be pop");

	}

	void top() {
		if (top != -1) {
			if(arr[top]>max)
			System.out.println("Top element : " + max);
			else
				System.out.println("Top element : " + arr[top]);
		
		}
		else
			System.out.println("Stack is empty!!!");
	}

	void getMax() {
		if(top!=-1)
		System.out.println("Maximum is: " + max);
		else
			System.out.println("Stack is empty!!!");
			
	}
}
