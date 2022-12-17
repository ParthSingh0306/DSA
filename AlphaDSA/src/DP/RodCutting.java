package DP;

import java.util.Arrays;

public class RodCutting {

	public static void main(String[] args) {
		int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
		int n = price.length;
		
		int[][] dp = new int[n][n+1];
		for(int[] row : dp) Arrays.fill(row, -1);
		
		System.out.println(rec(n-1, n, price));
		System.out.println(memo(n-1, n, price, dp));
		System.out.println(tabu(n, n, price));
		System.out.println(space_op(n, n, price));
		System.out.println(space_opintoSingleArray(n, n, price));
	}
	
	//rec
    public static int rec(int ind, int n, int[] price) {
        if(ind == 0) {
            return n * price[0];
        }
        
        int notpick = rec(ind-1, n, price);
        int pick = Integer.MIN_VALUE;
        int rodlength = ind+1;
        if(rodlength <= n) pick = price[ind] + rec(ind, n - rodlength, price);
        
        return Math.max(pick, notpick);
    }
    
    //memo
    public static int memo(int ind, int n, int[] price, int[][] dp) {
        if(ind == 0) {
            return n * price[0];
        }
        if(dp[ind][n] != -1) return dp[ind][n];
        int notpick = memo(ind-1, n, price, dp);
        int pick = Integer.MIN_VALUE;
        int rodlength = ind+1;
        if(rodlength <= n) pick = price[ind] + memo(ind, n - rodlength, price, dp);
        
        return dp[ind][n] = Math.max(pick, notpick);
    }
    
    //tabu
    public static int tabu(int ind, int n, int[] price) {
        int[][] dp = new int[ind][n+1];
        
        for(int i=0; i<=n; i++) {
            dp[0][i] = i * price[0];
        }
        
        for(int index=1; index<n; index++) {
            for(int tar=0; tar<=n; tar++) {
                int notpick = dp[index-1][tar];
                int pick = Integer.MIN_VALUE;
                int rodlength = index + 1;
                if(rodlength <= tar) pick = price[index] + dp[index][tar - rodlength];
                
                dp[index][tar] = Math.max(pick, notpick);
            }
        }
        
        return dp[ind-1][n];
    }
    
    //space_op
    public static int space_op(int ind, int n, int[] price) {
        int[] prev = new int[n+1];
        
        for(int i=0; i<=n; i++) {
            prev[i] = i * price[0];
        }
        
        for(int index=1; index<n; index++) {
            int[] curr = new int[n+1];
            for(int tar=0; tar<=n; tar++) {
                int notpick = prev[tar];
                int pick = Integer.MIN_VALUE;
                int rodlength = index + 1;
                if(rodlength <= tar) pick = price[index] + curr[tar - rodlength];
                
                curr[tar] = Math.max(pick, notpick);
            }
            prev = curr;
        }
        
        return prev[n];
    }

    //space op into 1D Array
    public static int space_opintoSingleArray(int ind, int n, int[] price) {
        int[] prev = new int[n+1];
        
        for(int i=0; i<=n; i++) {
            prev[i] = i * price[0];
        }
        
        for(int index=1; index<n; index++) {
            for(int tar=0; tar<=n; tar++) {
                int notpick = prev[tar];
                int pick = Integer.MIN_VALUE;
                int rodlength = index + 1;
                if(rodlength <= tar) pick = price[index] + prev[tar - rodlength];
                
                prev[tar] = Math.max(pick, notpick);
            }
        }
        return prev[n];
    }

}
