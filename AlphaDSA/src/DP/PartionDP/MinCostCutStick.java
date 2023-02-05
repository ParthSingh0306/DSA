package DP.PartionDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinCostCutStick {

	public static void main(String[] args) {
		int n = 5, c = 3;
		int[] cuts = {1, 3, 4};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i : cuts) list.add(i);
        list.add(n);
        Collections.sort(list);
        int[][] dp = new int[c+1][c+1];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        System.out.println(f(1, c, list, dp));
	}
	
    private static int f(int i, int j, ArrayList<Integer> list, int[][] dp) {
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int ind=i; ind<=j; ind++) {
            int ans = list.get(j+1) - list.get(i-1) + f(i, ind-1, list, dp) + f(ind+1, j, list, dp);
            min = Math.min(min, ans);
        }
        return dp[i][j] = min;
    }

}
