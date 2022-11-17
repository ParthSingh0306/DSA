package DP;

import java.util.Arrays;

public class ClimbingStairs {

	public static void main(String[] args) {
		int n = 3;
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println(climbMemo(n, dp));
	}
	
	private static int climb(int n) {
		if(n == 0 ) return 1;
		if(n < 0) {
			return 0;
		}
		
		return climb(n-1) + climb(n-2);
	}
	
	private static int climbMemo(int n, int[] dp) {
		if(n == 0 ) return 1;
		if(n < 0) {
			return 0;
		}
		if(dp[n] != -1) {
			return dp[n];
		}
		
		return dp[n] = climb(n-1) + climb(n-2);
	}

}
