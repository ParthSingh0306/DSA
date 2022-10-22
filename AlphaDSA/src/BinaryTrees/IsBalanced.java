package BinaryTrees;

import BinaryTrees.BinaryTreeB.Node;

public class IsBalanced {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(8);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(isBalanced2(root));
	}
	
//	T.C = O(N^2)
	public static boolean isBalanced(Node root) {
		if(root == null) {
			return true;
		}
		
		boolean leftAns = isBalanced(root.left);
		boolean rightAns = isBalanced(root.right);
		
		boolean diff = Math.abs(height(root.left) - height(root.right)) <= 1;
		
		if(leftAns && rightAns && diff) return true;
		return false;
	}
	
	public static int height(Node root) {
		if(root == null) {
			return 0;
		}
		
		int left = height(root.left);
		int right = height(root.right);
		
		return 1 + Math.max(left, right);
	}
	
//	T.C = O(N)
   static  class pair{
        boolean first;
        int ht;
        
        pair(boolean first, int ht){
            this.first = first;
            this.ht = ht;
        }
    }

    public static boolean isBalanced2(Node root) {
	   return isBalancedFast(root).first;
    }
    
    public static pair isBalancedFast(Node root){
        if(root == null){
	       return new pair(true, 0);
	   }
	   pair left = isBalancedFast(root.left);
	   pair right = isBalancedFast(root.right);
	   
	   boolean leftAns = left.first;
	   boolean rightAns = right.first;
	   
	   int lh = left.ht;
	   int rh = right.ht;
	   
	   boolean diff = Math.abs(lh - rh) <= 1;
	   pair ans = new pair(true, 0);
	   ans.ht =  Math.max(lh, rh) + 1;
	   if(leftAns && rightAns && diff){
	       ans.first = true;
	   } else {
	       ans.first = false;
	   }
	   
	   return ans;
    }

}
