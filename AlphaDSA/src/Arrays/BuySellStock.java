package Arrays;

import java.util.Scanner;

public class BuySellStock {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		   int n = sc.nextInt();
		   int[] prices = new int[n];
		   for(int i=0; i<n; i++) {
			   prices[i] = sc.nextInt();
		   }
		   System.out.println(profit(prices));
	}
	
	public static int profit(int[] prices) {
		int n = prices.length;
		int min = prices[0];
		int maxprofit = 0;
		for(int i=1; i<n; i++) {
			int profit = prices[i] - min;
			maxprofit = Math.max(maxprofit, profit);
			min = Math.min(min, prices[i]);
		}
		return maxprofit;
	}

}
