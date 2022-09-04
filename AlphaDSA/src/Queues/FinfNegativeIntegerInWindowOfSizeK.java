package Queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class FinfNegativeIntegerInWindowOfSizeK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int K = sc.nextInt();
		System.out.println(finfNegativeIntegerInWindowOfSizeK(arr, n, K));
		sc.close();
	}

	private static ArrayList<Integer> finfNegativeIntegerInWindowOfSizeK(int[] arr, int n, int k) {
		
		Deque<Integer> dq = new ArrayDeque<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<k; i++) {
			if(arr[i] < 0) {
				dq.push(i);
			}
		}
		
		if(dq.size() > 0) {
		    list.add(arr[dq.peek()]);
		}else {
			list.add(0);
		}
		
		for(int i=k; i<n; i++) {
			
			if(!dq.isEmpty() && (i - dq.peek()) >= k) {
				dq.pop();
			}
			
			if(arr[i] < 0) {
				dq.push(i);
			}
			
			if(dq.size() > 0) {
			    list.add(arr[dq.peek()]);
			}else {
				list.add(0);
			}
			
		}
		return list;
		
	}

}
