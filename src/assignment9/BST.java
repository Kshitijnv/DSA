package assignment9;

import java.util.Scanner;

public class BST {
	static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node() {
			left = null;
			right = null;
		}

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	private Node root;

	public BST() {
		root = null;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			BST tree = new BST();
			while (!exit) {
				try {
					System.out.println("Enter a choice:\n" + "1.Insert element\n" + "2.Display inOrder\n"
							+ "3.Display preOrder\n" + "4.Display postOrder\n" + "0.Exit\n");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter element");
						tree.insert(sc.nextInt());
						break;
					case 2:
						// In-Order traversal
						tree.Order(1);
						break;
					case 3:
						// Pre-Order traversal
						tree.Order(2);
						break;
					case 4:
						// Post-Order traversal
						tree.Order(3);
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

	private void Order(int flag) {
		if (flag == 1)
			inOrder(root);
		else if (flag == 2)
			preOrder(root);
		else
			postOrder(root);
		System.out.println();
	}

	private static void inOrder(Node element) {
		if(element==null)
			return ;
		inOrder(element.left);
		System.out.print(element.data+"->");
		inOrder(element.right);
	}

	private static void preOrder(Node element) {
		if(element==null)
			return ;
		System.out.print(element.data+"->");
		preOrder(element.left);
		preOrder(element.right);
	}

	private static void postOrder(Node element) {
		if(element==null)
			return ;
		postOrder(element.left);
		postOrder(element.right);
		System.out.print(element.data+"->");
	}

	private void insert(int data) {
		Node newNode = new Node(data);
		if (root == null)
			root = newNode;
		else {
			Node trav = root;
			while (true) {
				if (data < trav.data) {
					if (trav.left != null)
						trav = trav.left;
					else {
						trav.left = newNode;
						break;
					}
				} else {// data>=trav.data
					if (trav.right != null)
						trav = trav.right;
					else {
						trav.right = newNode;
						break;
					}
				}
			}
		}
	}

}
