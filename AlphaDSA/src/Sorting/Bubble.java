package Sorting;

import java.util.Arrays;

public class Bubble {

	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 2, 3, 2};
		int n = arr.length;
		System.out.println("Before Sorting : " + Arrays.toString(arr));
		sort(arr, n);
		System.out.println("After Sorting : " + Arrays.toString(arr));
	}
	
	public static void sort(int[] arr, int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j+1, j);
				}
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
