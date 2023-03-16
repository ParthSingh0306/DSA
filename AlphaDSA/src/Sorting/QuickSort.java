package Sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {5, 4, 3, 2, 1};
		int n = arr.length;
		System.out.println("Before Sorting : " + Arrays.toString(arr));
		qs(arr, 0, n-1);
		System.out.println("After Sorting : " + Arrays.toString(arr));
	}
	
	public static int partition(int[] arr, int low, int high) {
	        int pivot = arr[low];
	        int i = low;
	        int j = high;
	
	        while (i < j) {
	            while (arr[i] <= pivot && i <= high - 1) {
	                i++;
	            }
	
	            while (arr[j] > pivot && j >= low + 1) {
	                j--;
	            }
	            if (i < j) {
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	        int temp = arr[low];
	        arr[low] = arr[j];
	        arr[j] = temp;
	        return j;
	    }
	
    public static void qs(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }
}
