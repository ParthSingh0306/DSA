package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import BinaryTrees.BinaryTreeB.Node;
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
public class VerticalOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(vertical(root));
	}
	
	static class Tuple{
		Node node;
		int row;
		int level;
		
		Tuple(Node node, int row, int level){
			this.node = node;
			this.row = row;
			this.level = level;
		}
	}
	
	public static List<List<Integer>> vertical(Node root){
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		Queue<Tuple> q = new LinkedList<Tuple>();
		q.offer(new Tuple(root, 0, 0));
		
		while(!q.isEmpty()) {
			Tuple t = q.poll();
			Node node = t.node;
			int row = t.row;
			int level = t.level;
			
			if(!map.containsKey(row)) {
				map.put(row, new TreeMap<>());
			}
			if(!map.get(row).containsKey(level)) {
				map.get(row).put(level, new PriorityQueue<>());
			}
			map.get(row).get(level).offer(node.data);
			
			if(node.left != null) {
				q.add(new Tuple(node.left, row - 1, level + 1));
			}
			if(node.right != null) {
				q.add(new Tuple(node.right, row + 1, level + 1));
			}
		}
		
		List<List<Integer>> list = new ArrayList<>();
		for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
			list.add(new ArrayList<>());
			for(PriorityQueue<Integer> nodes: ys.values()) {
				while(!nodes.isEmpty()) {
					list.get(list.size()-1).add(nodes.poll());
				}
			}
		}
		return list;
	}

}
