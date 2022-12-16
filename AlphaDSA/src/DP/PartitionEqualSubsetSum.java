package DP;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		int[] nums = {1, 5, 11, 5};
	    int n = nums.length;
        int totsum = 0;
        for(int i=0; i<n; i++) {
            totsum += nums[i];
        }
        
        if(totsum % 2 == 1) System.out.println(false);
        else {
        	System.out.println(space_op(n, totsum/2, nums));
        }
	}
	
	//Memo T.C = O(2^N) S.C = O(N)
    public static boolean rec(int n, int target, int[] nums) {
        if(target == 0) return true;
        if(n == 0) return (nums[0] == target);
        
        boolean notpick = rec(n-1, target, nums);
        boolean pick = false;
        if(nums[n] <= target) pick = rec(n-1, target - nums[n], nums);
        
        return notpick | pick;
    }

    //Tabu T.C = O(N * TARGET) S.C = (N * TARGET)
    public static boolean tabu(int n, int k, int[] nums) {
        boolean[][] dp = new boolean[n][k+1];
        for(int i=0; i<n; i++) dp[i][0] = true;
        if(nums[0] <= k) dp[0][nums[0]] = true;

        for(int ind=1; ind<n; ind++) {
            for(int target=1; target<=k; target++) {
                boolean notpick = dp[ind-1][target];
                boolean pick = false;
                if(nums[ind] <= target) pick = dp[ind-1][target-nums[ind]];

                dp[ind][target] = pick | notpick;
            }
        }

        return dp[n-1][k];
    }

    //Space optimised T.C = O(N*TARGET) S.C = O(K)
    public static boolean space_op(int n, int k, int[] nums) {
        boolean[] prev = new boolean[k+1];
        prev[0] = true;
        if(nums[0] <= k) prev[nums[0]] = true;

        for(int ind=1; ind<n; ind++) {
            boolean[] curr = new boolean[k+1];
            for(int target=1; target<=k; target++) {
                boolean notpick = prev[target];
                boolean pick = false;
                if(nums[ind] <= target) pick = prev[target-nums[ind]];

                curr[target] = pick | notpick;
            }
            prev = curr;
        }

        return prev[k];
    }

}
