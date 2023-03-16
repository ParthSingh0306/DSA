package BinaryTrees;

public class CompleteBinaryTreeNodes {
	
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
		  TreeNode  root = new TreeNode(2);
		  root.left = new TreeNode(35);
		  root.left.left = new TreeNode(2);
		  root.left.right = new TreeNode(3);
		  root.right = new TreeNode(10);
		  root.right.left = new TreeNode(5);
		  root.right.right = new TreeNode(2);
		  System.out.println(countNodes(root));
	}
	
	 	public static int countNodes(TreeNode root) {
	        if(root == null) return 0;

	        int lh = findLeft(root.left);
	        int rh = findRight(root.right);

	        if(lh == rh) return ((2<<lh)-1);

	        return 1 + countNodes(root.left) + countNodes(root.right);
	    }

	    public static int findLeft(TreeNode node) {
	        int cnt = 0;
	        while(node != null) {
	            cnt++;
	            node = node.left;
	        }
	        return cnt;
	    }

	    public static int findRight(TreeNode node) {
	        int cnt = 0;
	        while(node != null) {
	            cnt++;
	            node = node.right;
	        }
	        return cnt;
	    }

}
