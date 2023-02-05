package Graphs.BFSandDFS;

import java.util.ArrayList;

public class CycleDirectedGraphDFS {

	public static void main(String[] args) {
		int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        
        checkCycle(V, adj);
	}
	
	public static void checkCycle(int v, ArrayList<ArrayList<Integer>> adj) {
		int[] vis = new int[v];
		int[] pathVis = new int[v];
		boolean isCycle = false;
		
		for(int i=0; i<v; i++) {
			if(vis[i] == 0) {
				if(dfs(i, vis, pathVis, adj, v) == true) isCycle = true;
			}
		}
		System.out.println(isCycle);
	}
	
	public static boolean dfs(int node, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj, int v) {
		vis[node] = 1;
		pathVis[node] = 1;
		for(Integer it : adj.get(node)) {
			if(vis[it] == 0) {
				if(dfs(it, vis, pathVis, adj, v) == true)  return true;
			}
			else if(pathVis[it] == 1) {
				return true;
			}
		}
		pathVis[node] = 0;
		return false;
	}

}
