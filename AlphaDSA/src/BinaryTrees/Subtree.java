package BinaryTrees;

import BinaryTrees.BinaryTreeB.Node;

public class Subtree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		Node subroot = new Node(2);
		subroot.left = new Node(4);
		subroot.right = new Node(7);
		System.out.println(isSubtree(root, subroot));
	}
	
	public static boolean isSubtree(Node root, Node subroot) {
		if(root == null) {
			return false;
		}
		if(root.data == subroot.data) {
			if(isIdentical(root, subroot)) {
				return true;
			}
		}
		
//		boolean leftans = isSubtree(root.left, subroot);
//		boolean rightans = isSubtree(root.right, subroot);
//		return leftans || rightans;
		
		return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
	}

	private static boolean isIdentical(Node root, Node subroot) {
		if(root == null && subroot == null) {
			return true;
		} else if(root == null || subroot == null || root.data != subroot.data) {
			return false;
		}
		
		if(!isIdentical(root.left, subroot.left)) {
			return false;
		} 
		if(!isIdentical(root.right, subroot.right)) {
			return false;
		}
		return true;
	}

}
