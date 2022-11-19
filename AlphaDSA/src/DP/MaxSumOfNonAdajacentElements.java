package DP;

import java.util.Arrays;

public class MaxSumOfNonAdajacentElements {

	public static void main(String[] args) {
		//rec
		int n = 3;
		int[] arr = {1, 2, 4};
		System.out.println(Maxrec(n-1, arr));
		
		//Memo
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println(SumMemo(n-1, arr, dp));
		
		//tabu
		System.out.println(SumTabu(n, arr));
		
		//space_op
		System.out.println(space_op(n, arr));
	}
	
	//T.C = O(2^N)
	public static int Maxrec(int idx, int[] arr) {
		if(idx == 0) return arr[idx];
		if(idx < 0) return 0;
		
		int pick = arr[idx] + Maxrec(idx-2, arr);
		int notpick = Maxrec(idx-1, arr);
		
		return Math.max(pick, notpick);
	}
	
	//memo
	public static int SumMemo(int idx, int[] arr, int[] dp) {
		if(idx == 0) return arr[idx];
		if(idx < 0) return 0;
		if(dp[idx] != -1) return dp[idx];
		
		int pick = arr[idx] + SumMemo(idx-2, arr, dp);
		int notpick = SumMemo(idx-1, arr, dp);
		
		return dp[idx] = Math.max(pick, notpick);
	}
	
	//tabu T.C = O(N) S.C = O(N)
	public static int SumTabu(int n, int[] arr) {
		int[] dp = new int[n];
		dp[0] = arr[0];
		
		for(int i=1; i<n; i++) {
			int fs = arr[i];
			if(i>1) fs += dp[i-2];
			int ss = dp[i-1];
			dp[i] = Math.max(fs, ss);
		}
		return dp[n-1];
	}
	
	public static int space_op(int n, int[] arr) {
		int prev2 = 0;
		int prev = arr[0];
		
		for(int i=1; i<n; i++) {
			int fs = arr[i];
			if(i>1) fs += prev2;
			int ss = prev;
			int curr = Math.max(fs, ss);
			prev2 = prev;
			prev = curr;
		}
		return prev;
	}

}
