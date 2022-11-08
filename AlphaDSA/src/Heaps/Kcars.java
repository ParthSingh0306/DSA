package Heaps;

import java.util.PriorityQueue;

public class Kcars {
	
	static class Points implements Comparable<Points>{
		int x;
		int y;
		int distSqr;
		int idx;
		
		public Points(int x, int y, int distSqr, int idx) {
			this.x = x;
			this.y = y;
			this.distSqr = distSqr;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(Points p2) {
			return this.distSqr - p2.distSqr;
		}
	}

	public static void main(String[] args) {
		int[][] points = {{3, 3}, {5, 1}, {-2, 4}};
		int k = 2;
		
		PriorityQueue<Points> pq = new PriorityQueue<>();
		for(int i=0; i<points.length; i++) {
			int distSqr = points[i][0] * points[i][0] + points[i][1] * points[i][1];
			pq.add(new Points(points[i][0], points[i][1], distSqr, i));
		}
		
		for(int i=0; i<k; i++) {
			System.out.println("C" + pq.remove().idx);
		}
	}

}
