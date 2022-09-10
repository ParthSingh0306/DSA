package Recursion;

import java.util.Scanner;

public class PrintBinaryString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printBinaryString(n, 0, "");
		sc.close();
	}

	private static void printBinaryString(int n, int lastplace, String str) {
		
		if(n == 0) {
			System.out.println(str);
			return;
		}
		
		printBinaryString(n-1, 0, str += '0');
		if(lastplace == 0) {
			printBinaryString(n-1, 1, str += '1');
		}
	}

}
