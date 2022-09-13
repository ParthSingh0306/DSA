package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PermutationOfArray {

	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(permute2(arr));
		sc.close();
	}
	
//	no of permutations = n!
//	approach 1
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recurPermute(nums, ans, ds, freq);
        return ans;
    }
    
    public static void recurPermute(int[] arr, List<List<Integer>> ans, ArrayList<Integer> ds, boolean[] freq) {
        
        if(ds.size() == arr.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=0; i<arr.length; i++) {
            if(!freq[i]) {
                freq[i] = true;
                ds.add(arr[i]);
                recurPermute(arr, ans, ds, freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
    
//    approach 2
//    T.C - O(N! * N)
//    LESS SPACE
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute2(0, nums, ans);
        return ans;
    }
    
    public static void recurPermute2(int idx, int[] arr, List<List<Integer>> ans) {
        if(idx == arr.length) {
        	List<Integer> ds = new ArrayList<>();
        	for(int i=0; i<arr.length; i++) {
        		ds.add(arr[i]);
        	}
        	ans.add(new ArrayList<>(ds));
        	return;
        }
	
        for(int i=idx; i<arr.length; i++) {
        	swap(idx, i, arr);
        	recurPermute2(idx+1, arr, ans);
        	swap(idx, i, arr);
        }
    }

	private static void swap(int idx, int i, int[] arr) {
		int t = arr[idx];
		arr[idx] = arr[i];
		arr[i] = t;
	}

}
