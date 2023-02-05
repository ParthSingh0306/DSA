package Graphs.Topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule1 {

	public static void main(String[] args) {
		int n = 4;
        int m = 3;
        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prerequisites.add(i, new ArrayList<>());
        }


        prerequisites.get(0).add(0);
        prerequisites.get(0).add(1);

        prerequisites.get(1).add(1);
        prerequisites.get(1).add(2);

        prerequisites.get(2).add(2);
        prerequisites.get(2).add(3);
        
        check(n, m, prerequisites);
	}
	
	
	public static void check(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0; i<n; i++) adj.add(new ArrayList<>());
		for(int i=0; i<m; i++) adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
		
		int[] indegree = new int[n];
		for(int i=0; i<n; i++) {
			for(Integer it : adj.get(i)) {
				indegree[it]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			cnt++;
			for(Integer it : adj.get(node)) {
				indegree[it]--;
				if(indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		
		if(cnt == n) System.out.println("Posiible");
		else System.out.println("Not Possible");
	}

}
