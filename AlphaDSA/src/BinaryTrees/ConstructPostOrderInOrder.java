package BinaryTrees;

import java.util.HashMap;
import java.util.Map;

public class ConstructPostOrderInOrder {
	
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
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		TreeNode root = buildTree(inorder, postorder);
		System.out.println(root);
	}
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        int m = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(postorder, 0, n-1, inorder, 0, m-1, map);
        return root;
    }

    public static TreeNode buildTree(int[] postorder, int posStart, int posEnd, int[] inorder,
        int inStart, int inEnd, Map<Integer, Integer> map) {
        if(posStart > posEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[posEnd]);
        int inRoot = map.get(postorder[posEnd]);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(postorder, posStart, posStart + numsLeft - 1,
         inorder, inStart, inRoot-1, map);
        root.right = buildTree(postorder, posStart + numsLeft, posEnd - 1, 
         inorder, inRoot + 1, inEnd, map);

        return root;
    }

}
