package Sorting;

import java.util.Arrays;

public class Insertion {

	public static void main(String[] args) {
		int[] arr = {5, 8, 3, 2, 5, 7};
		int n = arr.length;
		System.out.println("Before Sorting : " + Arrays.toString(arr));
		sort(arr, n);
		System.out.println("After Sorting : " + Arrays.toString(arr));
	}
	
	public static void sort(int[] arr, int n) {
		for(int i=1; i<n; i++) {
			int key = arr[i];
			int j = i-1;
			while(j > 0 && arr[j] < key) {
				System.out.println(arr[j]);
				arr[j-1] = arr[j];
				j++;
			}
			arr[j+1] = key;
		}
	}

}
