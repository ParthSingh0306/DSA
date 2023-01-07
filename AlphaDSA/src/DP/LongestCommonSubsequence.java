package DP;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s = "abbba";
		String t = "bba";
		int n = s.length();
		int m = t.length();
		
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row, -1);
		
		System.out.println(rec(n-1, m-1, s, t));
		System.out.println(memo(n-1, m-1, s, t, dp));
		System.out.println(tabu(n, m, s, t));
		System.out.println(space_op(n, m, s, t));
	}
	
	//Shifting of Index
	
	//Recursion
    public static int rec(int i, int j, String s, String t) {
        if(i < 0 || j < 0) return 0;
        
        if(s.charAt(i) == t.charAt(j)) {
            return 1 + rec(i-1, j-1, s, t);
        }
        else{
             return Math.max(rec(i-1, j, s, t), rec(i, j-1, s, t));
        }
    }
    
    //Memo
    public static int memo(int i, int j, String s, String t, int[][] dp) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = 1 + memo(i-1, j-1, s, t, dp);
        }
        else{
             return dp[i][j] = Math.max(memo(i-1, j, s, t, dp), memo(i, j-1, s, t, dp));
        }
    }

    //Tabulation
    public static int tabu(int n, int m, String s, String t) {
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        for(int i=0; i<=n; i++) dp[i][0] = 0;
        for(int i=0; i<=m; i++) dp[0][i] = 0;
        
        for(int ind1=1; ind1<=n; ind1++) {
            for(int ind2=1; ind2<=m; ind2++) {
                if(s.charAt(ind1-1) == t.charAt(ind2-1)) {
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }
                else {
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
                }
            }
        } 
        return dp[n][m];
    }
    
    //Space op
    public static int space_op(int n, int m, String s, String t) {
        int[] prev = new int[m+1];
        
        for(int ind1=1; ind1<=n; ind1++) {
            int[] curr = new int[m+1];
            for(int ind2=1; ind2<=m; ind2++) {
                if(s.charAt(ind1-1) == t.charAt(ind2-1)) {
                    curr[ind2] = 1 + prev[ind2-1];
                }
                else {
                    curr[ind2] = Math.max(prev[ind2], curr[ind2-1]);
                }
            }
            prev = curr;
        } 
        return prev[m];
    }
}
