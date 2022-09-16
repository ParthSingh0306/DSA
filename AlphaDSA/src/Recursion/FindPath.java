package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPath {

	static Scanner sc =  new Scanner(System.in);
	static int n = sc.nextInt();
	static int m = sc.nextInt();
	
	public static void main(String[] args) {
		List<Character> ds = new ArrayList<>();
		List<List<Character>> ans = new ArrayList<>();
		
		findPath(0, 0, ds, ans);
		System.out.println(ans);
		
		findPath2(0, 0, new StringBuilder(""));
		
		System.out.println(findPath3(0, 0));
		sc.close();
	}

	private static void findPath(int i, int j, List<Character> ds, List<List<Character>> ans) {
		if(i >= n || j >= m) return;
		
		if(i == n-1 && j == m-1) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		
		ds.add('D');
		findPath(i+1, j, ds, ans);
		ds.remove(ds.size()-1);
		
		ds.add('R');
		findPath(i, j+1, ds, ans);
		ds.remove(ds.size()-1);
	}
	
//	 With StringBuilder
	
	private static void findPath2(int i, int j, StringBuilder sb) {
		if(i >= n || j >= m) return;
		
		if(i == n-1 && j == m-1) {
			System.out.println(sb);
			return;
		}
		
		sb.append('D');
		findPath2(i+1, j, sb);
		sb.deleteCharAt(sb.length()-1);
		
		sb.append('R');
		findPath2(i, j+1, sb);
		sb.deleteCharAt(sb.length()-1);
		
	}
	
//	To find no. of paths
	
	private static int findPath3(int i, int j) {
		if(i >= n || j >= m) return 0;
		
		if(i == n-1 && j == m-1) {
			return 1;
		}
		
		return findPath3(i+1, j) + findPath3(i, j+1);
		
	}
	

}
