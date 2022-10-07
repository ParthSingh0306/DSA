package BinaryTrees;

import BinaryTrees.BinaryTreeB.BinaryTree;
import BinaryTrees.BinaryTreeB.Node;

public class PostOrder {
	
	public static void postOrder(Node root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static void main(String[] args) {
		int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
		postOrder(root);
	}

}
