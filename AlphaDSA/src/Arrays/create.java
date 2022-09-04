package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class create {

	public static void main(String[] args) {
	   Scanner sc =  new Scanner(System.in);
	   int n = sc.nextInt();
	   int[] ans = new int[n];
	   for(int i=0; i<n; i++) {
		   ans[i] = sc.nextInt();
	   }
	   System.out.println(Arrays.toString(ans));
	}

}
