package Graphs.Topo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeStates {

	public static void main(String[] args) {
		int V = 12;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(8).add(1);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(11).add(9);
        
        findStates(V, adj);
	}
	
	public static void findStates(int v, List<List<Integer>> adj) {
		List<List<Integer>> adjrev = new ArrayList<>();
        for(int i=0; i<v; i++) adjrev.add(new ArrayList<>());
        int[] indegree = new int[v];
        for(int i=0; i<v; i++) {
            for(Integer it : adj.get(i)) {
                adjrev.get(it).add(i);
                indegree[i]++;
            }
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<v; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            
            safeNodes.add(node);
            
            for(Integer it : adjrev.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        
        Collections.sort(safeNodes);
        System.out.println(safeNodes);
	}

}
