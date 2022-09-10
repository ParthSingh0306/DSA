package Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		sc.close();
	}

	private static void mergeSort(int[] arr, int si, int ei) {
		if(si >= ei) {
			return;
		}
		
		int mid = si + (ei - si) / 2;
		mergeSort(arr, si, mid);
		mergeSort(arr, mid+1, ei);
		merge(arr, si, mid, ei);
	}

	private static void merge(int[] arr, int si, int mid, int ei) {
		int[] temp = new int[ei-si+1];
		int i=si;
		int j=mid+1;
		int k=0;
		
		while(i <= mid && j <= ei ) {
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
			}else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		
		while(i <= mid) {
			temp[k++] = arr[i++];
		}
		
		while(j <= si) {
			temp[k++] = arr[j++];
		}
		
		for(k=0, i=si; k<temp.length; k++, i++) {
			arr[i] = temp[k];
		}
	}

}
