package linkedList;

import java.util.Scanner;

public class SinglyCircularList {

	static class Node {
		private int data;
		private Node next;

		public Node() {
			data = 0;
			next = null;
		}

		public Node(int value) {
			data = value;
			next = null;
		}
	}

	private Node head;

	public SinglyCircularList() {
		head = null;
	}

	void display() {
		if (head == null) {
			System.out.println("list is empty");
			return;
		} else {
			Node trav = head;
			do {
				System.out.println(trav.data);
				trav = trav.next;
			} while (trav != head);
		}
	}

	void addLast(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			newNode.next = head;
		} else {
			Node trav = head;
			while (trav.next != head) {
				trav = trav.next;
			}
			newNode.next = head;
			trav.next = newNode;
		}
	}

	void addfirst(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			newNode.next = head;
		} else {
			Node trav = head;
			while (trav.next != head) {
				trav = trav.next;
			}
			trav.next = newNode;
			newNode.next = head;
			head = newNode;
		}
	}

	void addAtSpecificPos(int pos, int value) {
		//CASE1: if position is given 1 that means add at first pos
		if (pos == 1)
			addfirst(value);
		else {
			Node newNode = new Node(value);
			Node trav = head;
			for (int i = 1; i < pos-1; i++) {
				//CASE2: if position is given out of index then adding at last
				if (trav.next == head) {
					newNode.next = head;
					trav.next = newNode;
					break;
				}
				trav = trav.next;
			}
			if(newNode.next!=head) {
				// adding at specific condition
				newNode.next = trav.next;
				trav.next = newNode;
			}
			
		}
	}

	void deleteFirst() {
		// CASE 1: if there is no element
		if (head == null)
			throw new RuntimeException("List is already empty");
		// CASE 2:If there is only 1 element
		if (head.next == head) {
			head = null;
		} else {
			// CASE 3: if there is multiple elements
			Node trav = head;
			do {
				trav = trav.next;
			} while (trav.next != head);
			trav.next = head.next;
			head = head.next;
		}
	}

	void deleteLast() {
		// CASE 1: if there is no element
		if (head == null)
			throw new RuntimeException("List is already empty");
		// CASE 2:If there is only 1 element
		if (head.next == head) {
			head = null;
		} else {
			// CASE 3: if there is multiple elements
			Node trav = head;
			Node temp;
			do {
				temp=trav;
				trav=trav.next;
			}while(trav.next!=head);
			temp.next=head;
		}
	}
	void deleteAtSpecPos(int pos) {
		// CASE 1: if position is given 1 
		if(pos==1)
			deleteFirst();
		else {Node trav=head;
		for(int i=1;i<pos-1;i++) {
		//CASE2: if position is given out of index then adding at last
			if (trav.next == head) 
				throw new RuntimeException("Position is out of index!!");
			trav=trav.next;	
		}
		trav.next=trav.next.next;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SinglyCircularList list = new SinglyCircularList();
		boolean exit = false;
		while (!exit) {
			try {
				System.out.println("Menu\n" + "1.Add node at first position\n" + "2.Add node at last position\n"
						+ "3.Add node at specific position\n" + "4.Delete first element\n" + "5.Deleting last element\n"
						+ "6.Deleting element at specific position\n" + "7.Displaying all elements\n"
								+ "0.EXIT");
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
					System.out.println("Display");
					list.display();

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
