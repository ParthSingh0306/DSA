package Recursion;

import java.util.Scanner;

public class FindAllOccurences {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int key = sc.nextInt();
		findAllOccurences(0, arr, key);
		sc.close();
	}

	private static void findAllOccurences(int i, int[] arr, int key) {
		if(i == arr.length) {
			return;
		}
		if(arr[i] == key) {
			System.out.print(i + " ");
		}
		
		findAllOccurences(i+1, arr, key);
	}

}
