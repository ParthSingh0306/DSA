package DP.DP1D;

import java.util.ArrayList;

public class HouseRobber2 {

	public static void main(String[] args) {
		int[] arr = {1, 5, 1, 2, 6};
		System.out.println(houseRobber(arr));
	}
	
	//same question as max sum of non adjacent element but only first and last element are now adjacent now
	
	public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;
        if(n == 1) return valueInHouse[0];
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            if(i != 0) temp1.add(valueInHouse[i]);
            if(i != n-1) temp2.add(valueInHouse[i]);
        }
        
        return Math.max(rob(temp1), rob(temp2));
	}
	
    public static long rob(ArrayList<Integer> nums) {
        int n = nums.size();
        long prev2 = 0;
        long prev = nums.get(0);
        
        for(int i=1; i<n; i++) {
            long fs = nums.get(i);
            if(i>1) fs += prev2;
            long ss = prev;
            long curr = Math.max(fs, ss);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

}
