package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class RemoveMiddleElementFromStack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			stack.push(sc.nextInt());
		}
		
		removeMiddleElementFromStack(stack, 0, n);
		System.out.println(stack.toString());
		sc.close();
	}

	private static void removeMiddleElementFromStack(Stack<Integer> stack, int count, int size) {
		if(count == size / 2) {
			stack.pop();
			return;
		}
		
		int num = stack.peek();
		stack.pop();
		
		removeMiddleElementFromStack(stack, count + 1, size);
		
		stack.push(num);
	}

}
