package BinaryTrees;

import java.util.ArrayList;
//https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1
import BinaryTrees.BinaryTreeB.Node;

public class RightViewOfBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		ArrayList<Integer> ans = new ArrayList<>();
	    rightv(root, 0, ans);
	    System.out.println(ans);
	}
	
    public static void rightv(Node root, int level,  ArrayList<Integer> ans){
        if(root == null) return;
        
        if(ans.size() == level) ans.add(root.data);
        rightv(root.right, level+1, ans);
        rightv(root.left, level+1, ans);
    }

}
