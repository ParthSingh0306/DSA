package Recursion;

import java.util.Scanner;

public class SumOfN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(sumOfN(n));
		sc.close();
	}

	private static int sumOfN(int n) {
		if(n == 1) return 1;
		return n + sumOfN(n-1);
	}

}
