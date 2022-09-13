package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NQueens {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<List<String>> queen = PlaceQueen(n);
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

	private static List<List<String>> PlaceQueen(int n) {
		char[][] board = new char[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = '.';
			}
		}
		List<List<String>> ans = new ArrayList<List<String>>();
		Queen(0, board, ans);
		return ans;
	}

	private static void Queen(int col, char[][] board, List<List<String>> ans) {
		
		if(col == board.length) {
			ans.add(construct(board));
			return;
		}
		
		for(int row=0; row<board.length; row++) {
			if(isValidate(row, col, board)) {
				board[row][col] = 'Q';
				Queen(col+1, board, ans);
				board[row][col] = '.';	
			}
		}
	}

	private static List<String> construct(char[][] board) {
		List<String> ds = new LinkedList<String>();
		for(int i=0; i<board.length; i++) {
			String s = new String(board[i]);
			ds.add(s);
		}
		return ds;
	}

	private static boolean isValidate(int row, int col, char[][] board) {
		int dupRow = row;
		int dupCol = col;
		
		while(row>=0 && col >= 0) {
			if(board[row][col] == 'Q') return false;
			row--;
			col--;
		}
		
		row = dupRow;
		col = dupCol;
		
		while(col >= 0) {
			if(board[row][col] == 'Q') return false;
			col--;
		}
		
		row = dupRow;
		col = dupCol;
		
		while(col >= 0 && row < board.length) {
			if(board[row][col] == 'Q') return false;
			col--;
			row++;
		}
		return true;
	}

}
