package Recursion;

import java.util.Scanner;

public class FirstOccurence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int key = sc.nextInt();
		System.out.println(firstOccurence(arr, key, 0));
		sc.close();
	}

	private static int firstOccurence(int[] arr, int key, int i) {
		if(i == arr.length) {
			return -1;
		}
		if(arr[i] == key) {
			return i;
		}
		
		return firstOccurence(arr, key, i+1);
	}

}
