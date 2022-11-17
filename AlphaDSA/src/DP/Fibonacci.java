package DP;

public class Fibonacci {

	public static void main(String[] args) {
		int n = 5;
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		System.out.println(fiboTabulation(n));
	}

	private static int fibo(int n, int[] dp) { //memoization
		if(n <= 1) {
			return n;
		}
		if(dp[n] != 0) {
			return dp[n];
		}
		return dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
	}
	
	private static int fiboTabulation(int n) { // tabulation
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2; i<n+1; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}

}
