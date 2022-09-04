package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		   int n = sc.nextInt();
		   int[] ans = new int[n];
		   for(int i=0; i<n; i++) {
			   ans[i] = sc.nextInt();
		   }
		   int start = 0;
		   int end = n-1;
		    while(start < end) {
		    	swap(ans, start, end);
		    	start++;
		    	end--;
		    }
		    System.out.println(Arrays.toString(ans));   
	}
	
	public static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
	    arr[first] = arr[second];
	    arr[second] = temp;
	}

}
