package Sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {6, 5, 8, 3, 2, 8};
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int si, int ei) {
		if(si >= ei) return;
		
		int mid = (si + ei) / 2;
		mergeSort(arr, si, mid);
		mergeSort(arr, mid+1, ei);
		merge(arr, si, mid, ei);
	}

	private static void merge(int[] arr, int si, int mid, int ei) {
		int[] temp = new int[ei - si + 1];
		int k = 0;
		int i = si;
		int j = mid + 1;
		while(i <= mid && j <= ei) {
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
			}
			else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		
		while(i <= mid) {
			temp[k++] = arr[i];
			i++;
		}
		
		while(j <= ei) {
			temp[k++] = arr[j];
			j++;
		}
		int m = si;
		for(k=0; k<temp.length; k++) {
			arr[m] = temp[k];
			m++;
		}
	}
}
