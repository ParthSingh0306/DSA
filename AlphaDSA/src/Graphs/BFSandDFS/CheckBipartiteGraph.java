package Graphs.BFSandDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckBipartiteGraph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		int[][] graph = new int[n][m];
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				graph[i][j] = sc.nextInt();
		System.out.println(isBipartite(graph));
		sc.close();
	}
	
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0; i<n; i++) {
            if(color[i] == -1) {
                if(check(i, n, graph, color) == false) return false;
            }
        }
        return true;
    }
    //bfs-solution
    public static boolean check(int start, int n, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<Integer>();
        color[start] = 0;
        q.add(start);

        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for(int it : graph[node]) {
                if(color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                } else if(color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    //dfs-solution
    public boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>>adj) {
        color[node] = col;
        
        for(int it : adj.get(node)) {
            if(color[it] == -1) {
               if( dfs(it, 1-col, color, adj) == false) {
                   return false;
               }
            } else if(color[it] == col) {
                return false;
            }
        }
        return true;
    }

}
