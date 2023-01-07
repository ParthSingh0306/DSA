package DP;

import java.util.Arrays;

public class PrintLCS {

	public static void main(String[] args) {
		String s = "abbu";
		String t = "abbah";
		int n = s.length();
		int m = t.length();
		
		
		//code for finding longest LCS
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
        
		int len = dp[n][m];
		int i=n, j=m;
		StringBuilder ans = new StringBuilder("");
		
		while(i >0 && j > 0) {
			if(s.charAt(i-1) == t.charAt(j-1)) {
				ans.append(s.charAt(i-1));
				i--;
				j--;
			}
			else if(dp[i-1][j] > dp[i][j-1]) {
				i--;
			} else {
				j--;
			}
		}
		//reverse before printing
		System.out.println(ans.reverse()); 
	}
}
