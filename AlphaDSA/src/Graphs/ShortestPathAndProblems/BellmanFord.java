package Graphs.ShortestPathAndProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

	public static void main(String[] args) {
		int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };
        System.out.println(Arrays.toString(bellman_ford(V, edges, S)));
	}
	
    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int n = edges.size();
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[S] = 0;
        
        for(int i=0; i<V-1; i++) {
            for(ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                
                if(dist[u] != (int)1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        //Nth relaxation for detecting negative cycles
        for(ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            
            if(dist[u] != (int)1e8 && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }
        
        return dist;
    }

}
