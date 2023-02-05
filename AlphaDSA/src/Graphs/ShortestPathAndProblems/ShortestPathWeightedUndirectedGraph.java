package Graphs.ShortestPathAndProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathWeightedUndirectedGraph {
	
	static class Pair{
		int first;
		int second;
		
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
	public static void main(String[] args) {
		int V = 5, E = 6;
        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};
        System.out.println(shortestPath(V, E, edges));
	}
	
	public static List<Integer> shortestPath(int n, int m, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
		
		for(int i=0; i<m; i++) {
			adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
			adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.first - y.first);
		int[] dist = new int[n+1];
		int[] parent = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			dist[i] = (int)1e9;
			parent[i] = i;
		}
		
		dist[1] = 0;
		pq.add(new Pair(0, 1));
		
		while(!pq.isEmpty()) {
			Pair it = pq.peek();
			int dis = it.first;
			int node = it.second;
			pq.remove();

			for(Pair adjpair : adj.get(node)) {
				int adjNode = adjpair.first;
				int adjW = adjpair.second;
				
				if(dis + adjW < dist[adjNode]) {
					dist[adjNode] = dis + adjW;
					pq.add(new Pair(dist[adjNode], adjNode));
					parent[adjNode] = node;
				}
			}
		}
		List<Integer> path = new ArrayList<>();
		if(dist[n] == 1e9) {
			path.add(-1);
			return path;
		}
		int node = n;
		while(parent[node] != node) {
			path.add(node);
			node = parent[node];
		}
		path.add(1);
		Collections.reverse(path);
		return path;
	}

}
