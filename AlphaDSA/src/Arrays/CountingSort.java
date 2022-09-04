package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {

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
		int largest = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			largest = Math.max(largest, arr[i]);
		}
		int[] count = new int[largest+1];
		for(int i=0; i<n; i++) {
			count[arr[i]]++;
		}
		
		int j = 0;
		for(int i=0; i<count.length; i++) {
			while(count[i] > 0) {
				arr[j] = i;
				j++;
				count[i]--;
			}
		}
	}

}
