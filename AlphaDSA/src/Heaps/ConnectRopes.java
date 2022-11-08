package Heaps;

import java.util.PriorityQueue;

public class ConnectRopes {

	public static void main(String[] args) {
		int[] ropes = {2, 3, 3, 4, 6};
		int n = ropes.length;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0; i<n; i++) {
			pq.add(ropes[i]);
		}
		
		int cost = 0;
		
		while(pq.size() > 1) {
			int min1 = pq.remove();
			int min2 = pq.remove();
			cost += min1 + min2;
			pq.add(min1+min2);
		}
		
		System.out.println(cost);
	}

}
