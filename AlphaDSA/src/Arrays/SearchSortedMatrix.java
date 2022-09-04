package Arrays;

import java.util.Scanner;

public class SearchSortedMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int target = sc.nextInt();
		search(arr, target);
	}
	
	public static void search(int[][] matrix, int target) {
		int row = 0;
		int col = matrix[0].length-1;
		
		while(row < matrix.length && col >= 0) {
			if(matrix[row][col] == target) {
				System.out.println(row + " " + col);
				break;
			} else if(matrix[row][col] < target) {
				row++;
			}else {
				col--;
			}
		}
		
	}
}
