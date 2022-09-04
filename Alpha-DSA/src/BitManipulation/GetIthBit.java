package BitManipulation;

import java.util.Scanner;

public class GetIthBit {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int bit = sc.nextInt();
		System.out.println((n&(1<<bit))==0?"0":"1");
	}

}
