package Graphs.ShortestPathAndProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {

	public static void main(String[] args) {
		int[][] times = {
					{2,1,1},
					{2,3,1},
					{3,4,1}
				};
		int n = 4, k = 2;
		System.out.println(networkDelayTime(times, n, k));
	}
	
    static class Pair{
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    
    public static int networkDelayTime(int[][] times, int n, int k) {
        int m = times.length;
        ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<m; i++) {
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);

        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x, y) -> x.first - y.first);
        dist[k] = 0;
        q.add(new Pair(0, k));

        while(!q.isEmpty()) {
            Pair it = q.peek();
            q.remove();
            int dis = it.first;
            int node = it.second;

            for(Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int adjW = iter.second;

                if(dis + adjW < dist[adjNode]) {
                    dist[adjNode] = dis + adjW;
                    q.add(new Pair(dis + adjW, adjNode));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++) {
            max = Math.max(max, dist[i]);
        }
//        System.out.println(Arrays.toString(dist));
        if(max == (int)1e9) return -1;
        return max;
    }

}
