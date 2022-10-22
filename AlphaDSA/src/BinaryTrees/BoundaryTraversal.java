package BinaryTrees;

import java.util.ArrayList;

import BinaryTrees.BinaryTreeB.Node;

public class BoundaryTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(boundary(root));
	}
	
    public static void traverseLeft(Node root, ArrayList <Integer> ans) {
        if(root == null || (root.left == null && root.right == null)) {
            return;
        }
        ans.add(root.data);
        if(root.left != null){
            traverseLeft(root.left, ans);
        } else {
            traverseLeft(root.right, ans);
        }
    }
    
    public static void traverseRight(Node root, ArrayList <Integer> ans) {
        if(root == null || (root.left == null && root.right == null)) {
            return;
        }
        if(root.right != null){
            traverseRight(root.right, ans);
        } else {
            traverseRight(root.left, ans);
        }
        ans.add(root.data);
    }
    
    public static void traverseLeaf(Node root, ArrayList <Integer> ans) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            ans.add(root.data);
            return;
        }
        traverseLeaf(root.left, ans);
        traverseLeaf(root.right, ans);
    }
    
	public static ArrayList <Integer> boundary(Node node)
	{
	  Node root = node;
	  ArrayList<Integer> ans = new ArrayList<>(); 
	  if(root == null) return ans;
	  ans.add(root.data);
	  traverseLeft(root.left, ans);
	  traverseLeaf(root.left, ans);
	  traverseLeaf(root.right, ans);
	  traverseRight(root.right, ans);
	  return ans;
	}

}
