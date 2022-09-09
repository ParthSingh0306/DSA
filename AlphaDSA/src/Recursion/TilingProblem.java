package Recursion;

import java.util.Scanner;

public class TilingProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(tilingProblem(n));
		sc.close();
	}

	private static int tilingProblem(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		int verticalTiles = tilingProblem(n-1);
		int horizontalTiles = tilingProblem(n-2);
		int totalWays = verticalTiles + horizontalTiles;
		return totalWays;
	}

}
