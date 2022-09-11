package BackTracking;

import java.util.Scanner;

public class FindPermutations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		permutations(s, "");
		sc.close();
	}

//	T.C - O(N *N!)
	private static void permutations(String s, String ans) {
		
		if(s.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		for(int i=0; i<s.length(); i++) {
			char curr = s.charAt(i);
			String News = s.substring(0, i) + s.substring(i+1);
			permutations(News, ans+curr);
		}
	}

}
