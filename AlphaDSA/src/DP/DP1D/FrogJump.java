package DP.DP1D;

import java.util.Arrays;

public class FrogJump {

	public static void main(String[] args) {
		//Recursion
		int[] height = {10, 20, 30, 10};
		int n = 4;
		System.out.println(rec(n-1, height));
		
		//Memoization
		int[] dp= new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println(memo(n-1, height, dp));
		
		//Tabulation
		System.out.println(tabu(n, height));
		
		//Space Opitmization
		System.out.println(space_op(n, height));
		
	}
	
	public static int rec(int n, int[] height) {
		if(n == 0) return 0;
		int left = rec(n-1, height) + Math.abs(height[n] - height[n-1]);
		int right = Integer.MAX_VALUE;
		if(n > 1) {
			right = rec(n-2, height) + Math.abs(height[n] - height[n-2]);
		}
		return Math.min(left, right);
	}
	
	public static int memo(int n, int[] height, int[] dp) {
		if(n == 0) return 0;
		if(dp[n] != -1) return dp[n];
		
		int left = memo(n-1, height, dp) + Math.abs(height[n] - height[n-1]);
		int right = Integer.MAX_VALUE;
		if(n > 1) {
			right = memo(n-2, height, dp) + Math.abs(height[n] - height[n-2]);
		}
		return dp[n] = Math.min(left, right);
	}
	
    public static int tabu(int n, int heights[]) {
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1; i<n; i++) {
            int fs = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1) {
                ss = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            }
            
            dp[i] = Math.min(fs, ss);
        }
        
        return dp[n-1];
    }
    
    public static int space_op(int n, int heights[]) {
        int prev = 0;
        int prev2 = 0;
        for(int i=1; i<n; i++) {
            int fs = prev + Math.abs(heights[i] - heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1) {
                ss = prev2 + Math.abs(heights[i] - heights[i-2]);
            }
            int curi = Math.min(fs, ss);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }

}
