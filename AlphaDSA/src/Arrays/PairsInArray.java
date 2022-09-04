package Arrays;

import java.util.Scanner;

public class PairsInArray {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		   int n = sc.nextInt();
		   int[] arr = new int[n];
		   for(int i=0; i<n; i++) {
			   arr[i] = sc.nextInt();
		   }
		   int totalPairs = 0;
		   for(int i=0; i<n; i++) {
			   for(int j=i+1; j<n; j++) {
				   System.out.print("(" + arr[i] + "," + arr[j] + ")" + " ");
				   totalPairs++;
			   }
			   System.out.println();
		   }
		   System.out.println("Total Pairs: " + totalPairs);
	}
	
//	Totalpairs = n(n-1)/2;
//	TC = O(N^2)
//	SC = O(1)

}
