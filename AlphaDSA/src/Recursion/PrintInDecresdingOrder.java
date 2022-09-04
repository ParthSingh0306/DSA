package Recursion;

import java.util.Scanner;

public class PrintInDecresdingOrder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printInDecresdingOrder(n);
		sc.close();
	}

	private static void printInDecresdingOrder(int n) {
		if(n == 0) return;
		System.out.println(n);
		printInDecresdingOrder(n-1);
	}

}
