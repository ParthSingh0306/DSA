package Graphs.BFSandDFS;

import java.util.Arrays;
import java.util.Scanner;
//https://leetcode.com/problems/flood-fill/description/
//https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1
public class FloodFill {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] grid = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				grid[i][j] = scn.nextInt();
			}
		}
		int newColor = scn.nextInt();
		int sr = scn.nextInt();
		int sc = scn.nextInt();
		System.out.println(Arrays.deepToString(floodFill(sr, sc, grid, newColor)));
		scn.close();
	}

	private static int[][] floodFill(int sr, int sc, int[][] image, int newColor) {
		int[][] ans = image;
		int iniColor = image[sr][sc];
		int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
		dfs(sr, sc, iniColor, newColor, image, ans, delrow, delcol);
		return ans;
	}
	
	private static void dfs(int row, int col, int iniColor, int newColor, int[][] image, 
			int[][] ans, int[] delrow, int[] delcol) {
		ans[row][col] = newColor;
		int n = image.length;
		int m = image[0].length;
		
		for(int i=0; i<4; i++) {
			int nrow = row + delrow[i];
			int ncol = col + delcol[i];
			
			if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol] == iniColor 
					&& ans[nrow][ncol] != newColor) {
				dfs(nrow, ncol, iniColor, newColor, image, ans, delrow, delcol);
			}
		}
	}
	
}
