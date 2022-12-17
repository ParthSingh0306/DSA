package DP;

import java.util.Arrays;

public class CoinChange2 {

	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 5;
		
		int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        System.out.println(rec(n-1, amount, coins));
        System.out.println(memo(n-1, amount, coins, dp));
        System.out.println(tabu(n, amount, coins));
        System.out.println(space_op(n, amount, coins));
	}
	
	//rec
    public static int rec(int n, int amount, int[] coins) {
        if(n == 0) {
            if(amount % coins[0] == 0) return 1;
            else return 0;
        }
        
        int notpick = rec(n-1, amount, coins);
        int pick = 0;
        if(coins[n] <= amount) pick = rec(n, amount - coins[n], coins);

        return pick + notpick;
    }
    
    //memo
    public static int memo(int n, int amount, int[] coins, int[][] dp) {
        if(n == 0) {
            if(amount % coins[0] == 0) return 1;
            else return 0;
        }
        if(dp[n][amount] != -1) return dp[n][amount];
        int notpick = memo(n-1, amount, coins, dp);
        int pick = 0;
        if(coins[n] <= amount) pick = memo(n, amount - coins[n], coins, dp);

        return dp[n][amount] = pick + notpick;
    }
    
    //tabu
    public static int tabu(int n, int amount, int[] coins) {
        int[][] dp = new int[n][amount+1];

        for(int t=0; t<=amount; t++) {
            if(t % coins[0] == 0) dp[0][t] = 1;
            else dp[0][t] = 0;
        }

        for(int ind=1; ind<n; ind++) {
            for(int target=0; target<=amount; target++) {
                int notpick = dp[ind-1][target];
                int pick = 0;
                if(coins[ind] <= target) pick = dp[ind][target - coins[ind]];

                dp[ind][target] = notpick + pick;
            }
        }

        return dp[n-1][amount];
    }
    
    //space_op
    public static int space_op(int n, int amount, int[] coins) {
        int[] prev = new int[amount+1];

        for(int t=0; t<=amount; t++) {
            if(t % coins[0] == 0) prev[t] = 1;
            else prev[t] = 0;
        }

        for(int ind=1; ind<n; ind++) {
            int[] curr = new int[amount+1];
            for(int target=0; target<=amount; target++) {
                int notpick = prev[target];
                int pick = 0;
                if(coins[ind] <= target) pick = curr[target - coins[ind]];

                curr[target] = notpick + pick;
            }
            prev = curr;
        }

        return prev[amount];
    }

}
