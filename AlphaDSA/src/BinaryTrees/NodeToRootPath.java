package BinaryTrees;

import java.util.ArrayList;


public class NodeToRootPath {
	
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

        ArrayList<Integer> arr = new ArrayList<>();

        getPath(root, arr, 7);
        System.out.println(arr);
	}
	
	public static ArrayList<Integer> solve(TreeNode root, int b) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        getPath(root, ans, b);
        return ans;
    }
    
    public static boolean getPath(TreeNode root, ArrayList<Integer> ans, int b) {
        if(root == null) return false;
        ans.add(root.val);
        if(root.val == b) return true;
        if(getPath(root.left, ans, b) || getPath(root.right, ans, b)) {
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }

}
