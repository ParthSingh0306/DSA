package DP.LIS;

import java.util.ArrayList;
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
		
		//tabu2
		System.out.println(tabu2(arr, n));
		
		//space_op
		System.out.println(space_op(arr, n));
		
		//Binary search
		System.out.println(lengthOfLIS(arr));
		
		//Print LIS
		printLIS(arr, n);
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
    
    public static int tabu2(int[] arr, int n) {
    	int[] dp = new int[n];
    	Arrays.fill(dp, 1);
    	int max = 1;
    	for(int i=0; i<n; i++) {
    		for(int prev=0; prev<i; prev++) {
    			if(arr[prev] < arr[i]) {
    				dp[i] = Math.max(dp[i], 1 + dp[prev]);
    			}
    		}
    		max = Math.max(max, dp[i]);
    	}
    	return max;
    }
    
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        int l = 1;
        list.add(nums[0]);
        for(int i=1; i<n; i++) {
            if(nums[i] > list.get(list.size()-1)) {
                list.add(nums[i]);
                l++;
            }
            else {
                int ind = getL(list, nums[i]);
                list.set(ind, nums[i]);
            }
        }
        return l;
        //or return list.size()
    }

    public static int getL(ArrayList<Integer> list, int target) {
        int start = 0;
        int end = list.size()-1;
        while(start < end) {
            int mid = start + (end-start) / 2;
            if(list.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    public static void printLIS(int[] arr, int n) {
    	int[] dp = new int[n];
    	Arrays.fill(dp, 1);
    	int[] hash = new int[n];
    	
    	for(int i=0; i<n; i++) {
    		hash[i] = i;
    		for(int prev=0; prev<i; prev++) {
    			if(arr[prev] < arr[i] && 1 + dp[prev] > dp[i]) {
    				dp[i] = 1 + dp[prev];
    				hash[i] = prev;
    			}
    		}
    	}
    	
    	int ans = -1;
    	int lastIndex = -1;
    	
    	for(int i=0; i<n; i++) {
    		if(dp[i] > ans) {
    			ans = dp[i];
    			lastIndex = i;
    		}
    	}
    	
    	ArrayList<Integer> temp = new ArrayList<>();
    	temp.add(arr[lastIndex]);
    	
    	while(hash[lastIndex] != lastIndex) {
    		lastIndex = hash[lastIndex];
    		temp.add(arr[lastIndex]);
    	}
    	
    	System.out.print("LIS IS : ");
    	for(int i=temp.size()-1; i>=0; i--) {
    		System.out.print(temp.get(i) + " ");
    	}
    	System.out.println();
    	System.out.println(ans);
    }

}
