package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import BinaryTrees.BinaryTreeB.Node;
//https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
public class zigZagTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(ZigZagTraversal(root));
	}
	
//	T.C = O(N)
//	S.C = O(N)
	public static ArrayList<Integer> ZigZagTraversal(Node root){
	    ArrayList<Integer> result = new ArrayList<>();
	    if(root == null) return result;
	    Queue<Node> q = new LinkedList<>();
	    q.add(root);
	    boolean flag = true;
	    
	    while(!q.isEmpty()){
	        int n = q.size();
	        ArrayList<Integer> ans = new ArrayList<>();
	        for(int i=0; i<n; i++){
	        	Node front = q.poll();
	        	ans.add(front.data);
	            if(front.left != null) q.add(front.left);
	            if(front.right != null) q.add(front.right);
	        }
	        if(flag) {
	        	for(int i : ans){
	        		result.add(i);
	        	}
	        	flag = false;
	        } else {
	        	for(int i=ans.size()-1; i>=0; i--){
	        		result.add(ans.get(i));
	        	}
	        	flag = true;
	        }
	    }
	    return result;
	}

}
