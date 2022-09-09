package Recursion;

import java.util.Scanner;

public class PairingFriends {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(pairingFriends(n));
		sc.close();
	}

	private static int pairingFriends(int n) {
		if(n == 1 || n == 2) {
			return n;
		}
		
		int single = pairingFriends(n-1);
		int mingle = (n-1) * pairingFriends(n-2);
		
		return single + mingle;
	}

}
