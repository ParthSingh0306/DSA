package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
public class CycleInUndirectedGraphBFS {
	
	static class Pair{
        int node;
        int parent;
        
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

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
		
		//edge 4-->3
		adj.get(4).add(3);
		adj.get(3).add(4);
				
		//edge 4-->1
		adj.get(4).add(1);
		adj.get(1).add(4);
		
		System.out.println(isCycle(V, adj));
	}
	
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        for(int i=0; i<V; i++) {
            if(vis[i] == 0) {
                if(check(i, V, vis, adj)) return true;
            }
        }
        return false;
    }
    
    public static boolean check(int src, int V, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[src] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(src, -1));
        
        while(!q.isEmpty()) {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.remove();
            
            for(int adjacentNode : adj.get(node)) {
                if(vis[adjacentNode] == 0) {
                    vis[adjacentNode] = 1;
                    q.add(new Pair(adjacentNode, node));
                } else if(parent != adjacentNode) {
                    return true;
                }
            }
        }
        return false;
    }	

}
