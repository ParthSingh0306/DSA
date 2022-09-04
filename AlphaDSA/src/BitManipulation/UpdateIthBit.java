package BitManipulation;

import java.util.Scanner;

public class UpdateIthBit {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int bit = sc.nextInt();
		int newBit = sc.nextInt();
		System.out.println(updateIthBit(n, bit, newBit));
	}
	
	public static int updateIthBit(int n, int bit, int newBit) {
		if(newBit == 0) {
			return ClearIthBit(n, bit);
		}else {
			return SetIthBit(n, bit);
		}
	}
	
	public static int GetIthBit(int n, int bit) {
		if((n&(1<<bit))==0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	public static int SetIthBit(int n, int bit) {
		return (n | (1 << bit));
	}
	
    public static int ClearIthBit(int n, int bit) {
    	return (n & ~(1 << bit));
    }

}
