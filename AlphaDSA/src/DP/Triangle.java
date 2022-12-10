package DP;

//import java.util.Arrays;

public class Triangle {

	public static void main(String[] args) {
		int[][] tri = {
				{2},
				{3, 4},
				{6, 5, 7},
				{4, 1, 8, 3}
		};
		
		System.out.println(minimumPathSum(tri.length, tri));
	}
	
	public static int minimumPathSum(int n, int[][] tri) {
		//Recursion
//		return f(0, 0, n, tri);
		
		//Memoization
//		int[][] dp = new int[n][n];
//		for(int[] row : dp) Arrays.fill(row, -1);
//		return memo(0, 0, n, tri, dp);
		
		//Tabulation
		return space_op(n, tri);
	}
	
	//T.C = O(2^N) S.C = O(N) 
	public static int f(int i, int j, int n, int[][] tri) {
		if(i == n-1) return tri[n-1][j];
		int down = tri[i][j] + f(i+1, j, n, tri);
		int diag = tri[i][j] + f(i+1, j+1, n, tri);
		return Math.min(down, diag);
	}
	
	//T.C = O(N^2) S.C = O(N) + O(N^2)
	public static int memo(int i, int j, int n, int[][] tri, int[][] dp) {
		if(i == n-1) return tri[n-1][j];
		if(dp[i][j] != -1) return dp[i][j];
		int down = tri[i][j] + memo(i+1, j, n, tri, dp);
		int diag = tri[i][j] + memo(i+1, j+1, n, tri, dp);
		return dp[i][j] = Math.min(down, diag);
	}
	
	//T.C = O(N^2) S.C = O(N^2)
	public static int tabu(int n, int[][] tri) { 
		int[][] dp = new int[n][n];
		
		for(int j=0; j<n; j++) dp[n-1][j] = tri[n-1][j];
		
		for(int i=n-2; i>=0; i--) {
			for(int j=i; j>=0; j--) {
				int down = tri[i][j] + dp[i+1][j];
				int diag = tri[i][j] + dp[i+1][j+1];
				dp[i][j] = Math.min(down, diag);
			}
		}
		
		return dp[0][0];
	}
	
	//T.C = O(N^2) S.C = O(N)
	public static int space_op(int n, int[][] tri) { 
		int[] prev = new int[n];
		
		for(int j=0; j<n; j++) prev[j] = tri[n-1][j];
		
		for(int i=n-2; i>=0; i--) {
			int[] curr = new int[n];
			for(int j=i; j>=0; j--) {
				int down = tri[i][j] + prev[j];
				int diag = tri[i][j] + prev[j+1];
				curr[j] = Math.min(down, diag);
			}
			prev = curr;
		}
		return prev[0];
	}

}
