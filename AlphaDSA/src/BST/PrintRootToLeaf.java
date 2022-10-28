package BST;

import java.util.ArrayList;

public class PrintRootToLeaf extends BST{

	public static void main(String[] args) {
		int[] values = {8, 5, 3, 6, 10, 11, 14};
		Node root = null;
		
		for(int i=0; i<values.length; i++) {
			root = insert(root, values[i]);
		}
		
		printRoot2Leaf(root, new ArrayList<Integer>());
	}
	
	public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
		if(root == null) {
			return;
		}
		
		path.add(root.data);
		if(root.left  == null && root.right == null) {
			printPath(path);
		}
		
		printRoot2Leaf(root.left, path);
		printRoot2Leaf(root.right, path);
		path.remove(path.size()-1);
	}

	private static void printPath(ArrayList<Integer> path) {
		for(int i: path) {
			System.out.print(i + "->");
		}
		System.out.println("Null");
	}

}
