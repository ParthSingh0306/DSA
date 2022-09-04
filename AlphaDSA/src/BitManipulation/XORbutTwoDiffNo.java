package BitManipulation;

import java.util.Scanner;

public class XORbutTwoDiffNo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		XORbutTwoDiffNo(n, arr);
	}
	
	public static void XORbutTwoDiffNo(int n, int[] arr) {
		int XOR = 0;
		
		for(int i=0; i<n; i++) {
			XOR = XOR ^ arr[i];
		}
		
		int cnt = 0;
		while(XOR != 0) {
			if((XOR & 1) == 1) {
				break;
			}
			cnt++;
			XOR = XOR >> 1;
		}
		
		System.out.println(cnt);
		
		int xor1 = 0;
		int xor2 = 0;
		
		for(int i=0; i<n; i++) {
			if((arr[i] & (1 << cnt)) != 0) {
				xor1 = xor1 ^ arr[i];
			}else {
				xor2 = xor2 ^ arr[i];
			}
		}
		
		System.out.println(xor1 + " " + xor2);
	}

}
