package DP.SubsequenceDP;

import java.util.Arrays;

public class Knapsack01 {

	public static void main(String[] args) {
		int n = 4;
		int[] wt = {1, 2, 4, 5};
		int[] val = {5, 4, 8, 6};
		int maxW = 5;
		
		int[][] dp = new int[n][maxW + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
		
		
		System.out.println(rec(n-1, wt, val, maxW));
		System.out.println(memo(n-1, wt, val, maxW, dp));
		System.out.println(tabu(n, wt, val, maxW));
		System.out.println(space_op(n, wt, val, maxW));
		System.out.println(space_op_intoSingleArray(n, wt, val, maxW));
	}
	
	//Recursion
	public static int rec(int n, int[] wt, int[] val, int maxW) {
		if(n == 0) {
			if(wt[n] <= maxW) return val[0];
			return 0;
		}
		
		int notpick = rec(n-1, wt, val, maxW);
		int pick = Integer.MIN_VALUE;
		if(wt[n] <= maxW) pick = val[n] + rec(n-1, wt, val, maxW - wt[n]);
		
		return Math.max(notpick, pick);
	}

	//Memo
    public static int memo(int n, int[] weight, int[] value, int maxW, int[][] dp) {
        if(n == 0) {
            if(weight[n] <= maxW) return value[n];
            return 0;
        }
        if(dp[n][maxW] != -1) return dp[n][maxW];
        int notpick = memo(n-1, weight, value, maxW, dp);
        int pick = Integer.MIN_VALUE;
        if(weight[n] <= maxW) pick = value[n] + memo(n-1, weight, value, maxW - weight[n], dp);
        
        return dp[n][maxW] = Math.max(pick, notpick);
    }
    
    //Tabu
    public static int tabu(int n, int[] wt, int[] val, int maxW) {
        int[][] dp = new int[n][maxW + 1];
        for(int w=wt[0]; w<=maxW; w++) {
                dp[0][w] = val[0];
        }
        
        for(int ind=1; ind<n; ind++) {
            for(int w = 0; w<=maxW; w++) {
                int notpick = dp[ind-1][w];
                int pick = Integer.MIN_VALUE;
                if(wt[ind] <= w) pick = val[ind] + dp[ind-1][w - wt[ind]];
                dp[ind][w] = Math.max(pick, notpick);
            }
        }
        return dp[n-1][maxW];
    }
    
    //space_op
    public static int space_op(int n, int[] wt, int[] val, int maxW) {
        int[] prev = new int[maxW + 1];
        for(int w=wt[0]; w<=maxW; w++) {
                prev[w] = val[0];
        }
        
        for(int ind=1; ind<n; ind++) {
            int[] curr = new int[maxW+1];
            for(int w = 0; w<=maxW; w++) {
                int notpick = prev[w];
                int pick = Integer.MIN_VALUE;
                if(wt[ind] <= w) pick = val[ind] + prev[w - wt[ind]];
                curr[w] = Math.max(pick, notpick);
            }
            prev = curr;
        }
        return prev[maxW];
    }
    
    //space op in single array
    public static int space_op_intoSingleArray(int n, int[] wt, int[] val, int maxW) {
        int[] prev = new int[maxW + 1];
        for(int w=wt[0]; w<=maxW; w++) {
                prev[w] = val[0];
        }
        
        for(int ind=1; ind<n; ind++) {
            for(int w = maxW; w>=0; w--) {
                int notpick = prev[w];
                int pick = Integer.MIN_VALUE;
                if(wt[ind] <= w) pick = val[ind] + prev[w - wt[ind]];
                prev[w] = Math.max(pick, notpick);
            }
        }
        return prev[maxW];
    }   

}
