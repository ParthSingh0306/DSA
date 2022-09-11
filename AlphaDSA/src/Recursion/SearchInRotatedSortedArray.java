package Recursion;

import java.util.Scanner;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(search(arr, k, 0, n-1));
		sc.close();
	}

	private static int search(int[] arr, int k, int si, int ei) {
		if(si > ei) {
			return -1;
		}
		int mid = si + (ei - si) / 2;
		
		if(arr[mid] == k) {
			return mid;
		}
		
		if(arr[si] <= arr[mid]) {
			if(arr[si] <= k && k <= arr[mid]) {
				return search(arr, k, si, mid);
			}else {
				return search(arr, k, mid+1, ei);
			}
		}
		else {
			if(arr[mid] <= k && k <= arr[ei]) {
				return search(arr, k, mid, ei);
			}else {
				return search(arr, k, si, mid-1);
			}
		}
		
	}

}
