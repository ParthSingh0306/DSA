package DP;

import java.util.Arrays;

public class LIS {

	public static void main(String[] args) {
		int n = 6;
		int[] arr = {5, 4, 11, 1, 16, 8};
		
		int[][] dp = new int[n][n+1];
        for(int[] a : dp) Arrays.fill(a, -1);
        
        //rec
		System.out.println(rec(0, -1, arr, n));
		
		//memo
		System.out.println(memo(0, -1, arr, n, dp));
		
		//tabu
		System.out.println(tabu(arr, n));
		
		//space_op
		System.out.println(space_op(arr, n));
	}
	
	
    public static int rec(int ind, int prevInd, int[] arr, int n) {
        if(ind == n) return 0;
        int len = rec(ind+1, prevInd, arr, n);
        if(prevInd == -1 || arr[ind] > arr[prevInd]) {
            len = Math.max(len, 1 + rec(ind+1, ind, arr, n));
        }
        return len;
    }
	
    public static int memo(int ind, int prevInd, int[] arr, int n, int[][] dp) {
        if(ind == n) return 0;
        if(dp[ind][prevInd+1] != -1) return dp[ind][prevInd+1];
        int len = memo(ind+1, prevInd, arr, n, dp);
        if(prevInd == -1 || arr[ind] > arr[prevInd]) {
            len = Math.max(len, 1 + memo(ind+1, ind, arr, n, dp));
        }
        return dp[ind][prevInd+1] = len;
    }
    
    public static int tabu(int[] arr, int n) {
        int[][] dp = new int[n+1][n+1];
        for(int ind=n-1; ind>=0; ind--) {
            for(int prevInd=ind-1; prevInd>=-1; prevInd--) {
                int len = dp[ind+1][prevInd+1];
                if(prevInd == -1 || arr[ind] > arr[prevInd]) {
                    len = Math.max(len, 1 + dp[ind+1][ind+1]);
                }
                dp[ind][prevInd+1] = len;
            }
       }
       return dp[0][0];  
    } 
    
    public static int space_op(int[] nums, int n) {
        int[] prev = new int[n+1];

        for(int ind=n-1; ind>=0; ind--) {
            int[] curr = new int[n+1];
            for(int prevInd=ind-1; prevInd>=-1; prevInd--) {
                int len = prev[prevInd+1];
                if(prevInd == -1 || nums[ind] > nums[prevInd]) {
                    len = Math.max(len, 1 + prev[ind+1]);
                }
                curr[prevInd+1] = len;
            }
            prev = curr;
        }
        return prev[0];
    }

}
