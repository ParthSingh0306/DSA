package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
//https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
import BinaryTrees.BinaryTreeB.Node;

public class BottomViewOfTree {
	
	static class Pair{
		Node node;
		int hd;
		
		public Pair(Node node, int hd){
			this.node = node;
			this.hd = hd;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(BottomView(root)); //store in list and then print
	}
	
	public static ArrayList<Integer> BottomView(Node root){
		ArrayList<Integer> ans = new ArrayList<>();
		if(root == null) return ans;
		Queue<Pair> q = new LinkedList<Pair>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		q.add(new Pair(root, 0));
		
		while(!q.isEmpty()) {
			Pair it = q.remove();
			int hd = it.hd;
			Node temp = it.node;
			
			if(map.get(hd) == null) {
				map.put(hd, temp.data);
			} else {
				map.remove(hd);
				map.put(hd, temp.data);
			}
			if(temp.left != null) {
				q.add(new Pair(temp.left, hd-1));
			}
			if(temp.right != null) {
				q.add(new Pair(temp.right, hd+1));
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ans.add(entry.getValue());
		}
		return ans;
	}

}
