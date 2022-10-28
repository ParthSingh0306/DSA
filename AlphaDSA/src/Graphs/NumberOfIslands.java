package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//https://leetcode.com/problems/number-of-islands/description/
//https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1
public class NumberOfIslands {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] grid = new char[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				grid[i][j] = sc.next().charAt(0);
			}
		}
		System.out.println(numIslands(grid));
	}
	
    static class Pair{
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    // Function to find the number of islands.
    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        for(int row=0; row<n; row++){
           for(int col=0; col<m; col++){
               if(vis[row][col] == 0 && grid[row][col] == '1') {
                   cnt++;
                   bfs2(row, col, vis ,grid);
               }
           }
        }
        return cnt;
    }
    
//    bfs for 8 cells/directions
    public static void bfs(int ro, int co, int[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro, co));
        
        while(!q.isEmpty()) {
           int row = q.peek().first;
           int col = q.peek().second;
           q.remove();
           
           for(int delrow=-1; delrow<=1; delrow++) {
               for(int delcol=-1; delcol<=1; delcol++) {
                   int nrow = row + delrow;
                   int ncol = col + delcol;
                   
                   if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol] == '1' 
                      && vis[nrow][ncol] == 0 ) {
                          vis[nrow][ncol] = 1;
                          q.add(new Pair(nrow, ncol));
                      }
               }
           }
           
        }
    }
    
//    bfs for 4 cells/directions
    public static void bfs2(int ro, int co, int[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro, co));

        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            
            int[] delx = {-1, 0, 1, 0};
            int[] dely = {0, 1, 0, -1};

            for(int x=0; x<4; x++) {
                    int nrow = row + delx[x];
                    int ncol = col + dely[x];

                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == 0
                       && grid[nrow][ncol] == '1') {
                           vis[nrow][ncol] = 1;
                           q.add(new Pair(nrow, ncol));
                       }
            }

        }
    }

}
