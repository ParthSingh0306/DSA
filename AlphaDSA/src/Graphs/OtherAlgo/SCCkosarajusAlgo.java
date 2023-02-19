package Graphs.OtherAlgo;

import java.util.ArrayList;
import java.util.Stack;

public class SCCkosarajusAlgo {

	public static void main(String[] args) {
		int V = 3;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0; i<V; i++) adj.add(new ArrayList<>());
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(0);
		System.out.println(adj);
		System.out.println(kosaraju(V, adj));
	}
	
    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> st = new Stack<Integer>();
        int[] vis = new int[V];
        for(int i=0; i<V; i++) {
            if(vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0; i<V; i++) adjT.add(new ArrayList<>());
        
        for(int i=0; i<V; i++) {
            vis[i] = 0;
            for(Integer it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }
        
        int scc = 0;
        
        while(!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if(vis[node] == 0) {
                scc++;
                dfs2(node, vis, adjT);
            }
        }
        return scc;
    }
    
    public static void dfs(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for(Integer it : adj.get(node)) {
            if(vis[it] == 0) {
                dfs(it, vis, st, adj);
            }
        }
        st.push(node);
    }
    
    public static void dfs2(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1;
        for(Integer it : adjT.get(node)) {
            if(vis[it] == 0) {
                dfs2(it, vis, adjT);
            }
        }
    }

}
