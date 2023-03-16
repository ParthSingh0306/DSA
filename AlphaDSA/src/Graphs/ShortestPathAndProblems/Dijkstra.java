package Graphs.ShortestPathAndProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    static class Pair{
        int dist;
        int node;
        
        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }
    
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.dist - y.dist);
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        
        dist[S] = 0;
        pq.add(new Pair(0, S));
        
        while(!pq.isEmpty()) {
            int dis = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();
            
            for(int i=0; i<adj.get(node).size(); i++) {
                int adjW = adj.get(node).get(i).get(1);
                int edgeN = adj.get(node).get(i).get(0);
                
                if(dis + adjW < dist[edgeN]) {
                    dist[edgeN] = dis + adjW;
                    pq.add(new Pair(dist[edgeN], edgeN));
                }
            }
        }
        
        return dist;
    }
    
    public static void main(String[] args) {
    	int V = 3, E=3,S=2;
    	ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1);add(1);}};
    	ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
    	ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
    	ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
    	ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
    	ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};
    	
    	ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
    		{
    			add(node1);
    			add(node2);
    		}  
    	};
    	ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
    		{
    			add(node3);
    			add(node4);
    		}  
    	};
    	ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
    		{
    			add(node5);
    			add(node6);
    		}  
    	};
    	ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
    		{
    			add(inter1); // for 1st node
    			add(inter2); // for 2nd node
    					add(inter3); // for 3rd node
    		}
    	};
    							
    	System.out.println("Distance Array : " + Arrays.toString(dijkstra(V, adj, S)));
    }
}
