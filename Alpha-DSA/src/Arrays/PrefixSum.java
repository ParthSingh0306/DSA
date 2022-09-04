package Arrays;

import java.util.Scanner;

public class PrefixSum {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		   int n = sc.nextInt();
		   int[] ans = new int[n];
		   for(int i=0; i<n; i++) {
			   ans[i] = sc.nextInt();
		   }
		   prefixSum(ans);
	}
	
	public static void prefixSum(int[] arr) {
		int n= arr.length;
		int maxSum = Integer.MIN_VALUE;
		
		int[] prefix = new int[n];
		prefix[0] = arr[0];
		for(int i=1; i< n; i++) {
			prefix[i] = prefix[i-1] + arr[i];
		}
		
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				int currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
				maxSum = Math.max(maxSum, currSum);
			}
		}
		System.out.println("MaxSum: " + maxSum);
	}
	
//	prefix sum = prefix[end] - prefix[start-1]
//	TC = O(N^2)
//	SC = O(N^2)

}
