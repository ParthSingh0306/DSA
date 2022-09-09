package Recursion;

import java.util.Scanner;

public class XtoThePowerN {
	static int cnt = 0;
	static int cnt2 = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		
		System.out.println(xToThePowerN(x, n));
		System.out.println(xToThePowerNoptimised(x, n));
		System.out.println(cnt + " " + cnt2);
		sc.close();
	}

	private static int xToThePowerN(int x, int n) {
		cnt++;
		if(n == 0) {
			return 1;
		}
		return x * xToThePowerN(x, n-1);
	}
	
	private static int xToThePowerNoptimised(int x, int n) {
		cnt2++;
		if(n == 0) {
			return 1;
		}
		int halfpowerSquare = xToThePowerNoptimised(x,n/2);
		halfpowerSquare *= halfpowerSquare;
		
		if(n % 2 != 0) {
			return halfpowerSquare * x;
		}
		
		return halfpowerSquare;
	}

}
