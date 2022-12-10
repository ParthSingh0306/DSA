package DP;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumPathSum {
	static int mod = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] grid = {
				{1, 3, 1},
				{1, 5, 1},
				{4, 2, 1}
		};
		int n = grid.length;
		int m = grid[0].length;
		
		//Recursion
		System.out.println(f(n-1, m-1, grid));
		
		//Memoization
		int[][] dp = new int[n][m];
		for(int[] row : dp) Arrays.fill(row, -1);
		System.out.println(memo(n-1, m-1, grid, dp));
		
		//Tabulation
		System.out.println(tabu(n, m, grid));
		
		//space optimisation
		System.out.println(space_op(n, m, grid));
	}
	
	//T.C = O(2^N) S.C = O(N) 
	public static int f(int n, int m, int[][] grid) {
		if(n == 0 && m == 0) return grid[n][m];
		if(n<0 || m<0) return (int) Math.pow(10, 9);
		int up = grid[n][m] + f(n-1, m, grid);
		int down = grid[n][m] + f(n, m-1, grid);
		return Math.min(up, down);
	}
	
	//T.C = O(N^2) S.C = O(N) + O(N^2) 
	public static int memo(int n, int m, int[][] grid, int[][] dp) {
		if(n == 0 && m == 0) return grid[n][m];
		if(n<0 || m<0) return (int) Math.pow(10, 9);
		if(dp[n][m] != -1) return dp[n][m];
		int up = grid[n][m] + f(n-1, m, grid);
		int down = grid[n][m] + f(n, m-1, grid);
		return dp[n][m] = Math.min(up, down);
	}
	
	//T.C = O(N^2) S.C = O(N^2) 
	public static int tabu(int n, int m, int[][] grid) {
		int[][] dp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i==0 && j==0) dp[i][j] = grid[i][j];
				else {
					int up = grid[i][j], left = grid[i][j];
					if(i>0) up += dp[i-1][j];
					else {
						up += mod;
					}
					if(j>0) left += dp[i][j-1];
					else {
						left += mod;
					}
					dp[i][j] = Math.min(up, left);
				}
			}
		}
		return dp[n-1][m-1];
	}
	
	//T.C = O(N^2) S.C = O(N^2) 
	public static int space_op(int n, int m, int[][] grid) {
		int[] prev = new int[m];
		
		for(int i=0; i<n; i++) {
			int[] curr = new int[m];
			for(int j=0; j<m; j++) {
				if(i==0 && j==0) curr[j] = grid[i][j];
				else {
					int up = grid[i][j], left = grid[i][j];
					if(i>0) up += prev[j];
					else {
						up += mod;
					}
					if(j>0) left += curr[j-1];
					else {
						left += mod;
					}
					curr[j] = Math.min(up, left);
				}
			}
			prev = curr;
		}
		return prev[m-1];
	}

}
