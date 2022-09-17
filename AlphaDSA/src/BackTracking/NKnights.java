package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NKnights {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<List<String>> queen = PlaceKnights(n);
		int i=1;
		for(List<String> it : queen) {
			System.out.println("Arrangement: " + i);
			for(String p: it) {
				System.out.println(p);
			}
			System.out.println();
			i+=1;
		}
		sc.close();
	}
	
	private static List<List<String>> PlaceKnights(int n) {
		char[][] board = new char[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = '.';
			}
		}
		List<List<String>> ans = new ArrayList<List<String>>();
		Knight(0, board, ans);
		return ans;
	}
	
	private static void Knight(int col, char[][] board, List<List<String>> ans) {
		
		if(col == board.length) {
			ans.add(construct(board));
			return;
		}
		
		for(int row=0; row<board.length; row++) {
			if(isSafe(row, col, board)) {
				board[row][col] = 'K';
				Knight(col+1, board, ans);
				board[row][col] = '.';	
			}
		}
	}
	
	private static boolean isSafe(int row, int col, char[][] board) {
		if(isValid(row - 2, col - 1, board)) {
			if(board[row - 2][col - 1] == 'K') {
				return false;
			}
		}
		
		if(isValid(row - 2, col + 1, board)) {
			if(board[row - 2][col + 1] == 'K') {
				return false;
			}
		}
		
		if(isValid(row - 1, col + 2, board)) {
			if(board[row - 1][col + 2] == 'K') {
				return false;
			}
		}
		
		if(isValid(row - 1, col - 2, board)) {
			if(board[row - 1][col - 2] == 'K') {
				return false;
			}
		}
		return true;
	}

	private static boolean isValid(int row, int col, char[][] board) {
		if(row >= 0 && row < board.length && col >= 0 && col < board[0].length) return true;
		return false;
	}

	private static List<String> construct(char[][] board) {
		List<String> ds = new LinkedList<String>();
		for(int i=0; i<board.length; i++) {
			String s = new String(board[i]);
			ds.add(s);
		}
		return ds;
	}

}
