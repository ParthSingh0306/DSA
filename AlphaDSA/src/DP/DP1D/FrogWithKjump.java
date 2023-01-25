package DP.DP1D;

import java.util.Arrays;

public class FrogWithKjump {

	public static void main(String[] args) {
		//resursion
		int[] height = {10, 20, 30, 10};
		int n = 4;
		int k = 2;
		System.out.println(rec(n-1, k, height));
		
		//memo
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println(memo(n-1, k, height, dp));
		
		//tabu
		System.out.println(tabu(n, k, height));
	}
	
	public static int rec(int n, int k, int[] heights) {
		if(n == 0) return 0;
		int maxSteps = Integer.MAX_VALUE;
		for(int j=1; j<=k; j++) {
			if(n-j >= 0) {
				int jump = rec(n-j, k, heights) + Math.abs(heights[n] - heights[n-j]);
				maxSteps = Math.min(maxSteps, jump);
			}
		}
		return maxSteps;
	}
	
	//T.C = O(N*K) S.C = O(N) + O(N)
	public static int memo(int n, int k, int[] heights, int[] dp) {
		if(n == 0) return 0;
		if(dp[n] != -1) return dp[n];
		int maxSteps = Integer.MAX_VALUE;
		for(int j=1; j<=k; j++) {
			if(n-j >= 0) {
				int jump = rec(n-j, k, heights) + Math.abs(heights[n] - heights[n-j]);
				maxSteps = Math.min(maxSteps, jump);
			}
		}
		return dp[n] = maxSteps;
	}
	
	//T.C = O(N*K) S.C = O(N)
	public static int tabu(int n, int k, int[] heights) {
		int[] dp = new int[n];
		dp[0] = 0;
		
		for(int i=1; i<n; i++) {
			int maxSteps = Integer.MAX_VALUE;
			for(int j=1; j<=k; j++) {
				if(i-j >= 0) {
					int jump = dp[i-j] + Math.abs(heights[i] - heights[i-j]);
					maxSteps = Math.min(maxSteps, jump);
				}
			}
			dp[i] = maxSteps;
		}
		return dp[n-1];
	}

}
