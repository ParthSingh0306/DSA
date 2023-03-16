package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;


public class SerializeDeserializeBT {
	
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
		
	}
	
    public static String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder res = new StringBuilder("");
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                res.append("n ");
                continue;
            }

            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1; i<values.length; i++) {
            TreeNode node = q.poll();
            if(!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                q.add(left);
            }

            if(!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                q.add(right);
            }
        }

        return root;
    }

}
