package DP;

import java.util.Arrays;
import java.util.Scanner;

public class MaximimFalllingPathSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] grid = {
				{2, 1, 3},
				{6, 5, 4},
				{7, 8, 9}
		};
		int n = grid.length;
		int m = grid[0].length;
		
		System.out.println(tabu(grid));
	}
	
	public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int min = Integer.MAX_VALUE;
        
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        for(int j=0; j<n; j++) {
            min = Math.min(min, memo(n-1, j, matrix, dp));
        }
        return min;
    }
	
    public static int rec(int i, int j, int[][] grid) {
        if(j<0 || j>=grid[0].length) return (int) Math.pow(10, 9);
        if(i==0) return grid[0][j];

        int dl = grid[i][j] + rec(i-1, j, grid);
        int dc = grid[i][j] + rec(i-1, j-1, grid);
        int dr = grid[i][j] + rec(i-1, j+1, grid);

        return Math.min(dl, Math.min(dc, dr));
    }
    
    public static int memo(int i, int j, int[][] grid, int[][] dp) {
        if(j<0 || j>=grid[0].length) return (int) Math.pow(10, 9);
        if(i==0) return grid[0][j];
        if(dp[i][j] != -1) return dp[i][j];
        int dl = grid[i][j] + memo(i-1, j, grid, dp);
        int dc = grid[i][j] + memo(i-1, j-1, grid, dp);
        int dr = grid[i][j] + memo(i-1, j+1, grid, dp);

        return dp[i][j] = Math.min(dl, Math.min(dc, dr));
    }
    
    public static int tabu(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int j=0; j<m; j++) dp[0][j] = grid[0][j];
        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++) {
                int dl = grid[i][j] + dp[i-1][j]; 

                int dc = grid[i][j];
                if(j-1 >= 0) dc += dp[i-1][j-1]; 
                else dc += (int) Math.pow(10, 9);

                int dr = grid[i][j];
                if(j+1<m) dr += dp[i-1][j+1];
                else dr += (int) Math.pow(10, 9);

                dp[i][j] = Math.min(dl, Math.min(dc, dr));
            }
        }
        

        int min = Integer.MAX_VALUE;
        for(int j=0; j<n; j++) {
            min = Math.min(min, dp[n-1][j]);
        }
        return min;
    }

}
