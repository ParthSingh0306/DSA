package Recursion;

import java.util.Scanner;

public class PrintingAnUmber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printingAnUmber(n);
		sc.close();
	}

	private static void printingAnUmber(int n) {
		if(n == 0) {
			return;
		}
		
		int rem = n % 10;
		printingAnUmber(n/10);
		print(rem);
	}

	private static void print(int rem) {
		if(rem == 0) System.out.print("Zer0 ");
		if(rem == 1) System.out.print("One ");
		if(rem == 2) System.out.print("Two ");
		if(rem == 3) System.out.print("Three ");
		if(rem == 4) System.out.print("Four ");
		if(rem == 5) System.out.print("Five ");
		if(rem == 6) System.out.print("Six ");
		if(rem == 7) System.out.print("Seven ");
		if(rem == 8) System.out.print("Eight ");
		if(rem == 9) System.out.print("Nine ");
	}

}
