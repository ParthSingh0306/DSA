package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSum2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] candidates = new int[n];
		for(int i=0; i<n; i++) {
			candidates[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(combinationSum2(candidates, target));
		sc.close();
	}
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0, target, candidates, ans, ds);
        return ans;
    }
    
    public static void findCombination(int idx, int target, int[] arr,List<List<Integer>> ans, List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=idx; i<arr.length; i++){
            if(i > idx && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            
            ds.add(arr[i]);
            findCombination(i+1, target-arr[i], arr, ans, ds);
            ds.remove(ds.size() - 1);
        }
        
    }

}
