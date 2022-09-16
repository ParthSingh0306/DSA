package BackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class FindPathObstacles {

	static Scanner sc =  new Scanner(System.in);
	static int n = sc.nextInt();
	static int m = sc.nextInt();
	
	public static void main(String[] args) {
		boolean[][] board = {
				{true, true, true},
				{true, true, true},
				{true, true, true}
		};
		int[][] path = new int[board.length][board[0].length];
		findPath2(0, 0, new StringBuilder(""), board);
		findPath4(0, 0, new StringBuilder(""), board);
		findPath5(0, 0, new StringBuilder(""), board, path, 1);
	}
	
	private static void findPath2(int i, int j, StringBuilder sb, boolean[][] board) {
		if(i >= n || j >= m) return;
		
		if(i == n-1 && j == m-1) {
			System.out.println(sb);
			return;
		}
		
		if(!board[i][j]) return;
		
		sb.append('D');
		findPath2(i+1, j+1, sb, board);
		sb.deleteCharAt(sb.length()-1);
		
		sb.append('V');
		findPath2(i+1, j, sb, board);
		sb.deleteCharAt(sb.length()-1);
		
		sb.append('H');
		findPath2(i, j+1, sb, board);
		sb.deleteCharAt(sb.length()-1);
		
	}
	
	private static void findPath4(int i, int j, StringBuilder sb, boolean[][] board) {
		if(i < 0 || i >= n || j >= m || j < 0 || board[i][j] == false) return;
		
		if(i == n-1 && j == m-1) {
			System.out.println(sb);
			return;
		}
		
		board[i][j] = false;
		
		if(i < n) {
			sb.append('D');
			findPath4(i+1, j, sb, board);
			sb.deleteCharAt(sb.length()-1);
		}
		
		if(j > 0) {
			sb.append('L');
			findPath4(i, j-1, sb, board);
			sb.deleteCharAt(sb.length()-1);
		}
		
		if(j < m) {
			sb.append('R');
			findPath4(i, j+1, sb, board);
			sb.deleteCharAt(sb.length()-1);
		}
		
		if(i > 0) {
			sb.append('U');
			findPath4(i-1, j, sb, board);
			sb.deleteCharAt(sb.length()-1);
		}
		board[i][j] = true;
	}
	
	private static void findPath5(int i, int j, StringBuilder sb, boolean[][] board, int[][] path, int step) {
		if(i < 0 || i >= n || j >= m || j < 0 || board[i][j] == false) return;
		
		if(i == n-1 && j == m-1) {
			path[i][j] = step;
			
			for(int[] arr : path) {
				System.out.println(Arrays.toString(arr));
			}
			System.out.println(sb);
			System.out.println();
			return;
		}
		
		board[i][j] = false;
		path[i][j] = step;
		
		if(i < n) {
			sb.append('D');
			findPath5(i+1, j, sb, board, path, step+1);
			sb.deleteCharAt(sb.length()-1);
		}
		
		if(j > 0) {
			sb.append('L');
			findPath5(i, j-1, sb, board, path, step+1);
			sb.deleteCharAt(sb.length()-1);
		}
		
		if(j < m) {
			sb.append('R');
			findPath5(i, j+1, sb, board, path, step+1);
			sb.deleteCharAt(sb.length()-1);
		}
		
		if(i > 0) {
			sb.append('U');
			findPath5(i-1, j, sb, board, path, step+1);
			sb.deleteCharAt(sb.length()-1);
		}
		
		board[i][j] = true;
		path[i][j] = 0;
	}

}
