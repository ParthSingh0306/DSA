package BinaryTrees;

import BinaryTrees.BinaryTreeB.BinaryTree;
import BinaryTrees.BinaryTreeB.Node;

public class PreOrderTraversal {
	
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
	}

}
