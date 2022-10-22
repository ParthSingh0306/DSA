package BinaryTrees;

import BinaryTrees.BinaryTreeB.Node;

public class UnivaluedBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(3);
		root.right = new Node(3);
		root.left.left = new Node(3);
		root.left.right = new Node(3);
		root.right.left = new Node(3);
		root.right.right = new Node(3);
	    System.out.println(isUni(root));
	}
	
	public static boolean isUni(Node root) {
		if(root == null) {
			return true;
		}
		
		if(root.left != null) {
			if(root.data != root.left.data) return false;
		}
		
		if(root.right != null) {
			if(root.data != root.right.data) return false;
		}
		
		boolean left = isUni(root.left);
		boolean right = isUni(root.right);
		
		if(left && right) {
			return true;
		}
		return false;
	}

}
