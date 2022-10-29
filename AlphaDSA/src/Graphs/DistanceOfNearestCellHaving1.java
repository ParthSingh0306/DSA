package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DistanceOfNearestCellHaving1 {

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
		System.out.println(Arrays.deepToString(nearest(grid)));
		scn.close();
	}
	
	static class Pair{
        int row;
        int col;
        int steps;
        Pair(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
	
    //Function to find distance of nearest 1 in the grid for each cell.
    public static int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }
        
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        
        //n*m*4
        while(!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().steps;
            q.remove();
            
            dist[row][col] = steps;
            
            for(int i=0; i<4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m 
                   && vis[nrow][ncol] == 0) {
                      vis[nrow][ncol] = 1;
                      q.add(new Pair(nrow, ncol, steps + 1));
               }
            }
        }
        return dist;
    }	

}
