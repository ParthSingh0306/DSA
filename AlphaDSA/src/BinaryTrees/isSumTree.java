package BinaryTrees;

import BinaryTrees.BinaryTreeB.Node;
// https://practice.geeksforgeeks.org/problems/sum-tree/1
public class isSumTree {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(isSumTree2(root));
	}
	
    static class pair{
        boolean first;
        int sum;
        
        pair(boolean first, int sum){
            this.first = first;
            this.sum = sum;
        }
    }
//    T.C = O(N)
//    S.C = O(H)
    public static pair isSumTreeFast(Node root)
	{
       if(root == null){
           return new pair(true, 0);
       }
       if(root.left == null && root.right == null){
           return new pair(true, root.data);
       }
       
       pair left = isSumTreeFast(root.left); 
       pair right = isSumTreeFast(root.right); 
       
       boolean leftAns = left.first;
       boolean rightAns = right.first;
       
       boolean cond = root.data == left.sum + right.sum;
       pair ans = new pair(true, 0);
       if(leftAns && rightAns && cond){
           ans.first = true;
           ans.sum = 2 * root.data;
       } else {
           ans.first = false;
       }
       return ans;
	}
    
	public static boolean isSumTree2(Node root)
	{
        return isSumTreeFast(root).first;
	}

}
