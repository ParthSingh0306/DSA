package BitManipulation;

import java.util.Scanner;

public class XORofAllNos {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		
		int ans = 0;
		
//		0(N)
		for(int i=0; i<=n; i++) {
			ans = ans ^ i;
		}
		System.out.println(ans);

	}
	
//	0(1)
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
