package Graphs.ShortestPathAndProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightKstops {

	public static void main(String[] args) {
		int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        
        System.out.println(CheapestFLight(n, flights, src, dst, K));
	}
	
    static class Pair{
        int first;
        int second;
        int third;
        
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        
        Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    
    public static int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        int m = flights.length;
        for(int i=0; i<m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        Queue<Pair> q = new LinkedList<>();
        dist[src] = 0;
        q.add(new Pair(0, src, 0));
        
        while(!q.isEmpty()) {
            Pair it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second;
            int dis = it.third;
            
            if(stops > k) continue;
            
            for(Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int adjW = iter.second;
                
                if(dis + adjW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = adjW + dis;
                    q.add(new Pair(stops + 1, adjNode, adjW + dis));
                }
            }
        }
        
        if(dist[dst] == 1e9) return -1;
        return dist[dst];
    }

}
