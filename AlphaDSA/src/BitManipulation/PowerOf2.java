package BitManipulation;

import java.util.Scanner;

public class PowerOf2 {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
//		power of 2 or not
		if((n&(n-1)) == 0) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
	}

}
