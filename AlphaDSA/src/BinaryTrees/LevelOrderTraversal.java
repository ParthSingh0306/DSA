package BinaryTrees;

import BinaryTrees.BinaryTreeB.BinaryTree;
import BinaryTrees.BinaryTreeB.Node;
import java.util.*;

public class LevelOrderTraversal {
	
	public static void levelOrder(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node currNode = q.remove();
			if(currNode == null) {
				System.out.println();
				if(q.isEmpty()) {
					break;
				} else {
					q.add(null);
				}
			} else {
				System.out.print(currNode.data + " ");
				if(currNode.left != null) {
					q.add(currNode.left);
				}
				if(currNode.right != null) {
					q.add(currNode.right);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
		levelOrder(root);
	    System.out.println(levelOrder2(root));
	}
	
	public static List<List<Integer>> levelOrder2(Node root) {
	  Queue<Node> q = new LinkedList<Node>();
	  List<List<Integer>> wrap = new LinkedList<List<Integer>>();
	  if(root == null) return wrap;
	  q.add(root);
	  
	  while(!q.isEmpty()) {
		  int level = q.size();
		  root = q.peek();
		  List<Integer> list = new LinkedList<Integer>();
		  for(int i=0; i<level; i++) {
			  if(q.peek().left != null) q.add(q.peek().left);
			  if(q.peek().right != null) q.add(q.peek().right);
			  list.add(q.poll().data);
		  }
		  wrap.add(list);
	  }
	  return wrap;
	} 

}
