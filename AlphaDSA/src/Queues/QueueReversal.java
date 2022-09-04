package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class QueueReversal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			q.add(sc.nextInt());
		}
		
		System.out.println(q);
//		queueReversal(q);
		System.out.println(queueReversal(q));
		sc.close();
	}

	private static Queue<Integer> queueReversal(Queue<Integer> q) {
		Stack<Integer> st = new Stack<>();
		
		while(!q.isEmpty()) {
			int num = q.peek();
			st.push(num);
			q.remove();
		}
		
		while(!st.isEmpty()) {
			int element = st.peek();
			st.pop();
			q.add(element);
		}
		return q;
	}

}
