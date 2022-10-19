package BinaryTrees;

import BinaryTrees.BinaryTreeB.Node;

public class KthLevel {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		kthlevel(root, 0, 2);
	}
	
	public static void kthlevel(Node root, int level, int k) {
		if(root == null) {
			return;
		}
		if(level == k) {
			System.out.print(root.data + " ");
			return;
		}
		
		kthlevel(root.left, level + 1, k);
		kthlevel(root.right, level + 1, k);
	}

}
