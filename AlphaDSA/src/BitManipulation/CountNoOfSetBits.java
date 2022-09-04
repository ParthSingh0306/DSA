package BitManipulation;

import java.util.Scanner;

public class CountNoOfSetBits {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int num = n;
//		O(MSB)
		while(n != 0) {
			if((n & 1) == 1) {
				cnt++;
			}
			n = n >> 1;
		}
		System.out.println(cnt);
		
//		O(setBITS)
		while(num != 0) {
			num = num & (num - 1);
			cnt++;
		}
		System.out.println(cnt);
	}

}
