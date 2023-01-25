package DP.DP2D;

import java.util.Arrays;

public class CherrypickUp3D {
	
	static int min = -100000000;
	public static void main(String[] args) {
		int r = 3, c = 4;
		int[][] grid = {
				{2, 3, 1, 2},
				{3, 4, 2, 2},
				{5, 6, 3, 5}
		};
		
		System.out.println(maximumChocolates(r, c, grid));
	}
	
	public static int maximumChocolates(int r, int c, int[][] grid) {
		
//        return f(0, 0, c-1, r, c, grid); // Recursion
        
		//Memoization
        int[][][] dp = new int[r][c][c];
        for(int[][] i : dp) {
        	for(int[] j : i) {
        		Arrays.fill(j, -1);
        	}
        }
//        return memo(0, 0, c-1, r, c, grid, dp);
//        return tabu(r, c, grid);
        return space_op(r, c, grid);
	}
	
	// Recursion T.C = O(3^n)
    public static int f(int i, int j1, int j2, int r, int c, int[][] grid) {
        if(j1 < 0 || j2 < 0 || j1 >= c || j2 >= c) {
            return min;
        }
        
        if(i == r-1) {
            if(j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }
        
        int max = min;
        for(int dj1=-1; dj1<=1; dj1++) {
            for(int dj2=-1; dj2<=1; dj2++) {
                int value = 0;
                if(j1 == j2) value = grid[i][j1];
                else {
                    value = grid[i][j1] + grid[i][j2];
                }
                value += f(i+1, j1+dj1, j2+dj2, r, c, grid);
                max = Math.max(max, value);
            }
        }
        return max;
    }
    
    
    //memo T.C = O(N*M*M) * 9 + O(N)
    public static int memo(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {
        if(j1 < 0 || j2 < 0 || j1 >= c || j2 >= c) {
            return min;
        }
        
        if(i == r-1) {
            if(j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }
        
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        int max = min;
        for(int dj1=-1; dj1<=1; dj1++) {
            for(int dj2=-1; dj2<=1; dj2++) {
                int value = 0;
                if(j1 == j2) value = grid[i][j1];
                else {
                    value = grid[i][j1] + grid[i][j2];
                }
                value += memo(i+1, j1+dj1, j2+dj2, r, c, grid, dp);
                max = Math.max(max, value);
            }
        }
        return dp[i][j1][j2] = max;
    }
    
    
//    Tabu T.C = O(N*M*M) * 9
    public static int tabu(int n, int m, int[][] grid) {
    	int[][][] dp = new int[n][m][m];
    	
    	for(int j1 = 0; j1<m; j1++) {
    		for(int j2 = 0; j2<m; j2++) {
    			if(j1 == j2) dp[n-1][j1][j2] = grid[n-1][j1];
    			else {
    				dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
    			}
    		}
    	}
    	
    	for(int i=n-2; i>=0; i--) {
    		for(int j1=0; j1<m; j1++) {
    			for(int j2=0; j2<m; j2++) {
    				int max = min;
    		        for(int dj1=-1; dj1<=1; dj1++) {
    		            for(int dj2=-1; dj2<=1; dj2++) {
    		                int value = 0;
    		                if(j1 == j2) value = grid[i][j1];
    		                else {
    		                    value = grid[i][j1] + grid[i][j2];
    		                }
    		                if(j1+dj1 >=0 && j1+dj1<m && j2+dj2 >=0 && j2+dj2<m)
    		                	value += dp[i+1][j1+dj1][j2+dj2];
    		                else
    		                	value += min;
    		                max = Math.max(max, value);
    		            }
    		        }
    		        dp[i][j1][j2] = max;
    			}
    		}
    	}
    	
    	return dp[0][0][m-1];
    }
    
    
	public static int space_op(int n, int m, int[][] grid) {
        int[][] front = new int[m][m];
        int[][] curr = new int[m][m];
        
        for(int j1 = 0; j1<m; j1++) {
            for(int j2 = 0; j2<m; j2++) {
                if(j1 == j2) front[j1][j2] = grid[n-1][j1];
                else {
                    front[j1][j2] = grid[n-1][j1] + grid[n-1][j2];
                }
            }
        }
        
        for(int i=n-2; i>=0; i--) {
            for(int j1=0; j1<m; j1++) {
                for(int j2=0; j2<m; j2++) {
                    int max = min;
                    for(int dj1=-1; dj1<=1; dj1++) {
                        for(int dj2=-1; dj2<=1; dj2++) {
                            int value = 0;
                            if(j1 == j2) value = grid[i][j1];
                            else {
                                value = grid[i][j1] + grid[i][j2];
                            }
                            if(j1+dj1 >=0 && j1+dj1<m && j2+dj2 >=0 && j2+dj2<m)
                                value += front[j1+dj1][j2+dj2];
                            else
                                value += min;
                            max = Math.max(max, value);
                        }
                    }
                    curr[j1][j2] = max;
                }
            }
            for (int a = 0; a < m; a++) {
                front[a] = (int[])(curr[a].clone());
            }
        }
        return front[0][m-1];
	}

}
