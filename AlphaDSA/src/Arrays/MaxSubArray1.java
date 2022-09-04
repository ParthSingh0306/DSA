package Arrays;

import java.util.Scanner;

public class MaxSubArray1 {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		   int n = sc.nextInt();
		   int[] ans = new int[n];
		   for(int i=0; i<n; i++) {
			   ans[i] = sc.nextInt();
		   }
		   SubArraySum(ans);
	}
	
	public static void SubArraySum(int[] arr) {
		int n= arr.length;
		int maxSum = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				int currSum = 0;
				for(int k=i; k<=j; k++) {
					currSum += arr[k];
				}
				System.out.println("CurrSum: " + currSum );
				maxSum = Math.max(maxSum, currSum);
			}
			System.out.println();
		}
		System.out.println("MaxSum: " + maxSum);
	}

}
