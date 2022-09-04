package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(validParenthesis(s));
		sc.close();
	}

	private static boolean validParenthesis(String s) {
		int n = s.length();
		Stack<Character> st = new Stack<>();
		
		for(int i=0; i<n; i++) {
			char ch = s.charAt(i);
			
			if(ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			}
			else {
				if(!st.isEmpty()) {
					char top = st.peek();
					if(ch == ')' && top == '(' || ch == '}' && top == '{' || ch == ']' && top == '[') {
						st.pop();
					}else {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}
		
		if(st.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

}
