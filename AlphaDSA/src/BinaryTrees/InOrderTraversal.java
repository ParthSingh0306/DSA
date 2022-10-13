package BinaryTrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import BinaryTrees.BinaryTreeB.BinaryTree;
import BinaryTrees.BinaryTreeB.Node;

public class InOrderTraversal {
	
	public static void InOrder(Node root) {
		if(root == null) {
			return;
		}
		InOrder(root.left);
		System.out.print(root.data + " ");
		InOrder(root.right);
	}

	public static void main(String[] args) {
		int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
		InOrder(root);
		System.out.println();
		System.out.println(InOrder2(root));
	}
	
	public static List<Integer> InOrder2(Node root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<Node> st = new Stack<Node>();
		Node node = root;
		
		while(true) {
			if(node != null) {
				st.push(node);
				node = node.left;
			} 
			else {
				if(st.isEmpty()) {
					break;
				} 
					node = st.pop();
					list.add(node.data);
					node = node.right;
			}
		}
		return list;
	}

}
