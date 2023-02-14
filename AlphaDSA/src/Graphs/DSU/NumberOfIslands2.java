package Graphs.DSU;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {

	public static void main(String[] args) {
		int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
            {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };
        System.out.println(numOfIslands(n, m, operators));
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
    
    public static  List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        List<Integer> ans = new ArrayList<>();
        int[][] vis = new int[rows][cols];
        DisjointSet ds = new DisjointSet(rows * cols);
        int n = operators.length;
        int cnt = 0;
        for(int i=0; i<n; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            if(vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }
            vis[row][col] = 1;
            cnt++;
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};
            for(int j=0; j<4; j++) {
                int nrow = row + dr[j];
                int ncol = col + dc[j];
                if(nrow>=0 && ncol>=0 && nrow<rows && ncol<cols) {
                    if(vis[nrow][ncol] == 1) {
                        int node = (row * cols) + col;
                        int adjNode = (nrow * cols) + ncol;
                        if(ds.findUPar(node) != ds.findUPar(adjNode)) {
                            cnt--;
                            ds.unionBySize(node, adjNode);
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }

}
