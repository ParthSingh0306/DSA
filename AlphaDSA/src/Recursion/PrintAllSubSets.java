package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintAllSubSets {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(AllSubSets(arr));
		sc.close();
	}

	private static List<List<Integer>> AllSubSets(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		List<List<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> ds = new ArrayList<>();
		findSubSets(0, arr, ans, ds, n);
		return ans;
	}

	private static void findSubSets(int idx, int[] arr, List<List<Integer>> ans, ArrayList<Integer> ds, int n) {
		ans.add(new ArrayList<>(ds));
		for(int i=idx; i<n; i++) {
			if(i!=idx && arr[i] == arr[i-1]) continue;
			ds.add(arr[i]);
			findSubSets(i+1, arr, ans, ds, n);
			ds.remove(ds.size()-1);
		}
	}

}
