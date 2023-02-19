package Graphs.DSU;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxRemoveStones {
	
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
    public static int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for(int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Map<Integer, Integer> stoneNodes = new HashMap<>();
        for(int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxRow + 1;
            ds.unionBySize(row, col);
            stoneNodes.put(row, 1);
            stoneNodes.put(col, 1);
        }

        int cnt = 0;
        for(Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
            if(ds.findUPar(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }

        return n - cnt;
    }

	public static void main(String[] args) {
		int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		System.out.println(removeStones(stones));
	}
}
