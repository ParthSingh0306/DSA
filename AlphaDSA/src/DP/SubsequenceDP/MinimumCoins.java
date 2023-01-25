package DP.SubsequenceDP;

import java.util.Arrays;

public class MinimumCoins {

	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 11;
		int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        int ans = space_op(n, amount, coins);
        if(ans >= (int) Math.pow(10, 9)) {
        	System.out.println(-1);
        }
        System.out.println(ans);
	}
	
	//rec
    public static int rec(int n, int amount, int[] coins) {
        if(n == 0) {
            if(amount % coins[0] == 0) return amount / coins[0];
            else return (int) Math.pow(10, 9);
        }
        
        int notpick = rec(n-1, amount, coins);
        int pick = (int) Math.pow(10, 9);
        if(coins[n] <= amount) pick = 1 + rec(n, amount - coins[n], coins);

        return Math.min(pick, notpick);
    }
    
    //memo
    public static int memo(int n, int amount, int[] coins, int[][] dp) {
        if(n == 0) {
            if(amount % coins[0] == 0) return amount / coins[0];
            else return (int) Math.pow(10, 9);
        }
        if(dp[n][amount] != -1) return dp[n][amount];
        int notpick = memo(n-1, amount, coins, dp);
        int pick = (int) Math.pow(10, 9);
        if(coins[n] <= amount) pick = 1 + memo(n, amount - coins[n], coins, dp);

        return dp[n][amount] = Math.min(pick, notpick);
    }
    
    //tabu
    public static int tabu(int n, int amount, int[] coins) {
        int[][] dp = new int[n][amount+1];
        for(int i=0; i<=amount; i++) {
            if(i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = (int) Math.pow(10, 9);
        }


        for(int ind=1; ind<n; ind++) {
            for(int t=0; t<= amount; t++) {
                int notpick = dp[ind-1][t];
                int pick = (int) Math.pow(10, 9);
                if(coins[ind] <= t) pick = 1 + dp[ind][t-coins[ind]];

                dp[ind][t] = Math.min(notpick, pick);
            }
        }

        return dp[n-1][amount];
    }
    
    //space_op
    public static int space_op(int n, int amount, int[] coins) {
        int[] prev = new int[amount+1];
        for(int i=0; i<=amount; i++) {
            if(i % coins[0] == 0) prev[i] = i / coins[0];
            else prev[i] = (int) Math.pow(10, 9);
        }


        for(int ind=1; ind<n; ind++) {
            int[] curr = new int[amount+1];
            for(int t=0; t<= amount; t++) {
                int notpick = prev[t];
                int pick = (int) Math.pow(10, 9);
                if(coins[ind] <= t) pick = 1 + curr[t-coins[ind]];

                curr[t] = Math.min(notpick, pick);
            }
            prev = curr;
        }
        return prev[amount];
    }

}
