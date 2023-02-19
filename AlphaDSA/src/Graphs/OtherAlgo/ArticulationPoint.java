package Graphs.OtherAlgo;

import java.util.ArrayList;

public class ArticulationPoint {

	public static void main(String[] args) {
		int n = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0; i<n; i++) adj.add(new ArrayList<>());
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(1).add(4);
		adj.get(4).add(1);
		adj.get(4).add(3);
		adj.get(3).add(4);
		System.out.println(articulationPoints(n, adj));
	}
	
    static int timer = 1;
    public static ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[n];
        int[] mark = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        
        for(int i=0; i<n; i++) {
            if(vis[i] == 0) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(mark[i] == 1) {
                ans.add(i);
            }
        }
        if(ans.size() == 0) {
            ans.add(-1);
            return ans;
        }
        return ans;
    }
    
    public static void dfs(int node, int parent, int[] vis, int[] tin, int[] low, int[] mark, 
                    ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        for(Integer it : adj.get(node)) {
            if(parent == it) continue;
            if(vis[it] == 0) {
                dfs(it, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);
                
                if(low[it] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }
                child++;
            }
            else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        
        if(child > 1 & parent == -1) {
            mark[node] = 1;
        }
    }

}
