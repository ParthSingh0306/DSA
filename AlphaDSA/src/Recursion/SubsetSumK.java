package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SubsetSumK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		subsetSumK(0, list, 0, sum, arr, n);
		subsetSumK2(0, list, 0, sum, arr, n);
		sc.close();
	}

	
//	print all 
	private static void subsetSumK(int idx, ArrayList<Integer> list, int s, int sum, int[] arr, int n) {
		
		if(idx == n) {
			if(s == sum) {
				System.out.println(list);
			}
			return;
		}
		
		list.add(arr[idx]);
		s += arr[idx];
		subsetSumK(idx+1, list, s, sum, arr, n);
		
		list.remove(list.size()-1);
		s -= arr[idx];
		subsetSumK(idx+1, list, s, sum, arr, n);
		
	}
	
	
//	stop after printing one
private static boolean subsetSumK2(int idx, ArrayList<Integer> list, int s, int sum, int[] arr, int n) {
		
		if(idx == n) {
			if(s == sum) {
				System.out.println(list);
				return true;
			}
			return false;
		}
		
		list.add(arr[idx]);
		s += arr[idx];
		if(subsetSumK2(idx+1, list, s, sum, arr, n) == true) {
			return true;
		}
		
		list.remove(list.size()-1);
		s -= arr[idx];
		if(subsetSumK2(idx+1, list, s, sum, arr, n) == true) {
			return true;
		}
		
		return false;
		
	}

}
