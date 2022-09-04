package Arrays;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		   int n = sc.nextInt();
		   int[] ans = new int[n];
		   for(int i=0; i<n; i++) {
			   ans[i] = sc.nextInt();
		   }
		   int target = sc.nextInt();
		   System.out.println(bsearch(ans, target));
		   
	}
	
	public static int bsearch(int[] ans, int target) {	
		int start = 0;
		int end = ans.length-1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(ans[mid] == target) {
				return mid;
			}else if(ans[mid] > target) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return -1;
	}

}
