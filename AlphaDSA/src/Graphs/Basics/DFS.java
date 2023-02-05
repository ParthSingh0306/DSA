package Graphs.Basics;

import java.util.ArrayList;

public class DFS {

	public static void main(String[] args) {
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<=5; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		//edge 0-->1
		adj.get(0).add(1);
		adj.get(1).add(0);
		
		//edge 1-->2
		adj.get(2).add(1);
		adj.get(1).add(2);
				
		//edge 2-->3
		adj.get(2).add(3);
		adj.get(3).add(2);
				
		//edge 1-->3
		adj.get(1).add(3);
		adj.get(3).add(1);
				
		//edge 4-->3
		adj.get(4).add(3);
		adj.get(3).add(4);
		System.out.println(dfsOfGraph(V, adj));
	}
	
	public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new  ArrayList<Integer>();
        boolean[] vis = new boolean[V];
        vis[0] = true;
        
        dfs(0, vis, list, adj);
        return list;
    }
	
	public static void dfs(int node, boolean[] vis, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> adj) {
		vis[node] = true;
		list.add(node);
		
		for(Integer it : adj.get(node)) {
			if(vis[it] == false) {
				dfs(it, vis, list, adj);
			}
		}
	}

}
