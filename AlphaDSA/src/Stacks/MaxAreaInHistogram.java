package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class MaxAreaInHistogram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] heights = {2, 1, 5, 6, 2, 3};
		System.out.println(largestRectangleArea1(heights));
		System.out.println(largestRectangleArea2(heights));
		System.out.println(largestRectangleArea3(heights));
		sc.close();
	}
	
	public static int largestRectangleArea1(int[] heights) {
		int n = heights.length;
		int maxA = 0;
		for(int i=0; i<n; i++) {
			int minHeight = Integer.MAX_VALUE;
			for(int j=i; j<n; j++) {
				minHeight = Math.min(minHeight, heights[j]);
				maxA = Math.max(maxA, minHeight * (j - i + 1));
			}
		}
		return maxA;
	}
	
    public static int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] leftsmall = new int[n];
        int[] rightsmall = new int[n];

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.isEmpty()) leftsmall[i] = 0;
            else leftsmall[i] = st.peek() + 1;
            st.push(i);
        }

        while(!st.isEmpty()) st.pop();

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.isEmpty()) rightsmall[i] = n-1;
            else rightsmall[i] = st.peek() - 1;
            st.push(i);
        }

        int maxA = 0;
        for(int i=0; i<n; i++) {
            maxA = Math.max(maxA, (rightsmall[i] - leftsmall[i] + 1 ) * heights[i]);
        }
        return maxA;
    }
    
    public static int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxA = 0;
        for(int i=0; i<=n; i++) {
            while(!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()) width = i;
                else width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return  maxA;
    }

}
