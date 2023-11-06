package linkedList;

import java.util.Scanner;

public class DoublyCircularList {
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

	public DoublyCircularList() {
		head = null;
	}

	void addfirst(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			System.out.println("first");
			head = newNode;
			newNode.next=head;
			newNode.prev=head;
		} else {
			System.out.println("element");
			newNode.next=head;
			newNode.prev=head.prev;
			head.prev.next=newNode;
			head.prev=newNode;
			head=newNode;
			
		}
	}

	void addLast(int value) {
		Node newNode = new Node(value);
		if(head==null) {
			head=newNode;
			newNode.next=head;
			newNode.prev=head;
		}else {
			Node tail = head.prev;
			
			newNode.next=head;
			newNode.prev=tail;
			tail.next=newNode;
			head.prev=newNode;
		}
		
	}

	void addAtSpecificPos(int pos, int value) {
		//CASE 1: If list is empty or position given at first
		if (head == null||pos==1)
			addfirst(value);
		else {
			Node newNode = new Node(value);
			Node trav = head;
			Node tail = head.prev;
			for (int i = 1; i < pos-1; i++) {
				//CASE 2: Position given out of index
				if(trav.next==head) {
					newNode.next=head;
					newNode.prev=tail;
					tail.next=newNode;
					head.prev=newNode;
					break;
				}
				trav = trav.next;
			} 
			if(trav.next!=head) {
				newNode.next=trav.next;
				newNode.prev=trav;
				trav.next.prev=newNode;
				trav.next=newNode;
			}
		}

	}

	void deleteFirst() {
		Node tail = head.prev;
		tail.next=head.next;
		head = head.next;
		
	}

	void deleteLast() {
		//CASE1: if list is empty
		if (head == null)
			throw new RuntimeException("List is empty");
		//CASE2: if list have 1 element only
		else if (head.next == head) {
			head = null;
		}
		//CASE3: if multiple elements
		else {
			Node tail = head.prev.prev;
			tail.next=head;
			
		}

	}

	void deleteAtSpecPos(int pos) {
		
	}

	void displayForward() {
		if(head==null)
			throw new RuntimeException("List is already empty");
		Node trav=head;
		do {
			System.out.println(trav.data);
			trav=trav.next;
		}while(trav!=head);
	}

//	void displayReverse() {
//		
//	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DoublyCircularList list = new DoublyCircularList();
		boolean exit = false;
		while (!exit) {
			try {
				System.out.println("Menu\n" + "1.Add node at first position\n" + "2.Add node at last position\n"
						+ "3.Add node at specific position\n" + "4.Delete first element\n" + "5.Deleting last element\n"
						+ "6.Deleting element at specific position\n" + "7.Displaying all elements\n"+"0.Exit");
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
				//	list.displayReverse();
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
