package BinaryTrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import BinaryTrees.BinaryTreeB.BinaryTree;
import BinaryTrees.BinaryTreeB.Node;

public class PreOrderTraversal {
	
//	Recursive
	public static void preOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void main(String[] args) {
		int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
		preOrder(root);
		System.out.println();
		System.out.println(preOrder2(root));
	}
	
//	Iterative
//	T.C = O(N)
//	S.C = O(N)
	public static List<Integer> preOrder2(Node root){
		List<Integer> list = new LinkedList<Integer>();
		Stack<Node> st = new Stack<Node>();
		if(root == null) return list;
		st.push(root);
		while(!st.isEmpty()) {
			root = st.pop();
			list.add(root.data);
			if(root.right != null) {
				st.push(root.right);
			}
			if(root.left != null) {
				st.push(root.left);
			}
		}
		return list;
	}

}
