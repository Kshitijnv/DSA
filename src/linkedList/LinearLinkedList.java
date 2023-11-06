package linkedList;

import java.util.Scanner;

public class LinearLinkedList {
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

	private Node head;
	private int count;
	public LinearLinkedList() {
		head = null;
		count = 0;
	}
	public void addFirst(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
		count++;
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
		}
		count++;
	}
	public void addAtSpecificPos( int pos,int value) {
		// case1: if list is empty
		if (head == null || pos <= 1)
			addFirst(value);
		else {
			// case2: general case
			Node newNode = new Node(value);
			Node trav = head;
			for (int i = 1; i < pos - 1; i++) {
				// case3: if position> length of linked list: then add in last
				if (trav.next == null) {
					trav.next=newNode;
					break;
				}
			 trav = trav.next;
			}
			newNode.next=trav;
			trav.next = newNode;
		}
		count++;
	}
	void display() {
		if (head == null)
			System.out.println("list is empty");
		else {
			Node trav = head;
			while (trav != null) {
				System.out.print(trav.data + " -> ");
				trav = trav.next;
			}
			System.out.println();
		}
	}

	void reverse() {
		System.out.println("old List");
		display();
		// Consider the original list as old
		Node oldhead = head;
		// Making a new list empty
		head = null;
		while (oldhead != null) {
			// Deleting first element from old list
			Node temp = oldhead;
			oldhead = oldhead.next;
			// Adding at first the deleted element from the list
			temp.next = head;
			head = temp;
		}
		System.out.println("Reverse list");
		display();
	}

	private Node reverseRecursion(Node h) {
		if (h.next == null) {
			head = h;
			return head;
		}
		Node tail = reverseRecursion(h.next);
		tail.next = h;
		h.next = null;
		return h;
	}

	void reverseRecursion() {
		if (head != null) {
			System.out.println("Old list");
			display();
			reverseRecursion(head);
			System.out.println("Reverse New List");
			display();
		}

	}

	private void displayRev() {
		System.out.println("Original List");
		display();
		System.out.println("Reverse list");
		displayRev(head);
		System.out.println();
	}

	private void displayRev(Node h) {
		if (h == null)
			return;
		displayRev(h.next);
		System.out.print(h.data+"->");
	}
	public void deleteFirst()throws RuntimeException {
		// case 1: if list is empty
		if (head == null)
			throw new RuntimeException("There are no elements in the list to delete");
		head = head.next;
		count--;
	}
	public void deleteLast() {
		Node trav = head;
		Node temp = null;
		while(trav.next!=null) {
			temp=trav;
			trav=trav.next;
		}
		temp.next=null;
		count--;
	}
	public void deleteAtSpecPos(int pos) throws RuntimeException{
		//case1:list is empty or invalid positon : throw exception
		if(head==null||pos<0)
			throw new RuntimeException("There are no elements in the list to delete");
		//case 2:if pos is 1
		if(pos==0)
			deleteFirst();
		Node trav=head;
		Node temp=null;
		for(int i=0;i<pos-1;i++) {
			//case 3: out of length position
			if(trav.next==null)
				throw new RuntimeException("Invalid position");
			temp=trav;
			trav= trav.next;
		}
		temp.next=trav.next;
		count--;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinearLinkedList list = new LinearLinkedList();
		boolean exit = false;
		while (!exit) {
			try {
				System.out.println("Menu\n" + "1.Add node at first position\n" + "2.Add node at last position\n"
						+ "3.Add node at specific position\n" + "4.Delete first element\n" + "5.Deleting last element\n"
						+ "6.Deleting element at specific position\n" + "7.Displaying all elements\n"
						+ "8.Reverse the list\n" + "9.Reverse the list using RECURSION\n"
						+ "10.Display list in Reverse manner\n"
						+ "11.Total number of elements\n"
						+ "12.Delete a node from last\n" + "0.EXIT");
				System.out.println("Enter your choice");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("enter new element");
					int element = sc.nextInt();
					list.addFirst(element);
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
				case 8:
					list.reverse();
					break;
				case 9:
					list.reverseRecursion();
					break;
				case 10:
					list.displayRev();
					break;
				case 11:
					System.out.println("Total number of elements are: " + list.count );
					break;
				case 12:
					System.out.println("Enter the position from last: ");
					Node h = list.deleteFromLast(sc.nextInt());
					System.out.println("head is : " + h);
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
	private Node deleteFromLast(int n) {
		Node trav = head;
		int c=0;
		while(trav!=null) {
			trav = trav.next;
			c++;
		}
		if((c-n)==0)
			head = head.next;
		else {
			Node temp = head;
			for(int i = 1;i<(c-n);i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}
		return head;
	}

}
