package BitManipulation;

import java.util.Scanner;

public class XORinRange {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int left = sc.nextInt();
		int right = sc.nextInt();
		
		int ans = XorTillN(left-1) ^ XorTillN(right);
		System.out.println(ans);
	}

	
	public static int XorTillN(int n) {
		int ans;
		if(n%4 == 0) {
			ans = n;
		}else if(n%4 == 1) {
			ans = 1;
		}else if(n%4 == 3) {
			ans = 0;
		}else {
			ans = n + 1;
		}
		return ans;
	}
}
