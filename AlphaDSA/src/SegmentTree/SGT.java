package SegmentTree;

import java.util.Scanner;

public class SGT {
	
	static class segment{
		int[] seg;
		public segment(int n) {
			seg = new int[4*n];
		}
		
		public void build(int ind, int low, int high, int[] arr) {
			if(low == high) {
				seg[ind] = arr[low];
				return;
			}
			int mid = (low + high) / 2;
			build(2*ind + 1, low, mid, arr);
			build(2*ind + 2, mid+1, high, arr);
			seg[ind] = Math.min(seg[2*ind + 1], seg[2*ind + 2]);
		}
		
		public int query(int ind, int low, int high, int l, int r) {
			if(r < low || high < l) return Integer.MAX_VALUE;
			
			if(low >= l && high <= r) return seg[ind];
			
			int mid = (low + high) / 2;
			int left = query(2*ind + 1, low, mid, l, r);
			int right = query(2*ind + 2, mid+1, high, l, r);
			return Math.min(left, right);
		}
		
		public void update(int ind, int low, int high, int i, int val) {
			if(low == high) {
				seg[ind] = val;
				return;
			}
			int mid = (low + high) >> 1;
			if(i <= mid) update(2*ind + 1, low, mid, i, val);
			else update(2*ind + 2, mid+1, high, i, val);
			seg[ind] = Math.min(seg[2*ind + 1], seg[2*ind + 2]);
		}	
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), q = sc.nextInt();;
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		segment sg1 = new segment(n);
		sg1.build(0, 0, n-1, arr);
		while(q-->0) {
			int type = sc.nextInt();
			if(type == 1) {
				int l = sc.nextInt(), r= sc.nextInt();
				System.out.println(sg1.query(0, 0, n-1, l, r));
			}
			else {
				int i = sc.nextInt(), val = sc.nextInt();
				sg1.update(0, 0, n-1, i, val);
				arr[i] = val;
			}
		}
		sc.close();
	}
}


// For lazy and Node template

public class MyClass {
  public static void main(String args[]) {
    int n = 4;
    int[] arr = {1, 2, 3, 0};
    sgt sg = new sgt(4);
    sg.build(0, 0, n-1, arr);
    System.out.println(sg.query(0, 0, n-1, 0, 3));
  }
}

class sgt {
    static class Node {
        int min;
        int lazy;
        
        Node() {
            this.min = Integer.MAX_VALUE;
            this.lazy = 0;
        }
        
    }
    
    Node[] seg;
    
    sgt(int n) {
        seg = new Node[4*n];
        for(int i=0; i<4*n; i++) seg[i] = new Node();
    }
    
    void build(int ind, int low, int high, int[] arr) {
        if(low == high) {
            seg[ind].min = arr[low];
            return;
        }
        
        int mid = (low + high) / 2;
        build(2*ind+1, low, mid, arr);
        build(2*ind+2, mid+1, high, arr);
        seg[ind].min = Math.min(seg[2*ind+1].min, seg[2*ind+2].min);
    }
    
    int query(int ind, int low, int high, int l, int h) {
        if(h < low || high < l) return Integer.MAX_VALUE;
			
		if(low >= l && high <= h) return seg[ind].min;
		
		int mid = (low + high) / 2;
		int left = query(2*ind + 1, low, mid, l, h);
		int right = query(2*ind + 2, mid+1, high, l, h);
		return Math.min(left, right);
    }
}
