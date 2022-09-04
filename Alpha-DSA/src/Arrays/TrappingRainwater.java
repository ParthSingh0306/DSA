package Arrays;

import java.util.Scanner;

public class TrappingRainwater {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		   int n = sc.nextInt();
		   int[] ans = new int[n];
		   for(int i=0; i<n; i++) {
			   ans[i] = sc.nextInt();
		   }
		   System.out.println(trap(ans));
	}
	
    public static int trap(int[] height) {
        int n = height.length;
        int water = 0;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = n-1;
        
        while(l <= r){
            if(height[l] <= height[r]){
                if(height[l] >= leftMax) leftMax = height[l];
                else{
                    water += leftMax - height[l];
                }
                l++;
            }
            else{
                if(height[r] >= rightMax) rightMax = height[r];
                else{
                    water += rightMax - height[r];
                }
                r--;
            }
        }
        return water;
    }

}
