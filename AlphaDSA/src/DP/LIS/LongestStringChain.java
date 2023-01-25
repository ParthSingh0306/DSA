package DP.LIS;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {

	public static void main(String[] args) {
		String[] arr = {"a","b","ba","bca","bda","bdca"};
		System.out.println(longestStrChain(arr));
	}
	
    public static int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for(int i=0; i<n; i++) {
            for(int prev=0; prev<i; prev++) {
                if(compareString(words[i], words[prev]) == true && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static boolean compareString(String a, String b) {
        int l1 = a.length(), l2 = b.length();
        if(l1 != l2 + 1) return false;
        int f = 0;
        int s = 0;
        while(f < l1) {
            if(s < l2 && a.charAt(f) == b.charAt(s)) {
                f++;
                s++;
            }
            else {
                f++;
            }
        }
        if(f == l1 && s == l2) return true;
        return false;
    }

}
