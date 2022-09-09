package Recursion;

import java.util.Scanner;

public class RemoveDuplicatesFromString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StringBuilder str = new StringBuilder();
		boolean[] arr = new boolean[26];
		System.out.println(removeDuplicatesFromString(s));
		removeDuplicatesFromStringRec(s, 0, str, arr);
		sc.close();
	}

	private static String removeDuplicatesFromString(String s) {
		boolean[] arr = new boolean[26];
		String ans = "";
		int n = s.length();
		
		for(int i=0; i<n; i++) {
			if(arr[s.charAt(i) - 'a'] == true) continue;
			else {
				arr[s.charAt(i) - 'a'] = true;
				ans += s.charAt(i);
			}
		}
		return ans;
	}
	
	private static void removeDuplicatesFromStringRec(String s, int idx, StringBuilder str, boolean[] map) {
		if(idx == s.length()) {
			System.out.println(str);
			return;
		}
		
	    char currChar = s.charAt(idx);
	    if(map[currChar - 'a'] == true) {
	    	removeDuplicatesFromStringRec(s, idx+1, str, map);
	    }else {
	    	map[currChar - 'a'] = true;
	    	removeDuplicatesFromStringRec(s, idx+1, str.append(currChar), map);
	    }
	}

}
