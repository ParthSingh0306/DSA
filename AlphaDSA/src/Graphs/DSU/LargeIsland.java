package Graphs.DSU;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LargeIsland {

	public static void main(String[] args) {
		int[][] grid = {
				{1, 1},
				{0, 1}
		};
		System.out.println(MaxConnection(grid));
	}
	
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
	
	private static boolean isValid(int row, int col, int n) {
	    return row >= 0 && row < n && col >= 0 && col < n;
	}
    
    public static int MaxConnection(int grid[][]) {
       int n = grid.length;
       DisjointSet ds = new DisjointSet(n*n);
       
       for(int row=0; row<n; row++) {
           for(int col=0; col<n; col++) {
               if(grid[row][col] == 0) continue;
               int[] dr = {-1, 0, +1, 0};
               int[] dc = {0, +1, 0, -1};
               for(int ind=0; ind<4; ind++) {
                   int nrow = row + dr[ind];
                   int ncol = col + dc[ind];
                   if(isValid(nrow, ncol, n) && grid[nrow][ncol] == 1) {
                       int NodeNo = row * n + col;
                       int adjNodeNo = nrow * n + ncol;
                       ds.unionBySize(NodeNo, adjNodeNo);
                   }
               }
           }
       }
       
       
       int max = 0;
       for(int row=0; row<n; row++) {
           for(int col=0; col<n; col++) {
               if(grid[row][col] == 1) continue;
               int[] dr = {-1, 0, +1, 0};
               int[] dc = {0, +1, 0, -1};
               Set<Integer> set = new HashSet<>();
               for(int ind=0; ind<4; ind++) {
                   int nrow = row + dr[ind];
                   int ncol = col + dc[ind];
                   if(isValid(nrow, ncol, n) && grid[nrow][ncol] == 1) {
                       int adjNodeNo = nrow * n + ncol;
                       set.add(ds.findUPar(adjNodeNo));
                   }
               }
               
               int sizeTotal = 0;
               for(Integer it : set) {
                   sizeTotal += ds.size.get(it);
               }
               max = Math.max(max, sizeTotal+1);
           }
       }
       
       for(int cell=0; cell<n*n; cell++) {
           max = Math.max(max, ds.size.get(ds.findUPar(cell)));
       }
       return max;
    }	

}
