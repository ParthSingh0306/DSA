package BinaryTrees;

import BinaryTrees.BinaryTreeB.Node;

public class DiameterOfTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(diam(root));
		Info ans = diameter2(root);
		System.out.println(ans.diam + " " + ans.ht);
	}
	
	public static int Height(Node root) {
		if(root == null) {
			return 0;
		}
		
		int lh = Height(root.left) + 1;
		int rh = Height(root.right) + 1;
		
		return Math.max(lh, rh);
	}
	
//	T.C = O(N^2)
	public static int diam(Node root) {
		if(root == null) {
			return 0;
		}
		
		int leftDiam = diam(root.left);
		int lh = Height(root.left);
		int rightDiam = diam(root.right);
		int rh = Height(root.right);
		
		int selfDiam = lh + rh + 1;
		
		return Math.max(leftDiam, Math.max(rightDiam, selfDiam));
	}
	
	static class Info{
		int diam;
		int ht;
		
		public Info(int diam, int ht) {
			this.diam = diam;
			this.ht = ht;
		}
	}
	
//	T.C = O(N)
	public static Info diameter2(Node root) {
		
		if(root == null) {
			return new Info(0, 0);
		}
		
		Info leftinfo = diameter2(root.left);
		Info rightinfo = diameter2(root.right);
		
		int diam = Math.max(leftinfo.diam, Math.max(rightinfo.diam, leftinfo.ht + rightinfo.ht + 1));
		int ht = Math.max(leftinfo.ht, rightinfo.ht) + 1;
		
		return new Info(diam, ht);
	}

}
