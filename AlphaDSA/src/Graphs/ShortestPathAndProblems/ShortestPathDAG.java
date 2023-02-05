package Graphs.ShortestPathAndProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathDAG {

	public static void main(String[] args) {
		int n = 6, m = 7;
	    int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
	    System.out.println(Arrays.toString(shortestPath(n, m, edge)));
	}
	
    static class Pair{
        int f;
        int s;
        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
    
    public static void dfs(int node, int[] vis, ArrayList<ArrayList<Pair>> adj, Stack<Integer> st) {
        vis[node] = 1;
        
        for(Pair it : adj.get(node)) {
            int v = it.f;
            if(vis[v] == 0) {
                dfs(v, vis, adj, st);
            }
        }
        
        st.push(node);
    }

	public static int[] shortestPath(int n,int m, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0; i<n; i++) {
		    ArrayList<Pair> temp = new ArrayList<>();
		    adj.add(temp);
		}
		
		for(int i=0; i<m; i++) {
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    adj.get(u).add(new Pair(v, wt));
		}
		
		Stack<Integer> st = new Stack<>();
		int[] vis = new int[n];
		for(int i=0; i<n; i++) {
		    if(vis[i] == 0) {
		        dfs(i, vis, adj, st);
		    }
		}
		
		int[] dist = new int[n];
		Arrays.fill(dist, (int)1e9);
		
		dist[0] = 0;
		
		while(!st.isEmpty()) {
		    int node = st.peek();
		    st.pop();
		    
		    for(Pair it : adj.get(node)) {
		        int v = it.f;
		        int wt = it.s;
		        
		        if(dist[node] + wt < dist[v]) {
		            dist[v] = dist[node] + wt;
		        }
		    }
		}
		
		for(int i=0; i<n; i++) {
		    if(dist[i] == 1e9) dist[i] = -1;
		}
		
		return dist;
	}

}
