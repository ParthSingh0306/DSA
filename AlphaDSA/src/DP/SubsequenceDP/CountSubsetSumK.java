package DP.SubsequenceDP;

import java.util.Arrays;

public class CountSubsetSumK {

	public static void main(String[] args) {
		int[] num = {1, 2, 2, 3};
		int n = num.length;
		int tar = 3;
		
        int[][] dp = new int[n][tar+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        System.out.println(rec(n-1, tar, num));; 	  //rec
        System.out.println(memo(n-1, tar, num, dp)); // memo
        System.out.println(tabu(tar, num)); // tabu
        System.out.println(space_op(tar, num)); // space_op
	}
	
	//Recursion
    public static int rec(int n, int k, int[] nums) {
        if(n==0){
            if(k==0 && nums[0]==0) return 2;
            if(k==0 || k==nums[0]) return 1;
            return 0;
        }
        
        int notpick = rec(n-1, k, nums);
        int pick = 0;
        if(nums[n] <= k) pick = rec(n-1, k-nums[n], nums);
        
        return notpick + pick;
    }
    
    //Memo
    public static int memo(int n, int k, int[] nums, int[][] dp) {
        if(n==0){
            if(k==0 && nums[0]==0) return 2;
            if(k==0 || k==nums[0]) return 1;
            return 0;
        }
        if(dp[n][k] != -1) return dp[n][k];
        int notpick = memo(n-1, k, nums, dp);
        int pick = 0;
        if(nums[n] <= k) pick = memo(n-1, k-nums[n], nums, dp);
        
        return dp[n][k] = notpick + pick;
    }
    
    public static int tabu(int k, int[] nums) {
    	int n = nums.length;
    	int[][] dp = new int[n][k+1];
    	if(nums[0] == 0) dp[0][0] = 2;
    	else dp[0][0] = 1;
    	
    	if(nums[0] != 0 && nums[0] <= k) dp[0][nums[0]] = 1;
    	
    	for(int ind=1; ind<n; ind++) {
    		for(int sum=0; sum<=k; sum++) {
    			int notpick = dp[ind-1][sum];
    			int pick = 0;
    			if(nums[ind] <= sum) pick = dp[ind-1][sum - nums[ind]];
    			dp[ind][sum] = pick + notpick;
    		}
    	}
    	
    	return dp[n-1][k];
    }
    
    public static int space_op(int k, int[] nums) {
    	int n = nums.length;
    	int[] prev = new int[k+1];
    	if(nums[0] == 0) prev[0] = 2;
    	else prev[0] = 1;
    	
    	if(nums[0] != 0 && nums[0] <= k) prev[nums[0]] = 1;
    	
    	for(int ind=1; ind<n; ind++) {
    		int[] curr = new int[k+1];
    		for(int sum=0; sum<=k; sum++) {
    			int notpick = prev[sum];
    			int pick = 0;
    			if(nums[ind] <= sum) pick = prev[sum - nums[ind]];
    			curr[sum] = pick + notpick;
    		}
    		prev = curr;
    	}
    	
    	return prev[k];
    }

}
