package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges {
//https://leetcode.com/problems/rotting-oranges/description/
//https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1
	
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
		System.out.println(orangesRotting(grid));
		scn.close();
	}
	
    static class Pair{
        int r;
        int c;
        int t;
        Pair(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    //Function to find minimum time required to rot all oranges. 
    public static int orangesRotting(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new LinkedList<Pair>();
        
        int[][] vis = new int[n][m];
        int cntFresh = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                
                if(grid[i][j] == 1) cntFresh++;
            }
        }
        
        int tm = 0;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        int cnt = 0;
        
        while(!q.isEmpty()) {
            int t = q.peek().t;
            int row = q.peek().r;
            int col = q.peek().c;
            q.remove();
            tm = Math.max(tm, t);
            
            for(int i=0; i<4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m 
                   && grid[nrow][ncol] == 1 && vis[nrow][ncol] != 2) {
                    q.add(new Pair(nrow, ncol, t+1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        
        if(cnt != cntFresh) return -1;
        return tm;
    }	

}
