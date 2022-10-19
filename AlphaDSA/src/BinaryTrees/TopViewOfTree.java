package BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import BinaryTrees.BinaryTreeB.Node;

public class TopViewOfTree {
	
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
		
		topView(root); // one by one print
		System.out.println();
		System.out.println(topView2(root)); //store in list and then print
	}
	
	public static void topView(Node root) {
		Queue<Pair> q = new LinkedList<>();
		HashMap<Integer, Node> map = new HashMap<>();
		int min = 0, max = 0;
		q.add(new Pair(root, 0));
		q.add(null);
		
		while(!q.isEmpty()) {
			Pair curr = q.remove();
			if(curr == null) {
				if(q.isEmpty()) {
					break;
				} else {
					q.add(null);
				}
			} 
			else {	
				if(!map.containsKey(curr.hd)) {
					map.put(curr.hd, curr.node);
				}
				
				if(curr.node.left != null) {
					q.add(new Pair(curr.node.left, curr.hd-1));
					min = Math.min(min, curr.hd-1);
				}
				
				if(curr.node.right != null) {
					q.add(new Pair(curr.node.right, curr.hd+1));
					max = Math.max(max, curr.hd+1);
				}
			}
			
		}
		
		for(int i=min; i<=max; i++) {
			System.out.print(map.get(i).data + " ");
		}
	}
	
	
	public static ArrayList<Integer> topView2(Node root){
		ArrayList<Integer> ans = new ArrayList<>();
		if(root == null) return ans;
		Queue<Pair> q = new LinkedList<Pair>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		q.add(new Pair(root, 0));
		
		while(!q.isEmpty()) {
			Pair it = q.remove();
			int hd = it.hd;
			Node temp = it.node;
			
			if(map.get(hd) == null) map.put(hd, temp.data);
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
