package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AllSubSetSum {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
        List<Integer> ds = new ArrayList<>();
		printSubsetSum(0, arr, ds, 0,  n);
		Collections.sort(ds);
		System.out.println(ds);
		sc.close();
	}

	private static void printSubsetSum(int idx, int[] arr, List<Integer> ds, int sum, int n) {
		if(idx == n) {
			ds.add(sum);
			return;
		}
		
//		pick
		sum += arr[idx];
		printSubsetSum(idx+1, arr, ds, sum, n);
		
//      not pick
		sum -= arr[idx];
		printSubsetSum(idx+1, arr, ds, sum, n);
	}

}
