package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			stack.push(sc.nextInt());
		}
		
		sortStack(stack);
		System.out.println(stack.toString());
		sc.close();
	}

	private static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		
		int num = stack.peek();
		stack.pop();
		
		sortStack(stack);
		sortedInsert(stack, num);
	}
	
    private static void sortedInsert(Stack<Integer> stack, int m) {
		if(stack.isEmpty() || (stack.peek() < m  && !stack.isEmpty())) {
			stack.push(m);
			return;
		}
		
		int num = stack.peek();
		stack.pop();
		
		sortedInsert(stack, m);
		stack.push(num);
	}

}
