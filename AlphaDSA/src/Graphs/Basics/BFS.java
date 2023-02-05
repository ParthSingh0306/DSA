package Graphs.Basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
public class BFS {

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
		System.out.println(bfsOfGraph(V, adj));
	}
	
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<Integer>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            
            for(Integer it : adj.get(node)) {
                if(vis[it] == false){
                    vis[it]= true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }

}
