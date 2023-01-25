package DP.SubsequenceDP;

public class PartitionASetIntoTwoSubsetsWithMinimumAbsoluteSumDifference {

	public static void main(String[] args) {
		int[] nums = {8, 6, 5};
	    System.out.println(solve(nums));
	}
	
    public static int solve(int[] A) {
        int n = A.length;
        int totsum = 0;
        for(int i=0; i<n; i++) totsum += A[i];
        int k = totsum;
        
        boolean[] prev = new boolean[k+1];
        prev[0] = true;
        if(A[0] <= k) prev[A[0]] = true;
        
        for(int ind=1; ind<n; ind++) {
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int target=1; target<=k; target++) {
                boolean notpick = prev[target];
                boolean pick = false;
                if(A[ind] <= target) pick = prev[target - A[ind]];
                
                curr[target] = pick | notpick;
            }
            prev = curr;
        }
        
        int min = (int) Math.pow(10, 9);
        for(int i=0; i<=totsum; i++) {
            if(prev[i] == true) {
                int diff = Math.abs(i - (totsum - i));
                min = Math.min(min, diff);
            }
        }
        return min; 
    }	

}
