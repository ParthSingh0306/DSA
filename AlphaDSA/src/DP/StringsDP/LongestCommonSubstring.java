package DP.StringsDP;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String s = "parth";
		String t = "payal";
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        
        for(int ind1=1; ind1<=n; ind1++) {
            for(int ind2=1; ind2<=m; ind2++) {
                if(s.charAt(ind1-1) == t.charAt(ind2-1)) {
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                    ans = Math.max(ans, dp[ind1][ind2]);
                }
                else {
                    dp[ind1][ind2] = 0;
                }
            }
        }
        
        System.out.println(ans);
	}
	
//	TO DO : Optimise it further more using prev and curr 

}
