package Graphs.DSU;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgoMST {
	
    static class DisjointSet {
    	List<Integer> rank = new ArrayList<>();
    	List<Integer> parent = new ArrayList<>();
    	List<Integer> size = new ArrayList<>();
    	
    	public DisjointSet(int n) {
    		for(int i=0; i<=n; i++) {
    			rank.add(0);
    			parent.add(i);
    			size.add(1);
    		}
    	}
    	
    	public int findUPar(int node) {
    		if(node == parent.get(node)) {
    			return node;
    		}
    		int ulp = findUPar(parent.get(node));
    		parent.set(node, ulp);
    		return parent.get(node);
    	}
    	
    	public void unionByRank(int u, int v) {
    		int ulp_u = findUPar(u);
    		int ulp_v = findUPar(v);
    		if(ulp_u == ulp_v) return;
    		if(rank.get(ulp_u) < rank.get(ulp_v)) {
    			parent.set(ulp_u, ulp_v);
    		}
    		else if(rank.get(ulp_v) < rank.get(ulp_u)) {
    			parent.set(ulp_v, ulp_u);
    		}
    		else {
    			parent.set(ulp_v, ulp_u);
    			int rankU = rank.get(ulp_u);
    			rank.set(ulp_u, rankU + 1);
    		}
    	}
    	
    	public void unionBySize(int u, int v) {
    		int ulp_u = findUPar(u);
    		int ulp_v = findUPar(v);
    		if(ulp_u == ulp_v) return;
    		if(size.get(ulp_u) < size.get(ulp_v)) {
    			parent.set(ulp_u, ulp_v);
    			size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
    		}
    		else {
    			parent.set(ulp_v, ulp_u);
    			size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
    		}
    	}
    }
    
    static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int wt;
        
        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
        
        public int compareTo(Edge compareEdge) {
            return this.wt - compareEdge.wt;
        }
    }

	public static void main(String[] args) {
		int V = 3;
		int E = 3;
		int[][] edges = {
				{0, 1, 5},
				{1, 2, 3},
				{0, 2, 1}
		};
		System.out.println(spanningTree(V, E, edges));
	}
	
	public static int spanningTree(int V, int E, int edges[][]){
	     List<Edge> adj = new ArrayList<Edge>();
	     for(int[] edge : edges) {
	         int u = edge[0];
	         int v = edge[1];
	         int wt = edge[2];
	         
	         Edge temp = new Edge(u, v, wt);
	         adj.add(temp);
	     }
	     Collections.sort(adj);
	     int minWt = 0;
	     DisjointSet ds = new DisjointSet(V);
	     for(Edge edge : adj) {
	         int u = edge.u;
	         int v = edge.v;
	         int wt = edge.wt;
	         
	         if(ds.findUPar(u) != ds.findUPar(v)) {
	             minWt += wt;
	             ds.unionBySize(u, v);
	         }
	     }
	     return minWt;
	}

}
