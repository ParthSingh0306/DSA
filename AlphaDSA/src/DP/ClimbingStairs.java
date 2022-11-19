package DP;

import java.util.Arrays;

public class ClimbingStairs {

	public static void main(String[] args) {
		int n = 15;
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println(climb(n));
		System.out.println(climbMemo(n, dp));
		System.out.println(tabu(n));
		System.out.println(space_op(n));
	}
	
	//T.C = O(2^N) S.C = O(2^N)
	private static int climb(int n) {
		if(n == 0 ) return 1;
		if(n < 0) {
			return 0;
		}
		
		return climb(n-1) + climb(n-2);
	}
	
	//T.C = O(N) S.C = O(2^N)
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
	
	//T.C = O(N) S.C = O(N)
	public static int tabu(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<n+1; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
	
	//T.C = O(N) S.C = O(1)
	public static int space_op(int n) {
		int prev2 = 0;
		int prev = 1;
		for(int i=0; i<n; i++) {
			int curr = prev + prev2;
			prev2 = prev;
			prev = curr;
		}
		return prev;
	}

}
