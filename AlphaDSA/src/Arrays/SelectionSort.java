package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		   int n = sc.nextInt();
		   int[] ans = new int[n];
		   for(int i=0; i<n; i++) {
			   ans[i] = sc.nextInt();
		   }
		   sort(ans);
		   System.out.println(Arrays.toString(ans));
	}
	
	public static void sort(int[] arr) {
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			int mini = i;
			for(int j=i+1; j<n; j++) {
				if(arr[mini] > arr[j]) mini = j;
			}
			int temp = arr[mini];
			arr[mini] = arr[i];
			arr[i] = temp;
		}
	}

}
