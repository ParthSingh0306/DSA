package DP.LIS;

import java.util.Arrays;

public class longestBitonicSequence {

	public static void main(String[] args) {
		int[] arr = {1, 2, 1, 3, 4};
		System.out.println(LongestBitonicSequence(arr, arr.length));
	}
	
    public static int LongestBitonicSequence(int[] arr, int n) {
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for(int i=0; i<n; i++) {
            for(int prev=0; prev<i; prev++) {
                if(arr[i] > arr[prev] && 1 + dp1[prev] > dp1[i]) {
                    dp1[i] = 1 + dp1[prev];
                }
            }
        }

        int max = 1;
        for(int i=n-1; i>=0; i--) {
            for(int prev=n-1; prev>i; prev--) {
                if(arr[i] > arr[prev] && 1 + dp2[prev] > dp2[i]) {
                    dp2[i] = 1 + dp2[prev];
                }
            }
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }
        return max;
    }

}
