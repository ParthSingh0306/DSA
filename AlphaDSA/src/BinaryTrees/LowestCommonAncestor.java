package BinaryTrees;

import java.util.ArrayList;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
import BinaryTrees.BinaryTreeB.Node;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		int n = 4, m = 5;
		System.out.println(lca2(root, n, m).data);
	}
//	T.C = O(N)
	public static Node lca(Node root, int n, int m) {
		ArrayList<Node> path1 = new ArrayList<>();
		ArrayList<Node> path2 = new ArrayList<>();
		
		getpath(root, n, path1);
		getpath(root, m, path2);
		
		int i=0;
		for(; i<path1.size() && i<path2.size(); i++) {
			if(path1.get(i) != path2.get(i)) {
				break;
			}
		}
		
		Node lca = path1.get(i-1);
		return lca;
	}

	private static boolean getpath(Node root, int n, ArrayList<Node> path) {
		if(root == null) {
			return false;
		}
		
		path.add(root);
		
		if(root.data == n) {
			return true;
		}
		
		boolean foundleft = getpath(root.left, n, path);
		boolean foundright = getpath(root.right, n, path);
		
		if(foundleft || foundright) {
			return true;
		}
		
		path.remove(path.size()-1);
		return false;
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

}
