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

import java.util.*;

public class Main
{
	public static void main(String[] args) {
		int n = 4;
	        int[] arr = {1, 2, 3, 0};
	        sgt sg = new sgt(4);
	        sg.build(0, 0, n-1, arr);
	        System.out.println(sg.query(0, 0, n-1, 0, 2));
	        sg.update2(0, 0, n-1, 0, 2, 2);
	        System.out.println(sg.query(0, 0, n-1, 0, 2));
	}
}

class sgt {
    static class Node {
        int sum;
        int lazy;
        
        Node() {
            this.sum = 0;
            this.lazy = 0;
        }
        
    }
    
    Node[] seg;
    
    sgt(int n) {
        seg = new Node[4*n];
        for(int i=0; i<4*n; i++) seg[i] = new Node();
    }
    
    void push(int ind, int l, int r) {
        if(seg[ind].lazy != 0) {
            seg[ind].sum += (r - l + 1) * seg[ind].lazy;
            
            if(l != r) {
                seg[2*ind+1].sum += seg[ind].lazy;
                seg[2*ind+2].sum += seg[ind].lazy;
            }
            
            seg[ind].lazy = 0;
        }
    }
    
    void build(int ind, int low, int high, int[] arr) {
        if(low == high) {
            seg[ind].sum = arr[low];
            seg[ind].lazy = 0;
            return;
        }
        
        int mid = (low + high) / 2;
        build(2*ind+1, low, mid, arr);
        build(2*ind+2, mid+1, high, arr);
        seg[ind].sum = seg[2*ind+1].sum + seg[2*ind+2].sum;
    }
    
    void update2(int ind, int low, int high, int l, int h, int val) {
        push(ind, low, high);
        if(h < low || high < l) return;
	if(low >= l && high <= h) {
	    seg[ind].lazy += val;
	    push(ind, low, high);
	    return;
	}
	
	int mid = (low + high) / 2;
	update2(2*ind + 1, low, mid, l, h, val);
	update2(2*ind + 2, mid+1, high, l, h, val);
    }
    
    void update(int ind, int l, int r, int i, int val) {
        if(l == r) {
            seg[ind].sum = val;
            return;
        }
        
        int mid = (l + r) / 2;
        if(i <= mid) update(2*ind+1, l, mid, i, val);
        else update(2*ind+2, mid+1, r, i, val);
        seg[ind].sum = seg[2*ind+1].sum + seg[2*ind+2].sum;
    }
    
    int query(int ind, int low, int high, int l, int h) {
        if(h < low || high < l) return 0;
			
	if(low >= l && high <= h) return seg[ind].sum;
	
	int mid = (low + high) / 2;
	int left = query(2*ind + 1, low, mid, l, h);
	int right = query(2*ind + 2, mid+1, high, l, h);
	return left + right;
    }
}
