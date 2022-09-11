package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class NoSubSequemceSumK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = sc.nextInt();
		System.out.println(subsetSumK(0, 0, sum, arr, n));
		sc.close();
	}

//	pattern for counting no of subsequneces with sum k
	private static int subsetSumK(int idx, int s, int sum, int[] arr, int n) {
		
		if(idx == n) {
			if(s == sum) {
				return 1;
			}
			return 0;
		}
		
		s += arr[idx];
		int left = subsetSumK(idx+1, s, sum, arr, n);
		
		s -= arr[idx];
		int right = subsetSumK(idx+1, s, sum, arr, n);
		
		return left + right;
		
	}
}
