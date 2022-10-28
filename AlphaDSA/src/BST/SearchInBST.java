package BST;

public class SearchInBST extends BST {

	public static void main(String[] args) {
		int[] values = {5, 1, 3, 4, 2, 6};
		Node root = null;
		
		for(int i=0; i<values.length; i++) {
			root = insert(root, values[i]);
		}
		
		System.out.println(search(root, 6));
	}
	
	public static boolean search(Node root, int key) {
		if(root == null) {
			return false;
		}
		
		if(root.data == key) {
			return true;
		}
		
		if(root.data > key) { 
			//search in left
			return search(root.left, key);
		} else {
			//search in right
			return search(root.right, key);
		}
	}

}
