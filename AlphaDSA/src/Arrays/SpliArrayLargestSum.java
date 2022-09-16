package Arrays;

import java.util.Scanner;

public class SpliArrayLargestSum {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		System.out.println(splitArray(arr, m));
		sc.close();
	}
	
    public static int splitArray(int[] nums, int m) {
        int start = 0;
        for(int i=0; i<nums.length; i++){
            start = Math.max(start, nums[i]);
        }
        
        int end = 0;
        for(int i=0; i<nums.length; i++){
            end += nums[i];
        }
        
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(noOfSubArrays(nums, nums.length, mid, m) == false){
                start = mid + 1;
            }
            else{
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
    
    public static boolean noOfSubArrays(int[] nums, int n, int limit, int m){
        int cnt = 1;
        int sum = 0;
        for(int i=0; i<n; i++){
            if(nums[i] > limit) return false;
            if(nums[i] + sum > limit){
                cnt++;
                sum = nums[i];
            }else{
                sum += nums[i];
            }
        }
        return cnt <= m;
    }

}
