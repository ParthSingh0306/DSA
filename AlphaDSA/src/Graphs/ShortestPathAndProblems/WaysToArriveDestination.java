package Graphs.ShortestPathAndProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class WaysToArriveDestination {

	public static void main(String[] args) {
		int n = 7;
		int[][] roads = {
				{0,6,7},
				{0,1,2},
				{1,2,3},
				{1,3,3},
				{6,3,3},
				{3,5,1},
				{6,5,1},
				{2,5,1},
				{0,4,5},
				{4,6,2}};
		System.out.println(countPaths(n, roads));
	}

    static class Pair{
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int countPaths(int n, int[][] roads) {
        int m = roads.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<m; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.first - y.first);
        dist[0] = 0;
        ways[0] = 1;
        int mod = (int) (Math.pow(10, 9) + 7);
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()) {
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for(Pair it : adj.get(node)) {
                int adjNode = it.first;
                int adjW = it.second;

                if(dis + adjW < dist[adjNode]) {
                    dist[adjNode] = dis + adjW;
                    pq.add(new Pair(dis + adjW, adjNode));
                    ways[adjNode] = ways[node];
                }
                else if(dis + adjW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;;
                }
            }
        }
        // System.out.println(Arrays.toString(ways));
        return (ways[n-1] % mod);
    }
}
