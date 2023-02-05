package Graphs.BFSandDFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

	public static void main(String[] args) {
		int[][] grid = {
				{1, 1, 0, 0, 0},
				{1, 0, 0, 0, 0},
				{0, 0, 0, 0, 1},
				{0, 0, 0, 1, 1},
		}; 
		System.out.println(countDistinctIslands(grid));
	}
	
    public static String toString(int row, int col) {
        return Integer.toString(row) + " " + Integer.toString(col);
    }
	
    public static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        Set<ArrayList<String>> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0) {
                    ArrayList<String> arr = new ArrayList<>();
                    dfs(i, j, vis, grid, arr, i, j);
                    set.add(arr);
                }
            }
        }
        return set.size();
    }
    
    public static void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> arr, int row0, int col0) {
        vis[row][col] = 1;
        arr.add(toString(row - row0, col - col0));
        int n = grid.length;
        int m = grid[0].length;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};
        for(int i=0; i<4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            
            if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m 
                && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid, arr, row0, col0);
            }
        }
    }

}
