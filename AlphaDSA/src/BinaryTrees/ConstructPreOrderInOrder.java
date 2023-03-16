package BinaryTrees;

import java.util.HashMap;
import java.util.Map;

public class ConstructPreOrderInOrder {
	
	static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

	public static void main(String[] args) {
		int preorder[] = {10,20,40,50,30,60};
	    int inorder[] = {40,20,50,10,60,30};
	    TreeNode root = buildTree(preorder, inorder);
	    System.out.println(root);
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int m = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, n-1, inorder, 0, m-1, map);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder,
        int inStart, int inEnd, Map<Integer, Integer> map) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(preorder[preStart]);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft,
         inorder, inStart, inRoot-1, map);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, 
         inorder, inRoot + 1, inEnd, map);

        return root;
    }

}
