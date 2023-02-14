package Graphs.DSU;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
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

	public static void main(String[] args) {
		DisjointSet ds1 = new DisjointSet(5);
		// Union BY Rank
		ds1.unionByRank(0, 1);
		ds1.unionByRank(2, 3);
		if(ds1.findUPar(1) == ds1.findUPar(3)) {
			System.out.println("same");
		}
		else System.out.println("not same");
		ds1.unionByRank(1, 3);
		if(ds1.findUPar(1) == ds1.findUPar(3)) {
			System.out.println("same");
		}
		else System.out.println("not same");
		
		//Union By Size
		DisjointSet ds2 = new DisjointSet(5);
		ds2.unionBySize(0, 1);
		ds2.unionBySize(2, 3);
		if(ds2.findUPar(1) == ds2.findUPar(3)) {
			System.out.println("same");
		}
		else System.out.println("not same");
		ds2.unionBySize(1, 3);
		if(ds2.findUPar(1) == ds2.findUPar(3)) {
			System.out.println("same");
		}
		else System.out.println("not same");
	}

}
