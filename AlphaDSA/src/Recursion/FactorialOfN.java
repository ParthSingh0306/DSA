package Recursion;

import java.util.Scanner;

public class FactorialOfN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorialOfN(n));
		sc.close();
	}

	private static int factorialOfN(int n) {
		if(n <= 1) {
			return 1;
		}
		return n * factorialOfN(n-1);
	}

}
