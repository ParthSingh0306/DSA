package SegmentTree;

import java.util.Scanner;

public class XeniaBitOperations {
	
	static class segment{
		int[] seg;
		public segment(int n) {
			seg = new int[4*n];
		}
		
		public void build(int ind, int low, int high, int[] arr, boolean orr) {
			if(low == high) {
				seg[ind] = arr[low];
				return;
			}
			int mid = (low + high) / 2;
			build(2*ind + 1, low, mid, arr, !orr);
			build(2*ind + 2, mid+1, high, arr, !orr);
			if(orr) seg[ind] = seg[2*ind + 1] | seg[2*ind + 2];
			else seg[ind] = seg[2*ind + 1] ^ seg[2*ind + 2];
		}
		
		public void update(int ind, int low, int high, int i, int val, boolean orr) {
			if(low == high) {
				seg[ind] = val;
				return;
			}
			int mid = (low + high) >> 1;
			if(i <= mid) update(2*ind + 1, low, mid, i, val, !orr);
			else update(2*ind + 2, mid+1, high, i, val, !orr);
			if(orr) seg[ind] = seg[2*ind + 1] | seg[2*ind + 2];
			else seg[ind] = seg[2*ind + 1] ^ seg[2*ind + 2];
		}	
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), q = sc.nextInt();
		int el = (int) Math.pow(2, n);
		int[] arr = new int[el];
		for(int i=0; i<el; i++) arr[i] = sc.nextInt();
		
		segment sg = new segment(el);
		if(n%2 == 0) sg.build(0, 0, el-1, arr, false);
		else sg.build(0, 0, el-1, arr, true);
		
		while(q-->0) {
			int i = sc.nextInt(), val = sc.nextInt();
			i--;
			if(n % 2 == 0) sg.update(0, 0, el - 1, i, val, false);
			else sg.update(0, 0, el-1, i, val, true);
			arr[i] = val;
			System.out.println(sg.seg[0]);
		}
		sc.close();
	}
}
