package Graphs.Topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {

	public static void main(String[] args) {
		int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        findOrder(dict, N, K);
	}
	
    public static void findOrder(String [] dict, int n, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<k; i++) adj.add(new ArrayList<>());
        for(int i=0; i<n-1; i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int ptr=0; ptr<len; ptr++) {
                if(s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        
        List<Integer> topo = topo(k, adj);
        
        String ans = "";
        for(Integer it : topo) {
            ans = ans + (char) (it + (int)('a'));
        }
        
        System.out.println(ans);
        
    }
	
	public static List<Integer> topo(int v, List<List<Integer>> adj) {
		int[] indegree = new int[v];
		
		for(int i=0; i<v; i++) {
			for(Integer it : adj.get(i)) {
				indegree[it]++;
			}
		}
		
		List<Integer> topo = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<v; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			
			topo.add(node);
			
			for(Integer it : adj.get(node)) {
				indegree[it]--;
				if(indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		
		return topo;
	}

}
