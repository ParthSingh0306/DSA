package BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import BinaryTrees.BinaryTreeB.BinaryTree;
import BinaryTrees.BinaryTreeB.Node;

public class ThreeTraversalInOne {
	
	static class Pair{
		Node node;
		int num;
		
		Pair(Node node, int num){
			this.node = node;
			this.num = num;
		}
	}

	public static void main(String[] args) {
		int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
		traversal(root);
	}
	
	public static void traversal(Node root) {
		Stack<Pair> st = new Stack<Pair>();
		st.push(new Pair(root, 1));
		List<Integer> pre = new ArrayList<>();
		List<Integer> In = new ArrayList<>();
		List<Integer> post = new ArrayList<>();
		if(root == null) return;
		
		while(!st.isEmpty()) {
			Pair it = st.pop();
			
			if(it.num == 1) {
				pre.add(it.node.data);
				it.num++;
				st.push(it);
				
				if(it.node.left != null) {
					st.push(new Pair(it.node.left, 1));
				}
			}
			
			else if(it.num == 2) {
				In.add(it.node.data);
				it.num++;
				st.push(it);
				
				if(it.node.right != null) {
					st.push(new Pair(it.node.right, 1));
				}
			}
			
			else {
				post.add(it.node.data);
			}
		}
		
		System.out.println(pre);
		System.out.println(In);
		System.out.println(post);
	}

}
