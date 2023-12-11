package tree;

import java.util.Scanner;

public class BinarySearchTree {
	static class Node {
		private int data;
		private Node left;
		private Node right;

		Node() {
			data = 0;
			left = null;
			right = null;
		}

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			BinarySearchTree tree = new BinarySearchTree();
			while (!exit) {
				try {
					System.out.println(
							"Enter a choice:\n"
							+ " 1.add elemenet\n"
							+ " 2.delete element\n"
							+ " 3.Check tree is empty\n"
							+ " 4.Find element with parent\n"
							+ " 5.Display inOrder\n"
							+ " 6.Display preOrder\n"
							+ " 7.Display postOrder\n"
							+ " 0.exit");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter an element: ");
						tree.add(sc.nextInt());
						break;
					case 2:
						System.out.println("Enter an element: ");
						tree.delete(sc.nextInt());
						System.out.println("Element deleted...");
						break;
					case 3:
						System.out.println("Tree is empty: " + tree.isEmpty());
						break;
					case 4:
						System.out.println("Enter element :");
						Node[] arr =  tree.BinarySearchWithParent(sc.nextInt());
						if(arr[0]==null)
							System.out.println("Element Not Found!!!");
						else if(arr[1]==null)
							System.out.println("element is root : " + arr[0].data+"No parent");
						else
							System.out.println("Element found " + arr[0].data +" parent node : " +arr[1].data );
						break;
					case 5:
						tree.displayTree(0);
						break;
					case 6:
						tree.displayTree(1);
						break;
					case 7:
						tree.displayTree(2);
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

	private void displayTree(int flag) {
		if(flag==0) {
			System.out.println("InOrder: ");
			inOrder(root);
		}
		else if(flag==1) {
		System.out.println("PreOrder : ");
			preOrder(root);
		}
		else {
			System.out.println("PostOrder :");
			postOrder(root);
		}
		
	}
	private void inOrder(Node trav) {
		//Base condition
		if(trav==null)
			return;
		//Display Left
		inOrder(trav.left);
		//Display Node
		System.out.print(trav.data + " ->");
		//Display Right 
		inOrder(trav.right);
	}
	private void preOrder(Node trav) {
		//Base condition
		if(trav==null)
			return;
		//Display Node
				System.out.print(trav.data + " ->");
		//Display Left
		inOrder(trav.left);
		//Display Right 
		inOrder(trav.right);
	}
	private void postOrder(Node trav) {
		//Base condition
		if(trav==null)
			return;
		//Display Left
		inOrder(trav.left);
		//Display Right 
		inOrder(trav.right);
		//Display Node
				System.out.print(trav.data + " ->");
	}
	private Node[] BinarySearchWithParent(int value) {
		if (isEmpty())
			new RuntimeException("Tree is empty!!!");
		Node trav = root, parent = null;
		while (trav != null) {
				if (trav.data == value) 
					return new Node[] { trav, parent };
				parent = trav;
				if (value < trav.data) 
					trav = trav.left;
				else 
					trav = trav.right;
			}
		return new Node[]{null,null};
		}
	

	private void delete(int value) {
		
		// 1.Find the node to be deleted with its parent
		Node[] arr = BinarySearchWithParent(value);
		Node trav = arr[0];
		Node parent = arr[1];
		
		// 2.If node not Found, throws exception
		if(arr[0] == null)
			throw new RuntimeException("Node not found!!");
		
		// 3.If Deleted Node has left and right child both
		if(trav.left!=null && trav.right!=null) {
			
			// 3.1 Find its successor with its parent
			parent = trav;
			Node succ = trav.right;
				while(succ.left!=null) {
					parent = succ;
					succ = succ.left;
				}
			// 3.2 Overwrite the data with its successor node data
				trav.data = succ.data;
			// 3.3 Mark successor node to be deleted
				trav = succ;
		}
		// 4 If node has right child Only
		if(trav.left==null) {
			if(trav==root)
				root = trav.right;
			else if(trav == parent.left)
				parent.left = trav.right;
			else
				parent.right = trav.right;
		}
		// 5 If node has left child Only
		if(trav.right==null) {
			if(trav==root)
				root = trav.left;
			else if(trav == parent.left)
				parent.left = trav.left;
			else
				parent.right = trav.left;
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

}
