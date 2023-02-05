package DP.PartionDP;

import java.util.Arrays;

public class BooleanEvaluationTrue {
	static int mod = 1000000007;
	public static void main(String[] args) {
		String exp =  "F|T^F";
		int n = exp.length();
        long[][][] dp = new long[n][n][2];
        for(long[][] ca : dp)
            for(long[] c : ca)
                Arrays.fill(c, -1);
        System.out.println((int) (f(0, n-1, 1, exp, dp) % mod));
	}
	
    public static long f(int i, int j, int isTrue, String exp, long[][][] dp) {
        if(i > j) return 0;
        if(i == j) {
            if(isTrue == 1) {
                if(exp.charAt(i) == 'T') return 1;
                else return 0;
            }
            else {
                if(exp.charAt(i) == 'F') return 1;
                else return 0;
            }
        }
        if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        long ways = 0;

        for(int ind=i+1; ind<=j-1; ind+=2) {
            long lt = f(i, ind-1, 1, exp, dp);
            long lf = f(i, ind-1, 0, exp, dp);
            long rt = f(ind+1, j, 1, exp, dp);
            long rf = f(ind+1, j, 0, exp, dp);

            if(exp.charAt(ind) == '&') {
                if(isTrue == 1) {
                    ways = (ways + (rt * lt) % mod) % mod;
                }
                else {
                    ways = (ways + (rt * lf) % mod + (rf * lt) % mod + (rf * lf) % mod) % mod; 
                }
            }
            else if(exp.charAt(ind) == '|') {
                if(isTrue == 1) {
                    ways = (ways + (rt * lf) % mod + (rf * lt) % mod + (rt * lt) % mod) % mod;
                } else {
                    ways = (ways + (rf * lf) % mod) % mod;
                }
            }
            else {
                if(isTrue == 1) {
                    ways = (ways + (lt * rf) % mod + (rt * lf) % mod) % mod;
                } else {
                    ways = (ways + (lt * rt) % mod + (rf * lf) % mod) % mod;
                }
            }
        }

        return dp[i][j][isTrue] = ways;
    }

}
