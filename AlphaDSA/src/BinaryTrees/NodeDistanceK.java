package BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NodeDistanceK {
	
	static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

	public static void main(String[] args) {
		  TreeNode  root = new TreeNode(2);
		  root.left = new TreeNode(35);
		  root.left.left = new TreeNode(2);
		  root.left.right = new TreeNode(3);
		  root.right = new TreeNode(10);
		  root.right.left = new TreeNode(5);
		  root.right.right = new TreeNode(2);
		  System.out.println(distanceK(root, root.left.left, 1));
	}
	
	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> vis = new HashMap<>();
        vis.put(target, true);
        q.offer(target);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            if(level == k) break;
            level++;
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                if(curr.left != null && vis.get(curr.left) == null) {
                    q.offer(curr.left);
                    vis.put(curr.left, true);
                }
                if(curr.right != null && vis.get(curr.right) == null) {
                    q.offer(curr.right);
                    vis.put(curr.right, true);
                }
                if(parent.get(curr) != null && vis.get(parent.get(curr)) == null) {
                    q.offer(parent.get(curr));
                    vis.put(parent.get(curr), true);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }
	
	public static void markParent(TreeNode root, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.left != null) {
                parent.put(curr.left , curr);
                q.offer(curr.left);
            }
            if(curr.right != null) {
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

}
