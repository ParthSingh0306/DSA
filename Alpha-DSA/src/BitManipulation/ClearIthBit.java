package BitManipulation;

import java.util.Scanner;

public class ClearIthBit {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int bit = sc.nextInt();
		System.out.println(n & ~(1 << bit));
	}

}
