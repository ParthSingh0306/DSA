package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

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
		for(int i = 1; i<n; i++) {
			int curr = arr[i];
			int prev = i-1;
			while(prev >=0 && arr[prev] > curr) {
				arr[prev + 1] = arr[prev];
				prev--;
			}
			arr[prev+1] = curr;
		}
	}

}
