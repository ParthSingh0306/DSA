package Graphs.Topo;

import java.util.ArrayList;
import java.util.Stack;

public class TopoSort {

	public static void main(String[] args) {
		int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);
        
        topo(V, adj);
	}
	
	public static void topo(int V, ArrayList<ArrayList<Integer>> adj) {
		int[] vis = new int[V];
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<V; i++) {
			if(vis[i] == 0) {
				dfs(i, vis, adj, st);
			}
		}
		
		int[] ans = new int[V];
		int i = 0;
		while(!st.isEmpty()) {
			ans[i++] = st.peek();
			st.pop();
		}
		
		for(i=0; i<V; i++) {
			System.out.print(ans[i] + " ");
		}
	}
	
	public static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
		vis[node] = 1;
		for(Integer it : adj.get(node)) {
			if(vis[it] == 0) {
				dfs(it, vis, adj, st);
			}
		}
		st.push(node);
	}

}
