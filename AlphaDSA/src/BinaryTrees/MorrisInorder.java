package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorder {
	
	static class TreeNode {
	    int val;
	    TreeNode left, right;
	    TreeNode(int val) {
	        this.val = val;
	        left = null;
	        right = null;
	    }
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);
        System.out.println(inorderTraversal(root));
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
        //Morriss traversal
        List<Integer> in = new ArrayList<>();
        if(root == null) return in;
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left == null) {
                in.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if(prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                else {
                    prev.right = null;
                    in.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return in;
    }

}
