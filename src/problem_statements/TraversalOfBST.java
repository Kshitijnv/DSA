package problem_statements;

import java.util.Scanner;
import java.util.Stack;

public class TraversalOfBST {

	public static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node() {
			data = 0;
			left = null;
			right = null;
		}

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;

	public TraversalOfBST() {
		this.root = null;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			TraversalOfBST tree = new TraversalOfBST();
			while (!exit) {
				try {
					System.out.println("Enter a choice:\n" + " 1.add elemenet\n" + " 2.Display inOrder\n"
							+ " 3.Display preOrder\n" + " 4.Display postOrder\n" + " 5.Check tree is empty\n"
							+ " 6.Find element with parent\n" + " 0.exit");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter an element: ");
						tree.add(sc.nextInt());
						break;
					case 2:
						// Inorder
						tree.displayTree(0);
						break;
					case 3:
						// PreOrder
						tree.displayTree(1);
						break;
					case 4:
						// PostOrder
						tree.displayTree(2);
						break;
					case 5:
						System.out.println("Tree is empty: " + tree.isEmpty());
						break;
					case 6:
//						System.out.println("Enter element :");
//						Node[] arr = tree.BinarySearchWithParent(sc.nextInt());
//						if (arr[0] == null)
//							System.out.println("Element Not Found!!!");
//						else if (arr[1] == null)
//							System.out.println("element is root : " + arr[0].data + "No parent");
//						else
//							System.out.println("Element found " + arr[0].data + " parent node : " + arr[1].data);
//						break;
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
		return root == null;
	}

	private void add(int value) {
		Node newNode = new Node(value);
		if (isEmpty())
			root = newNode;
		else {
			Node trav = root;
			while (trav != null) {
				if (newNode.data < trav.data) {
					if (trav.left != null)
						trav = trav.left;
					else {
						trav.left = newNode;
						break;
					}
				} else { // newNode.data>= trav.data
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

	private void displayTree(int flag) {
		if (flag == 0) {
			System.out.println("InOrder: ");
			inOrderNonRecursive(root);
		} else if (flag == 1) {
			System.out.println("PreOrder : ");
			preOrderNonRecursive(root);
		} else {
			System.out.println("PostOrder :");
			postOrderNonRecursive(root);
		}

	}

	private void postOrderNonRecursive(Node trav) {
		Stack<Node> s = new Stack<>();
		// left
		// right
		// Node

		while (trav != null || !s.isEmpty()) {
			while (trav != null) {
				s.push(trav);
				trav = trav.left;
			}
			trav = s.peek();
			trav = trav.right;
			if (trav.right == null && trav.left==null) {
				System.out.print(trav.data + " ");
				trav = s.pop();
				System.out.print(trav.data + " ");
				trav= s.peek();
			}
		}
	}

	private void preOrderNonRecursive(Node trav) {
		Stack<Node> s = new Stack<>();
		// Node
		// left
		// right

		while (trav != null || !s.isEmpty()) {
			while (trav != null) {
				System.out.print(trav.data + " ");
				s.push(trav);
				trav = trav.left;
			}
			trav = s.pop();
			trav = trav.right;
		}
	}

	private void inOrderNonRecursive(Node trav) {
		Stack<Node> s = new Stack<>();
		// left
		// Node
		// right

		while (trav != null || !s.isEmpty()) {
			while (trav != null) {
				s.push(trav);
				trav = trav.left;
			}
			trav = s.pop();
			System.out.print(trav.data + " ");
			trav = trav.right;
		}
	}
}
