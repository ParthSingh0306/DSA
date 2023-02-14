package Graphs.DSU;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsMST {

	public static void main(String[] args) {
		int V = 5;
		int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
		int E = edges.length;
		System.out.println(spanningTree(V, E, edges));
	}
	
    static class Pair{
        int f;
        int s;
        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
    
	public static int spanningTree(int V, int E, int edges[][]){
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for(int i=0; i<V; i++) adj.add(new ArrayList<>());
	    for(int[] edge : edges) {
	        int u = edge[0];
	        int v = edge[1];
	        int wt = edge[2];
	        adj.get(u).add(new Pair(v, wt));
	        adj.get(v).add(new Pair(u, wt));
	    }
	    
	    int[] vis = new int[V];
	    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.f - y.f);
	    pq.add(new Pair(0, 0));
	    int sum = 0;
	    
	    while(!pq.isEmpty()) {
	        int wt = pq.peek().f;
	        int node = pq.peek().s;
	        pq.remove();
	        
	        if(vis[node] == 1) continue;
	        vis[node] = 1;
	        sum += wt;
	        
	        for(Pair it : adj.get(node)) {
	            int adjNode = it.f;
	            int adjWt = it.s;
	            
	            if(vis[adjNode] == 0) {
	                pq.add(new Pair(adjWt, adjNode));
	            }
	        }
	    }
	    return sum;
	}

}
