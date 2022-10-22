package BinaryTrees;

import BinaryTrees.BinaryTreeB.Node;

public class MirrorTree {

	public static void main(String[] args) {
		Node root1 = new Node(5);
		root1.left = new Node(8);
		root1.right = new Node(3);
//		root1.left.left = new Node(4);
//		root1.left.right = new Node(5);
//		root1.right.left = new Node(6);
//		root1.right.right = new Node(7);
		
		Node root2 = new Node(5);
		root2.left = new Node(3);
		root2.right = new Node(8);
//		root2.left.left = new Node(7);
//		root2.left.right = new Node(6);
//		root2.right.left = new Node(5);
//		root2.right.right = new Node(4);
		
		System.out.println(isMirror(root1, root2));
		
		InOrder(root1);
		mirror(root1);
		System.out.println();
		InOrder(root1);
	}
	
//	checks univalued or not
	public static boolean isMirror(Node root1, Node root2) {
		if(root1 == null && root2 == null) return true;
		if(root1 == null) {
			return false;
		}
		if(root2 == null) {
			return false;
		}
		if(root1.data != root2.data) {
			return false;
		}
		
		boolean left = isMirror(root1.left, root2.right);
		boolean right = isMirror(root1.right, root2.left);
		
		if(left && right) return true;
		return false;
	}
	
	public static Node mirror(Node root) {
		if(root == null) {
			return null;
		}
		
		Node left = mirror(root.left);
		Node right = mirror(root.right);
		
		root.left = right;
		root.right = left;
		
		return root;
	}
	
	public static void InOrder(Node root) {
		if(root == null) {
			return;
		}
		InOrder(root.left);
		System.out.print(root.data + " ");
		InOrder(root.right);
	}

}
