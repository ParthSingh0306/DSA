package DP;

public class CountPartitions {

	public static void main(String[] args) {
		int n = 5;
		int[] arr = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(countPartitions(n, target, arr));
	}
	
    public static int countPartitions(int n, int d, int[] arr) {
        int totsum = 0;
        for(int i=0; i<n; i++) totsum += arr[i];
        
        if(totsum - d < 0 || (totsum - d) % 2 == 1) return 0;
        int target = (totsum - d) / 2;
        return space_op(target, arr);
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
                    curr[sum] = (pick + notpick);
                }
                prev = curr;
            }
            return prev[k];
    }	

}
