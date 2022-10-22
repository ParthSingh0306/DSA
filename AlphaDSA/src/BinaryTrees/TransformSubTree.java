package BinaryTrees;

import BinaryTrees.BinaryTreeB.Node;

public class TransformSubTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		transformSub(root);
		preOrder(root);
	}

//	T.C = O(N)
	public static int transformSub(Node root) {
		if(root == null) {
			return 0;
		}
		
		int leftChild = transformSub(root.left);
		int rightChild = transformSub(root.right);
		
		int data = root.data;
		
		int newLeft = root.left == null ? 0 : root.left.data;
		int newRight = root.right == null ? 0 : root.right.data;
		
		root.data = newLeft + leftChild + newRight + rightChild;
		
		return data;
	}
	
	public static void preOrder(Node root) {
		if(root == null) return;
		
	    System.out.print(root.data + " ");
	    preOrder(root.left);
	    preOrder(root.right);
	}
}
