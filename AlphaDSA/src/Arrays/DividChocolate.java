package Arrays;

import java.util.Scanner;

public class DividChocolate {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		System.out.println(divide(arr, m));
		sc.close();
	}

	private static int divide(int[] arr, int m) {
		int start = 1;
		int end = 0;
		for(int i=0; i<arr.length; i++) {
			end += arr[i];
		}
		int ans = 1;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(isGet(arr, m, mid) == true) {
				ans = mid;
				start = mid + 1;
			}
			else {
				end  = mid - 1;
			}
		}
		return ans;
	}

	private static boolean isGet(int[] arr, int limit, int mid) {
		int cnt = 0;
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			
			if(sum >= limit) {
				cnt++;
				sum = 0;
			}
		}
		return cnt >= mid;
	}

}
