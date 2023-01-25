package DP.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class largestDivisibleSubset {

	public static void main(String[] args) {
		int[] arr = {1, 4, 12, 6};
		System.out.println(largestDivisibleSubsets(arr));
	}

    public static List<Integer> largestDivisibleSubsets(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];

        for(int i=0; i<n; i++) {
            hash[i] = i;
            for(int prev=0; prev<i; prev++) {
                if(nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]) {
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

        List<Integer> temp = new ArrayList<>();
        temp.add(nums[lastIndex]);

        while(hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);
        }

        Collections.reverse(temp);
        return temp;
    }
}
