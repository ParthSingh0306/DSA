package BinaryTrees;

import BinaryTrees.BinaryTreeB.Node;

public class HeightOfTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(CountNodes(root));
	}
	
	public static int Height(Node root) {
		if(root == null) {
			return 0;
		}
		
		int lh = Height(root.left) + 1;
		int rh = Height(root.right) + 1;
		
		return Math.max(lh, rh);
	}
	
	public static int CountNodes(Node root) {
		if(root == null) {
			return 0;
		}
		
		int lh = CountNodes(root.left);
		int rh = CountNodes(root.right);
		
		return 1+lh+rh;
	}

}
