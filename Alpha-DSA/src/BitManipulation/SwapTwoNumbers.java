package BitManipulation;

import java.util.Scanner;

public class SwapTwoNumbers {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		System.out.println("Before Swapping: n = " + n + " m = " + m);
		n = n ^ m;
		m = n ^ m;
		n = n ^ m;
		System.out.println("After Swapping: n = " + n + " m = " + m);
	}

}
