package Graphs.ShortestPathAndProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUnitWeight {

	public static void main(String[] args) {
		int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        shortestPath(edge, n, m, 0);
	}
	
	public static void shortestPath(int[][] edges,int n,int m ,int src) {
		List<List<Integer>> adj = new ArrayList<>();
		
		for(int i=0; i<n; i++) adj.add(new ArrayList<>());
		for(int i=0; i<m; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}
		
		int[] dist = new int[n];
		Arrays.fill(dist, (int)1e9);
		
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		dist[src] = 0;
		
		while(!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			
			for(Integer it : adj.get(node)) {
				if(dist[node] + 1 < dist[it]) {
					dist[it] = dist[node] + 1;
					q.add(it);
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			if(dist[i] == 1e9) dist[i] = -1;
		}
		
		System.out.println(Arrays.toString(dist));
	}

}
