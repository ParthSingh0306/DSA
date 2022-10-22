package BinaryTrees;

import BinaryTrees.BinaryTreeB.Node;

public class DeletedDuplicateNodes {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(3);
		root.left.left = new Node(3);
		root.left.right = new Node(2);
		preOrder(root);
		System.out.println();
		delete(root, 3);
		preOrder(root);
	}
	
	public static Node delete(Node node, int n) {
		if(node == null) {
			return null;
		}
		
		node.left = delete(node.left, n);
		node.right = delete(node.right, n);
		
		if(node.left == null && node.right == null) {
			if(node.data == n) return null;
		}
		
		return node;
	}
	
	public static void preOrder(Node root) {
		if(root == null) return;
		
	    System.out.print(root.data + " ");
	    preOrder(root.left);
	    preOrder(root.right);
	}

}
