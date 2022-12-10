package DP;
import java.util.Arrays;

public class NinjaTraining {

	public static void main(String[] args) {
		int[][] points = {{10,40,70},
                {20,50,80},
                {30,60,90}};

	    int n = points.length;
	    //recursion
	    System.out.println(ninjaRec(n-1, 3, points));
	    
	    //memoization
	    int[][] dp = new int[n][4];
	    for(int[] row : dp) Arrays.fill(row, -1);
	    System.out.println(ninjaMemo(n-1, 3, points, dp));
	    
	    //Tabulation
	    System.out.println(ninjaTabu(n, points));
	    
	    //Space optimisation
	    System.out.println(ninjaSpace_op(n, points));
	}
	
	//T.C = O(N*4*3) S.C = O()
	public static int ninjaRec(int day, int last, int[][] points) {
		if(day == 0) {
			int max = 0;
			for(int task=0; task<3; task++) {
				if(task != last) {
					max = Math.max(max, points[0][task]);
				}
			}
			return max;
		}
		
		int max = 0;
		for(int task=0; task<3; task++) {
			if(task != last) {
				int point = points[day][task] + ninjaRec(day-1, task, points);
				max = Math.max(max, point);
			}
		}
		return max;
	}
	
	//T.C = O(N*4*3) S.C = O(N*4) + O(N)
	public static int ninjaMemo(int day, int last, int[][] points, int[][] dp) {
		if(day == 0) {
			int max = 0;
			for(int task=0; task<3; task++) {
				if(task != last) {
					max = Math.max(max, points[0][task]);
				}
			}
			return max;
		}
		if(dp[day][last] != -1) return dp[day][last];
		int max = 0;
		for(int task=0; task<3; task++) {
			if(task != last) {
				int point = points[day][task] + ninjaRec(day-1, task, points);
				max = Math.max(max, point);
			}
		}
		return dp[day][last] = max;
	}
	
	//T.C = O(N*4*3) S.C = O(N*4)
	public static int ninjaTabu(int n, int[][] points) {
		int[][] dp = new int[n][4];
		
		dp[0][0] = Math.max(points[0][1], points[0][2]);
		dp[0][1] = Math.max(points[0][0], points[0][2]);
		dp[0][2] = Math.max(points[0][0], points[0][1]);
		dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
		
		for(int day=1; day<n; day++) {
			for(int last=0; last<4; last++) {
				dp[day][last] = 0;
				for(int task = 0; task < 3; task++) {
					if(task != last) {
						int act = points[day][task] + dp[day-1][task];
						dp[day][last] = Math.max(dp[day][last], act);
					}
				}
			}
		}
		return dp[n-1][3];
	}
	
	////T.C = O(N*4*3) S.C = O(4)
	public static int ninjaSpace_op(int n, int[][] points) {
		int[] dp = new int[4];
		
		dp[0] = Math.max(points[0][1], points[0][2]);
		dp[1] = Math.max(points[0][0], points[0][2]);
		dp[2] = Math.max(points[0][0], points[0][1]);
		dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
		
		for(int day=1; day<n; day++) {
			int[] temp = new int[4];
			for(int last=0; last<4; last++) {
				temp[last] = 0;
				for(int task = 0; task < 3; task++) {
					if(task != last) {
						int act = points[day][task] + dp[task];
						temp[last] = Math.max(temp[last], act);
					}
				}
			}
			dp = temp;
		}
		return dp[3];
	}

}
