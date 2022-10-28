package BST;

public class DeleteNodeInBST extends BST {

	public static void main(String[] args) {
		int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
		Node root = null;
		
		for(int i=0; i<values.length; i++) {
			root = insert(root, values[i]);
		}
		
		inOrder(root);
		System.out.println();
		
		root = delete(root, 4);
		System.out.println();
		
		inOrder(root);
	}
	
	public static Node delete(Node root, int val) {
		if(root.data > val) {
			root.left = delete(root.left, val);
		} else if(root.data < val) {
			root.right = delete(root.right, val);
		} else {
//			case 1 - leaf Node
			if(root.left == null && root.right == null) {
				return null;
			}
			
//			case 2 - single child
			if(root.left == null) {
				return root.right;
			} else if(root.right == null) {
				return root.left;
			}
			
//			case 3 - both children
			Node IS = findInOrderSuccessor(root.right);
			root.data = IS.data;
			root.right = delete(root.right, IS.data);
		}
		return root;
	}

	private static Node findInOrderSuccessor(Node root) {
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}
	


}
