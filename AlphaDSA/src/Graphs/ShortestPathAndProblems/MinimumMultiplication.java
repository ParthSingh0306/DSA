package Graphs.ShortestPathAndProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplication {

	public static void main(String[] args) {
		int[] arr = {2, 5, 7};
		int start = 3;
		int end = 30;
		System.out.println(minimumMultiplications(arr, start, end));
	}
	
    static class Pair{
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    
    public static int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, start));
        int[] dist = new int[100000];
        Arrays.fill(dist, (int)1e9);
        
        int mod = 100000;
        while(!q.isEmpty()) {
            Pair it = q.peek();
            q.remove();
            int steps = it.first;
            int node = it.second;
            
            for(int i : arr) {
                int num = (i * node) % mod;
                if(steps + 1 < dist[num]) {
                    dist[num] = steps + 1;
                    if(num == end) return steps + 1;
                    q.add(new Pair(steps + 1, num));
                }
            }
        }
        return -1;
    }

}
