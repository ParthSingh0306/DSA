package Sorting;

import java.util.Arrays;

public class Selection {

	public static void main(String[] args) {
		int[] arr = {5, 8, 3, 2, 5, 7};
		int n = arr.length;
		System.out.println("Before Sorting : " + Arrays.toString(arr));
		sort(arr, n);
		System.out.println("After Sorting : " + Arrays.toString(arr));
	}
	
	public static void sort(int[] arr, int n) {
		for(int i=0; i<n; i++) {
			int min = i;
			for(int j=i; j<n; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
}
