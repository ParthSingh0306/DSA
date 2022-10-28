package BST;

public class PrintInRange extends BST{

	public static void main(String[] args) {
		int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
		Node root = null;
		
		for(int i=0; i<values.length; i++) {
			root = insert(root, values[i]);
		}
		
		printInRange2(root, 5, 12);
	}
	
//	Brute force
	public static void printInRange(Node root, int k1, int k2) {
		if(root == null) return;
		
		printInRange(root.left, k1, k2);
		if(root.data >= k1 && root.data <= k2) System.out.print(root.data + " ");
		printInRange(root.right, k1, k2);
	}

//	Improved
	public static void printInRange2(Node root, int k1, int k2) {
		if(root == null) return;
		
		if(root.data >= k1 && root.data <= k2) {
			printInRange2(root.left, k1, k2);
			System.out.print(root.data + " ");
			printInRange2(root.right, k1, k2);
		} else if(root.data < k1) {
			printInRange2(root.left, k1, k2);
		} else {
			printInRange2(root.right, k1, k2);
		}
	}
}
