package question4;

import java.util.Scanner;

public class CustomSinglyLinkedList {

	private static class Node {
		private int data;
		private Node next;


		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;
	private boolean isSortedList;

	public CustomSinglyLinkedList() {
		head = null;
		isSortedList = true;
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			// D.S
			CustomSinglyLinkedList list = new CustomSinglyLinkedList();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("Choose :\n" + "1.Add element at end\n" + "2.Find element X \n" + "3.ToString \n"
							+ "4.To check list is Sorted(in Ascending Order) \n" + "0.Exit\n");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter a value: ");
						list.addNodeAtEnd(sc.nextInt());
						break;
					case 2:
						System.out.println("Enter a element : ");
						System.out.println(list.find(sc.nextInt()));
						break;
					case 3:
						System.out.println(list.toString());
						break;
					case 4:
						System.out.println(list.isSorted());
						System.out.println("Improved Version: " + list.isSortedImproved());
						break;
					case 0:
						exit = true;
						System.out.println("byeeee");
						break;

					default:
						break;
					}
				} catch (Exception e) {
					System.out.println("PLease try again!!!");
					sc.nextLine();
					e.printStackTrace();
				}
			}

		}

	}

	private boolean isSorted() {
		Node trav = head;
		Node temp = null;
		while (trav != null) {
			temp = trav;
			trav = trav.next;
			if (trav != null && temp.data > trav.data)
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		Node trav = head;
		StringBuilder sb = new StringBuilder();
		while (trav != null) {
			sb.append(trav.data).append(", ");
			trav = trav.next;
		}
		sb.setLength(sb.length() - 2);
		return sb.toString();
	}

	private int find(int val) {

		Node trav = head;
		for (int i = 1; trav != null; i++) {
			if (trav.data == val)
				return i;
			trav = trav.next;
		}

		return -1;
	}

	private void addNodeAtEnd(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			Node trav = head;
			Node temp = null;
			while (trav.next != null) {
				temp = trav;
				if (temp.data > val) {
					isSortedList = false;
				}
				trav = trav.next;
			}
			trav.next = newNode;
			if (trav.data > val) {
				isSortedList = false;
			}
		}
		System.out.println("Node Added Successfully");
	}

	private boolean isSortedImproved() {
		return isSortedList;
	}

}
