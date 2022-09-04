package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ReverseFirstKelementInQueue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			q.add(sc.nextInt());
		}
		int k = sc.nextInt();
		
//		ReverseFirstKelement(q, k);
	    System.out.println(ReverseFirstKelement(q, k));
	    sc.close();
	}

	private static Queue<Integer> ReverseFirstKelement(Queue<Integer> q, int k) {
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<k; i++) {
			int num = q.peek();
			q.remove();
			st.push(num);
		}
		
		while(!st.isEmpty()) {
		   int element = st.peek();
		   st.pop();
		   q.add(element);
		}
		
		int t = q.size() - k;
		
		while(t>0) {
			int num = q.peek();
			q.remove();
			q.add(num);
			t--;
		}
		
		return q;
	}
	
}
