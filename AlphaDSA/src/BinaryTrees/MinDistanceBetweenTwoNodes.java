package BinaryTrees;

import BinaryTrees.BinaryTreeB.Node;

public class MinDistanceBetweenTwoNodes {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		int n = 4, m = 3;
		System.out.println(minDist(root, n, m));
	}
	
	public static Node lca2(Node root, int n, int m) {
		if(root == null) {
			return null;
		}
		if(root.data == n || root.data == m) {
			return root;
		}
		
		Node leftlca = lca2(root.left, n, m);
		Node rightlca = lca2(root.right, n, m);
		
		if(rightlca == null) {
			return leftlca;
		} 
		if(leftlca == null){
			return rightlca;
		}
		
		return root;
			
	}
	
	public static int minDist(Node root, int n, int m) {
		Node lca = lca2(root, n, m);
		int dist1 = lcaDist(lca, n);
		int dist2 = lcaDist(lca, m);
		
		return dist1 + dist2;
	}

	private static int lcaDist(Node root, int n) {
		if(root == null) {
			return -1;
		}
		if(root.data == n) {
			return 0;
		}
		
		int leftDist = lcaDist(root.left, n);
		int rightDist = lcaDist(root.right, n);
		
		if(leftDist == -1 && rightDist == -1) {
			return -1;
		} else if(leftDist == -1) {
			return rightDist + 1;
		} else {
			return leftDist + 1;
		}
		
	}

}
