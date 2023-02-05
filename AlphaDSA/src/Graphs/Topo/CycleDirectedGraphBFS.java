package Graphs.Topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDirectedGraphBFS {

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
        
        hasCycle(V, adj);
	}
	
	public static void hasCycle(int v, ArrayList<ArrayList<Integer>> adj) {
		int[] indegree = new int[v];
		
		for(int i=0; i<v; i++) {
			for(Integer it : adj.get(i)) {
				indegree[it]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<v; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			cnt++;
			for(Integer it : adj.get(node)) {
				indegree[it]--;
				if(indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		
		if(cnt == v) System.out.println(false);
		else System.out.println(true);
	}	

}
