package Arrays;

import java.util.Scanner;

public class printSubarrays {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		   int n = sc.nextInt();
		   int[] ans = new int[n];
		   for(int i=0; i<n; i++) {
			   ans[i] = sc.nextInt();
		   }
		   
		   print(ans);
		   
	}
	
	public static void print(int[] arr) {
		int n= arr.length;
		int subArray = 0;
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				for(int k=i; k<=j; k++) {
					System.out.print(arr[k] + " ");
				}
				subArray++;
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("Total SubArrays: " + subArray);
	}
	
//	no. of subArrays = n(n+1)/2

}
