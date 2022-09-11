package BackTracking;

import java.util.Scanner;

public class SubsetsOfString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		findSubsets(s, "", 0);
		sc.close();
	}

//	T.C - O(N * 2^N)
//	S.C - O(N)
	private static void findSubsets(String s, String ans, int i) {
		if(i == s.length()) {
			System.out.println(ans);
			return;
		}
		
//		Yes
		findSubsets(s, ans+s.charAt(i), i+1);
//		No
		findSubsets(s, ans, i+1);
		
	}

}
