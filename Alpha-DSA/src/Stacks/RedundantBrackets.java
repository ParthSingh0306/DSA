package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class RedundantBrackets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		System.out.println(redundantBrackets(s));
		sc.close();
	}

	private static boolean redundantBrackets(String s) {
		Stack<Character> st = new Stack<>();
		int n = s.length();
		
		for(int i=0; i<n; i++) {
			char ch = s.charAt(i);
			
			if(ch == '(' || ch == '+' || ch == '*' || ch == '/' || ch == '-') {
				st.push(ch);
			}
			else {
				
				if(ch == ')') {
					boolean isRedundant = true;
					while(st.peek() != '(') {
						char top = st.peek();
						if(top == '+' || top == '*' || top == '/' || top == '-') {
							isRedundant = false;
						}
						st.pop();
					}
					if(isRedundant == true) {
						return true;
					}
					st.pop();
				}
			}
		}
		return false;
	}

}
