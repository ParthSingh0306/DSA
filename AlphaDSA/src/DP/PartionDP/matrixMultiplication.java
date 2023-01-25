package DP.PartionDP;

import java.util.Arrays;

public class matrixMultiplication {

	public static void main(String[] args) {
		int[] arr = {10, 15, 20, 25};
		
		//rec + memo T.C=O(N^3) S.C = O(N^2 + N)
		System.out.println(MatrixMultiplication(arr, arr.length));
		
		//tabu T.C=O(N^3) S.C = O(N^2)
		System.out.println(tabu(arr, arr.length));
	}
	
	public static int MatrixMultiplication(int[] arr , int N) {
		int[][] dp = new int[N][N];
		for(int[] ar : dp) Arrays.fill(ar, -1);
		return f(1, N-1, arr, dp);
	}

	public static int f(int i, int j, int[] arr, int[][] dp) {
		if(i == j) return 0;
		if(dp[i][j] != -1) return dp[i][j];
		int min = Integer.MAX_VALUE;
		
		for(int k=i; k<=j-1; k++) {
			int step = arr[i-1] * arr[k] * arr[j] + f(i, k, arr, dp) + f(k+1, j, arr, dp);
			min = Math.min(min, step);
		}

		return dp[i][j] = min;
	}
	
	public static int tabu(int[] arr , int N) {
		int[][] dp = new int[N][N];
		
		for(int i=N-1; i>=1; i--) {
			for(int j=i+1; j<N; j++) {
				int min = Integer.MAX_VALUE;
		
				for(int k=i; k<=j-1; k++) {
					int step = arr[i-1] * arr[k] * arr[j] 
					+ dp[i][k] 
					+ dp[k+1][j];
					min = Math.min(min, step);
				}

				dp[i][j] = min;
			}
		}

		return dp[1][N-1];
	}

}
