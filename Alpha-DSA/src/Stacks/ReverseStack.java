package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {
	
//	T.C = O(N^2)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			stack.push(sc.nextInt());
		}
		
		reverseStack(stack);
		System.out.println(stack.toString());
		sc.close();
	}

	private static void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		
		int num = stack.peek();
		stack.pop();
		
		reverseStack(stack);
		
		insertElementAtBottomOfStack(stack, num);
	}
	
	private static void insertElementAtBottomOfStack(Stack<Integer> st, int m) {
		if(st.isEmpty()) {
			st.push(m);
			return;
		}
		
		int num = st.peek();
		st.pop();
		
		insertElementAtBottomOfStack(st, m);
		st.push(num);
	}

}
