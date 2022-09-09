package Recursion;

import java.util.Scanner;

public class LastOccurence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int key = sc.nextInt();
		System.out.println(lastOccurence(arr, key, n-1));
		sc.close();
	}

	private static int lastOccurence(int[] arr, int key, int i) {
		if(i == -1) {
			return -1;
		}
		if(arr[i] == key) {
			return i;
		}
		
		return lastOccurence(arr, key, i-1);
	}

}
