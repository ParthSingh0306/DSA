package Arrays;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		   int n = sc.nextInt();
		   int[] ans = new int[n];
		   for(int i=0; i<n; i++) {
			   ans[i] = sc.nextInt();
		   }
		   int target = sc.nextInt();
		   
		   for(int i=0; i<n; i++) {
			   if(ans[i] == target) {
				   System.out.println("Index : " + i);
			   }
		   }
		   
	}

}
