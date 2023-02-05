package Graphs.ShortestPathAndProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

	public static void main(String[] args) {
		int[][] grid = {
				{0,0,0},
				{1,1,0},
				{1,1,0}
		};
		System.out.println(shortestPathBinaryMatrix(grid));
	}
	
    static class tuple{
        int f;
        int s;
        int t;
        tuple(int f, int s, int t) {
            this.f = f;
            this.s = s;
            this.t = t;
        }
    }
    
    static int[] delrow = {-1, -1, -1, 0, +1, +1, +1, 0};
    static int[] delcol = {-1, 0, +1, +1, +1, 0, -1, -1};
	
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n = grid.length;
        int m = grid[0].length;
        if(n-1 == 0 && m-1 == 0) return 1;

        int[][] dist = new int[n][m];
        for(int[] arr : dist) {
            Arrays.fill(arr, (int)1e9);
        }
        dist[0][0] = 0;
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(1, 0, 0));

        while(!q.isEmpty()) {
            tuple it = q.peek();
            int dis = it.f;
            int row = it.s;
            int col = it.t;
            q.remove();

            for(int i=0; i<8; i++) {
                int newr = row + delrow[i];
                int newc = col + delcol[i];

                if(newr>=0 && newc>=0 && newr<n && newc<m && grid[newr][newc] == 0 && 1 + dis < dist[newr][newc]) {
                    dist[newr][newc] = 1 + dis;
                    if(newr == n-1 && newc == m-1) return 1 + dis;
                    q.add(new tuple(1 + dis, newr, newc));
                }
            }
        }
        return -1;
    }

}
