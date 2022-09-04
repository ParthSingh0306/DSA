package Recursion;

import java.util.Scanner;

public class NthFibonacciNo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(nthFibonacciNo(n));
		sc.close();
	}

	private static int nthFibonacciNo(int n) {
		if(n <= 1) {
			return n;
		}
		return nthFibonacciNo(n-1) + nthFibonacciNo(n-2);
	}

}
