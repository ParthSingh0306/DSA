package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfEnclaves {

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
		System.out.println(numEnclaves(grid));
		scn.close();
	}
	
    static class Pair{
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<Pair>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0 ||j==0 || i==n-1 || j==m-1) {
                    if(grid[i][j] == 1) {
                        q.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();

            for(int i=0; i<4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m 
                   && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                       vis[nrow][ncol] = 1;
                       q.add(new Pair(nrow, ncol));
               }
            }
        }

            int cnt = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(vis[i][j] == 0 && grid[i][j] == 1) cnt++;
                }
            }
            return cnt;
    }	

}
