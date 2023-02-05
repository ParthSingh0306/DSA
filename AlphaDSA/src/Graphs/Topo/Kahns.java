package Graphs.Topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Kahns {

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
	
	public static void topo(int v, ArrayList<ArrayList<Integer>> adj) {
		int[] indegree = new int[v];
		
		for(int i=0; i<v; i++) {
			for(Integer it : adj.get(i)) {
				indegree[it]++;
			}
		}
		
		int[] topo = new int[v];
		int k = 0;
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<v; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			
			topo[k++] = node;
			
			for(Integer it : adj.get(node)) {
				indegree[it]--;
				if(indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		
		for(int i=0; i<v; i++) {
			System.out.print(topo[i] + " ");
		}
	}

}
