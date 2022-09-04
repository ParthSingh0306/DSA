package BitManipulation;

import java.util.Scanner;

public class RemoveLastSetBit {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
//		removes the last set bit
		System.out.println(n & (n-1));
	}

}
