package Graphs.OtherAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgesTarjansAlgo {

	public static void main(String[] args) {
		int n = 4;
		int[][] connections = {
           {0,1},{1,2},{2,0},{1,3}
		};
		System.out.println(criticalConnections(n, connections));
	}
	
    static int timer = 1;
    public static List<List<Integer>> criticalConnections(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] vis = new int[n];
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] conn : connections) {
            adj.get(conn[0]).add(conn[1]);
            adj.get(conn[1]).add(conn[0]);
        }
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, vis, adj, tin, low, bridges);
        return bridges;
    }

    public static void dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj, int[] tin, int[] low, 
                    List<List<Integer>> bridges) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        for(Integer it : adj.get(node)) {
            if(parent == it) continue;
            if(vis[it] == 0)  {
                dfs(it, node, vis, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);

                if(low[it] > tin[node]) {
                    bridges.add(Arrays.asList(it, node));
                }
            }
            else {
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }

}
