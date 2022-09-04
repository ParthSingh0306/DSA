package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStringUsingStack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();
		String ans = "";
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			stack.push(s.charAt(i));
		}
		
		for(int i=0; i<n; i++) {
			ans += stack.pop();
		}
		System.out.println(ans);
		sc.close();
	}
	
//	T.C = O(N)
//	S.C = O(N)

}
