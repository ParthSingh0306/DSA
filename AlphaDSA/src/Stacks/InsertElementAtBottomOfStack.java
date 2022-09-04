package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class InsertElementAtBottomOfStack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			stack.push(sc.nextInt());
		}
		int m = sc.nextInt();
		
		insertElementAtBottomOfStack(stack, m);
		System.out.println(stack.toString());
		sc.close();
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
