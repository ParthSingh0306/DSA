package Arrays;

import java.util.Scanner;

public class Kadane {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		   int n = sc.nextInt();
		   int[] ans = new int[n];
		   for(int i=0; i<n; i++) {
			   ans[i] = sc.nextInt();
		   }
		   kadane(ans);
	}
	
	public static void kadane(int[] arr) {
		int n = arr.length;
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			currSum += arr[i];
			if(currSum < 0) {
				currSum = 0;
			}
			maxSum = Math.max(maxSum, currSum);
		}
		System.out.println("MaxSum: " + maxSum);
	}
// Kadane algo is not applicable for arr which contains all -ve numbers
//	TC = O(N)
//	SC = O(1)
}
