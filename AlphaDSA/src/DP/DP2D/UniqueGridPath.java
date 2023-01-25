package DP.DP2D;

import java.util.Arrays;

public class UniqueGridPath {

	public static void main(String[] args) {
		//Recursion
		System.out.println(uniqueRec(2, 2));
		
		//Memoization
		int[][] dp = new int[3][3];
		for(int[] row : dp) Arrays.fill(row, -1);
		System.out.println(uniqueMemo(2, 2, dp));
		
		//Tabulation
		System.out.println(uniqueTabu(3, 3));
		
		//Space optimisation
		System.out.println(space_op(3, 3));
		
		//Combinatrics solution
		System.out.println(grid_combinatrics(3, 3));
	}
	
	public static int uniqueRec(int n, int m) {
		if(n == 0 || m == 0) return 1;
		if(n < 0 || m < 0) return 0;
		int left = uniqueRec(n-1, m);
		int right = uniqueRec(n, m-1);
		return left + right;
	}
	
	public static int uniqueMemo(int n, int m, int[][] dp) {
		if(n == 0 || m == 0) return 1;
		if(n < 0 || m < 0) return 0;
		if(dp[n][m] != -1) return dp[n][m];
		int left = uniqueMemo(n-1, m, dp);
		int right = uniqueMemo(n, m-1, dp);
		return dp[n][m] = left + right;
	}
	
	//T.C = O(n*m) S.C = O(n*m)
	public static int uniqueTabu(int n, int m) {
		int[][] dp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i==0 && j==0) {
					dp[i][j] = 1;
					continue;
				} else {
					int left = 0; int right = 0;
					if(i>0) left = dp[i-1][j];
					if(j>0) right = dp[i][j-1];
					dp[i][j] = left + right;
				}
			}
		}
		
		return dp[n-1][m-1];
	}
	
	//IF THERE IS PREV ROW AND COLUMN , WE CAN SPACE OPTIMISED
	
	public static int space_op(int n, int m) {
		int[] prev = new int[m];
		for(int i=0; i<n; i++) {
			int[] temp = new int[m];
			for(int j=0; j<m; j++) {
				if(i==0 && j==0) {
					temp[j] = 1;
					continue;
				} else {
					int up = 0;
					int left = 0;
					if(i > 0) up = prev[j];
					if(j > 0) left = temp[j-1];
					temp[j] = left + up;
				}
			}
			prev = temp;
		}
		return prev[n-1];
	}
	
	public static int grid_combinatrics(int n, int m) {
		int N = n + m - 2;
		int r = m - 1;
		double res = 1;
		
		for(int i=1; i<= r; i++) {
			res = res * (N - r + i) / i;
		}
		
		return (int) res;
	}

}
