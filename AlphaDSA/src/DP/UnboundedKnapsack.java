package DP;

import java.util.Arrays;

public class UnboundedKnapsack {

	public static void main(String[] args) {
		int n = 3;
		int[] wt = {7, 2, 4};
		int[] val = {5, 10, 20};
		int W = 15;
		
		int[][] dp = new int[n][W + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
		
		
		System.out.println(rec(n-1, W, wt, val));
		System.out.println(memo(n-1, W, wt, val, dp));
		System.out.println(tabu(n, W, wt, val));
		System.out.println(space_op(n, W, wt, val));
		System.out.println(space_op_intoSingleArray(n, W, wt, val));
	}
	
    public static int rec(int n, int w, int[] wt, int[] val) {
        if(n == 0) {
            return (w/wt[0]) * val[0];
        }
        
        int notpick = rec(n-1, w, wt, val);
        int pick = Integer.MIN_VALUE;
        if(wt[n] <= w) pick = val[n] + rec(n, w-wt[n], wt, val);
        
        return Math.max(pick, notpick);
    }

    public static int memo(int n, int w, int[] wt, int[] val, int[][] dp) {
        if(n == 0) {
            return (w/wt[0]) * val[0];
        }
        if(dp[n][w] != -1) return dp[n][w];
        int notpick = memo(n-1, w, wt, val, dp);
        int pick = Integer.MIN_VALUE;
        if(wt[n] <= w) pick = val[n] + memo(n, w-wt[n], wt, val, dp);
        
        return dp[n][w] = Math.max(pick, notpick);
    }
    
    public static int tabu(int n, int w, int[] wt, int[] val) {
        int[][] dp = new int[n][w+1];
        
        for(int i=0; i<=w; i++) {
            dp[0][i] = (i/wt[0]) * val[0];
        }
        
        for(int ind=1; ind<n; ind++) {
            for(int t=0; t<=w; t++) {
                int notpick = dp[ind-1][t];
                int pick = Integer.MIN_VALUE;
                if(wt[ind] <= t) pick = val[ind] + dp[ind][t-wt[ind]];
                
                dp[ind][t] = Math.max(pick, notpick);
            }
        }
        return dp[n-1][w];
    }
    
    public static int space_op(int n, int w, int[] wt, int[] val) {
        int[] prev = new int[w+1];
        
        for(int i=0; i<=w; i++) {
            prev[i] = (int) (i/wt[0]) * val[0];
        }
        
        for(int ind=1; ind<n; ind++) {
            int[] curr = new int[w+1];
            for(int t=0; t<=w; t++) {
                int notpick = prev[t];
                int pick = Integer.MIN_VALUE;
                if(wt[ind] <= t) pick = val[ind] + curr[t-wt[ind]];
                
                curr[t] = Math.max(pick, notpick);
            }
            prev = curr;
        }
        return prev[w];
    }
    
    public static int space_op_intoSingleArray(int n, int w, int[] wt, int[] val) {
        int[] prev = new int[w+1];
        
        for(int i=0; i<=w; i++) {
            prev[i] = (int) (i/wt[0]) * val[0];
        }
        
        for(int ind=1; ind<n; ind++) {
            for(int t=0; t<=w; t++) {
                int notpick = prev[t];
                int pick = Integer.MIN_VALUE;
                if(wt[ind] <= t) pick = val[ind] + prev[t-wt[ind]];
                
                prev[t] = Math.max(pick, notpick);
            }
        }
        return prev[w];
    }
}
