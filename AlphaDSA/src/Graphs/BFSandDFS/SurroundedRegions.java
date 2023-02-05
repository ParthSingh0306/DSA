package Graphs.BFSandDFS;

import java.util.Arrays;
import java.util.Scanner;

public class SurroundedRegions {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		char[][] grid = new char[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				grid[i][j] = scn.next().charAt(0);
			}
		}
		solve(grid);
		System.out.println(Arrays.deepToString(grid));
		scn.close();
	}
	
    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0 || j==0 || i==n-1 || j==m-1) {
                    if(board[i][j] == 'O' && vis[i][j] == 0) {
                        dfs(i, j, vis, board, delrow, delcol);
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void dfs(int row, int col, int[][] vis, char[][] board, int[] delrow, int[] delcol) {
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m
              && board[nrow][ncol] == 'O' && vis[nrow][ncol] == 0) {
                  dfs(nrow, ncol, vis, board, delrow, delcol);
              } 
        }
    }

}
