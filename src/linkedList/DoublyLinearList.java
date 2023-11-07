package linkedList;

import java.util.Scanner;

public class DoublyLinearList {
	static class Node {
		private int data;
		private Node next;
		private Node prev;

		public Node() {
			data = 0;
			prev = null;
			next = null;
		}

		public Node(int value) {
			data = value;
			prev = null;
			next = null;
		}
	}

	private Node head;

	public DoublyLinearList() {
		head = null;
	}

	void addfirst(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	void addLast(int value) {
		Node newNode = new Node(value);
		if (head == null)
			head = newNode;
		else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			trav.next = newNode;
			newNode.prev = trav;
		}
	}

	void addAtSpecificPos(int pos, int value) {
		Node newNode = new Node(value);
		if (head == null||pos==1)
			addfirst(value);
		else {
			Node trav = head;
			Node temp = null;
			for (int i = 1; i < pos; i++) {
				if(trav.next==null)
					break;
				temp = trav;
				trav = trav.next;
			}
			if(trav.next==null) {
				trav.next=newNode;
				newNode.prev=trav;
			}
			else if(temp!=null) {
				newNode.prev=temp;
				temp.next=newNode;
				newNode.next=trav;
				trav.prev=newNode;
			}
		}

	}

	void deleteFirst() {
		head = head.next;
		head.prev = null;
	}

	void deleteLast() {
		if (head == null)
			throw new RuntimeException("List is empty");
		else if (head.next == null) {
			head = null;
		} else {
			Node trav = head;
			while (trav.next != null)
				trav = trav.next;
			trav.prev.next = null;
		}

	}

	void deleteAtSpecPos(int pos) {
		if (head == null || pos < 1)
			throw new RuntimeException("List is empty or Position is out of bound");
		if(pos==1)
			deleteFirst();
		else {
			Node trav = head;
			Node temp = null;
			for (int i = 1; i < pos; i++) {
				if (trav.next == null)
					throw new RuntimeException("Position is out of bound");
				temp = trav;
				trav = trav.next;
			}
			temp.next = trav.next;
			trav.prev = trav.next;

		}

	}

	void displayForward() {
		if (isEmpty())
			throw new RuntimeException("List is empty!!!");
		Node trav = head;
		do {
			System.out.println(trav.data);
			trav = trav.next;
		} while (trav != null);
	}

	void displayReverse() {
		if (isEmpty())
			throw new RuntimeException("List is empty!!!");
		Node trav = head;
		while (trav.next != null) {
			trav = trav.next;
		}
		do {
			System.out.println(trav.data);
			trav = trav.prev;
		} while (trav != null);
	}
	 boolean isEmpty() {
		return head==null;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DoublyLinearList list = new DoublyLinearList();
		boolean exit = false;
		while (!exit) {
			try {
				System.out.println("Menu\n" + "1.Add node at first position\n" + "2.Add node at last position\n"
						+ "3.Add node at specific position\n" + "4.Delete first element\n" + "5.Deleting last element\n"
						+ "6.Deleting element at specific position\n" + "7.Displaying all elements\n"+"0.EXIT");
				System.out.println("Enter your choice");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("enter new element");
					int element = sc.nextInt();
					list.addfirst(element);
					break;

				case 2:
					System.out.println("enter new element");
					element = sc.nextInt();
					list.addLast(element);
					break;
				case 3:
					System.out.println("enter position and element-");
					list.addAtSpecificPos(sc.nextInt(), sc.nextInt());
					break;

				case 4:
					System.out.println("deleting first element");
					list.deleteFirst();
					break;

				case 5:
					System.out.println("deleting last element");
					list.deleteLast();
					break;
				case 6:
					System.out.println("Deleting element at specific position");
					System.out.println("Enter position of element you want to delete");
					list.deleteAtSpecPos(sc.nextInt());
					break;
				case 7:
					System.out.println("Display in forward");
					list.displayForward();
					System.out.println("Display in reverse");
					list.displayReverse();
					break;
				case 0:
					exit = true;
					System.out.println("Thanks,Exiting!!");
					break;
				default:
					System.out.println("invaid choice");
					break;

				}
			} catch (Exception e) {
				e.printStackTrace();
				sc.nextLine();
				System.out.println("Please try again!!");
			}
		}
		sc.close();
	}

}
