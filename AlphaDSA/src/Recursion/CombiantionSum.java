package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombiantionSum {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] candidates = new int[n];
		for(int i=0; i<n; i++) {
			candidates[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(combinationSum(candidates, target));
		sc.close();
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n = candidates.length;
        findCombination(0, target, candidates, ans, ds, n);
        return ans;
    }
    
    public static void findCombination(int idx, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds, int n){
        if(idx == n){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if(arr[idx] <= target){
            ds.add(arr[idx]);
            findCombination(idx, target-arr[idx], arr, ans, ds, n);
            ds.remove(ds.size() - 1);
        }
        
        findCombination(idx + 1, target, arr, ans, ds, n);
    }

}
