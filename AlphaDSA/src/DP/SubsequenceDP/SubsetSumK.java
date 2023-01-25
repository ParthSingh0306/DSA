package DP.SubsequenceDP;

import java.util.Arrays;

public class SubsetSumK {

	public static void main(String[] args) {
		int[] arr = {4, 3, 1, 2};
		int n = arr.length;
		int target = 5;
		
		//rec
		System.out.println(rec(n-1, target, arr));
		
		//memo
		int[][] dp = new int[n][target+1];
		for(int[] row : dp) Arrays.fill(row, -1);
		System.out.println(memo(n-1, target, arr, dp));
		
		//Tabu
		System.out.println(tabu(n, target, arr));
	}
	
	//Recursion T.C = O(2^N) S.C = O(N)
	public static boolean rec(int n, int target, int[] arr){
        if(target == 0) return true;
        if(n == 0) return (arr[0] == target);
        
        boolean notTake = rec(n-1, target, arr);
        boolean take = false;
        if(arr[n] <= target) take = rec(n-1, target - arr[n], arr);
        
        return notTake | take;
    }
	
	//Memo T.C = O(2^N) S.C = O(N)
	public static boolean memo(int ind, int target,int[] arr,int[][] dp){
	    if(target==0) return true;
	    if(ind == 0) return arr[0] == target;
	    
	    if(dp[ind][target]!=-1) return dp[ind][target]==0?false:true;
	        
	    boolean notTaken = memo(ind-1,target,arr,dp);
	    
	    boolean taken = false;
	    if(arr[ind]<=target)
	        taken = memo(ind-1,target-arr[ind],arr,dp);
	        dp[ind][target]=notTaken||taken?1:0;
	    return notTaken||taken;
	}
	
	//Tabu T.C = O(N * TARGET) S.C = (N * TARGET)
    public static boolean tabu(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n][k+1];
        for(int i=0; i<n; i++) dp[i][0] = true;
        if(arr[0] <= k) dp[0][arr[0]] = true;
        
        for(int ind=1; ind<n; ind++) {
            for(int target=1; target<=k; target++) {
                boolean notTake = dp[ind-1][target];
                boolean take = false;
                if(arr[ind] <= target) take = dp[ind-1][target-arr[ind]];
                
                dp[ind][target] = notTake | take;
            }
        }
        return dp[n-1][k];
    }
    
    //Space optimised T.C = O(N*TARGET) S.C = O(K)
    public static boolean space_op(int n, int k, int[] arr) {
        boolean[] prev = new boolean[k+1];
        prev[0] = true;
        if(arr[0] <= k) prev[arr[0]] = true;
        
        for(int ind=1; ind<n; ind++) {
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int target=1; target<=k; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if(arr[ind] <= target) take = prev[target-arr[ind]];
                
                curr[target] = take | notTake;
            }
            prev = curr;
        }
        
        return prev[k];
    }

}
