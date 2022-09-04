package Recursion;

import java.util.Scanner;

public class PrintInIncreasingOrder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printInIncreasingOrder(n);
		sc.close();
	}

	private static void printInIncreasingOrder(int n) {
		if(n == 0) return;
		printInIncreasingOrder(n-1);
		System.out.println(n);
	}

}
