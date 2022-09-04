package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SpiralMatrix {

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
		
		for(int i=0; i<n; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		spiral(arr, arr.length, arr[0].length);
	}
	
	public static void spiral(int[][] arr, int n, int m) {
		int top = 0;
		int bottom = n-1;
		int left = 0;
		int right = m-1;
		int lim = m * n;
		
		while(lim > 0) {
			for(int i=left; i<=right && lim > 0; i++) {
				System.out.print(arr[top][i] + " ");
				lim--;
			}
			top++;
			
			for(int i=top; i<=bottom && lim > 0; i++) {
				System.out.print(arr[i][right] + " ");
				lim--;
			}
			right--;
			
			if(left <= right) {
				for(int i=right; i>=left && lim > 0; i--) {
					System.out.print(arr[bottom][i] + " ");
					lim--;
				}
				bottom--;	
			}
			
			if(top <= bottom) {
				for(int i=bottom; i>=top && lim > 0; i--) {
					System.out.print(arr[i][left] + " ");
					lim--;
				}
				left++;	
			}
		}

	}

}
