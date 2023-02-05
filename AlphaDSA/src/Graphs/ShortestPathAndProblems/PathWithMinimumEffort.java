package Graphs.ShortestPathAndProblems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

	public static void main(String[] args) {
		int[][] heights={{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
		System.out.println(minimumEffortPath(heights));
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
    
    static int[] delrow = {-1, 0, +1, 0};
    static int[] delcol = {0, +1, 0, -1};
    
    public static  int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        int[][] dist = new int[n][m];
        for(int[] arr : dist) Arrays.fill(arr, (int)1e9);
        
        PriorityQueue<tuple> pq = new PriorityQueue<tuple>((x, y) -> x.f - y.f);
        
        dist[0][0] = 0;
        pq.add(new tuple(0, 0, 0));
        
        while(!pq.isEmpty()) {
            tuple it = pq.peek();
            int diff = it.f;
            int row = it.s;
            int col = it.t;
            pq.remove();
            
            if(row == n-1 && col == m-1) return diff;
            
            for(int i=0; i<4; i++) {
                int newr = row + delrow[i];
                int newc = col + delcol[i];
                
                if(newr>=0 && newc>=0 && newr<n && newc<m) {
                    int newEffort = Math.max(diff, Math.abs(heights[row][col] - heights[newr][newc]));
                    if(newEffort < dist[newr][newc]) {
                        dist[newr][newc] = newEffort;
                        pq.add(new tuple(newEffort, newr, newc));
                    }
                }
            }
        }
        return 0;
    }

}
