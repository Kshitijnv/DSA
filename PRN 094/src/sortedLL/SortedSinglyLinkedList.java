package sortedLL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortedSinglyLinkedList {
	private Node head;
	private int size;

	private static class Node {

		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public SortedSinglyLinkedList() {
		head = null;
		size = 0;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// Creating an empty linked list
			SortedSinglyLinkedList list = new SortedSinglyLinkedList();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("Enter a choice: \n" + "1.Add element\n" + "2.Remove the elements\n"
							+ "3.Find the element\n" + "4.Display the list\n" + "5.Exit\n");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter an element: ");
						list.addElement(sc.nextInt());
						break;
					case 2:
						System.out.println("List size is: " + list.size);
						System.out.println("Enter the numbers of element to be removed: ");
						
						int noOfElements = sc.nextInt();
						if (noOfElements > list.size)
							throw new RuntimeException("List have not this much element to delete");
						
						// Creating a D.S. ArrayList to store the elements which user want to delete/remove
						List<Integer> removedList = new ArrayList<>();
						// Storing all the element in a list which user want to delete
						for (int i = 1; i <= noOfElements; i++) {
							System.out.print("Enter " + i + " element: ");
							removedList.add(sc.nextInt());
						}
						// Calling the Sorted Linked List method
						list.removeAll(removedList);
						break;
					case 3:
						System.out.println("Enter an element to find its index: ");
						System.out.println(list.find(sc.nextInt()));
						break;
					case 4:
						System.out.println(list.toString());
						break;
					case 5:
						System.out.println("Byeee....");
						exit = true;
						break;
					default:
						System.out.println("Invalid choice, please try again!!!");
						break;
					}
				} catch (Exception e) {
					sc.nextLine();// Clears the input buffer
					System.out.println("Please try again!!!");
					e.printStackTrace();
				}
			}
		}

	}

	private void removeAll(List<Integer> removedList) {
		if (head == null)
			System.out.println("Linked List is already Empty, Can't be delete");
		else {
			for (Integer item : removedList) {
				Node trav = head;
				Node temp = null;
				while (trav != null) {
					// If the 'item' is first node
					if ((trav.data == item) && (trav == head)) {
						head = head.next;
					} else if (trav.data == item) { // Item found which is want to delete
						temp.next = trav.next;
					} else {
						// If the current element is not the one to be removed, update the temp pointer
						// only
						temp = trav;
					}
					trav = trav.next;
				}
			}
			System.out.println("Removed all the given elements Successfully!!!");
		}
	}

	private int find(int value) {
		Node trav = head;
		for (int i = 1; trav != null; i++) {
			// If the first Occurence of the element found returning the index number
			if (trav.data == value)
				return i;
			trav = trav.next;
		}
		// If element not found, returning -1
		return -1;
	}

	private void addElement(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			size++;
		} else {
			Node trav = head;
			Node temp = null;
			while (trav != null && trav.data < value) {
				temp = trav;
				trav = trav.next;
			}
			// If upcoming variable is least from the list-- adding At first
			if (trav == head) {
				newNode.next = head;
				head = newNode;
				size++;
			} else {// upcoming varibale is in between
				newNode.next = temp.next;
				temp.next = newNode;
				size++;
			}
		}
	}

	@Override
	public String toString() {
		if (head == null)
			return "List is empty!!";
		// Creating a String Builder object to create a comma separated list
		StringBuilder sb = new StringBuilder();
		Node trav = head;
		while (trav != null) {
			sb.append(trav.data).append(", ");
			trav = trav.next;
		}
		// Removing the trailing comma and whitespace
		sb.setLength(sb.length() - 2);
		// Converting the StringBuilder to String & return to the Caller
		return sb.toString();

	}

}
