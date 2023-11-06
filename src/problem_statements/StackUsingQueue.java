package problem_statements;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class StackUsingQueue {
	//Create a stack implementation using Normal queue
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			//Create 2 Queue for stack implementation : 1 - actual queue, 2- Temporary queue 
			Queue<Integer> queue1 = new LinkedList<Integer>() ;
			Queue<Integer> tempQueue = new LinkedList<Integer>() ;
			while (!exit) {
				try {
					System.out.println("Enter a choice:\n"
							+ "1.Push\n"
							+ "2.Pop\n"
							+ "3.Display\n"
							+ "0.Exit\n ");
					switch (sc.nextInt()) {
					case 1:
						//IT WILL GIVE LIFO (Last In First Out) W/o creating a stack
						System.out.println("Enter a value: ");
						//Pop each element 1 by 1 from Actual queue and Push it into Temp Queue
						while(!queue1.isEmpty()) {
							tempQueue.offer(queue1.poll()); 
						}
						//Now Push the upcoming value into the Actual Queue
						queue1.offer(sc.nextInt());
						//Pop each element 1 by 1 from Temp queue and Push it into Actual Queue
						while(!tempQueue.isEmpty()) {
							queue1.offer(tempQueue.poll());
						}
						
						break;
					case 2:
						System.out.println("Popped: "+ queue1.peek());
						queue1.poll();
						break;
					case 3:
							System.out.println(queue1);
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
	static void push(int value) {
		
	}
	static void pop() {
		
	}

}
