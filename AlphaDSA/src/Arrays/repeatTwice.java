package Arrays;

import java.util.HashSet;
import java.util.Scanner;

public class repeatTwice {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		   int n = sc.nextInt();
		   int[] ans = new int[n];
		   for(int i=0; i<n; i++) {
			   ans[i] = sc.nextInt();
		   }
		  System.out.println(repeat(ans));
	}
	
	public static boolean repeat(int[] arr) {
		HashSet<Integer> set = new HashSet<>();
		for(int n : arr) {
			if(set.contains(n)) {
				return true;
			}else {
				set.add(n);
			}
		}
		return false;
	}

}
