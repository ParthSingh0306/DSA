package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromicPartitioning {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String s = sc.next();
		System.out.println(partition(s));
		sc.close();
	}

	public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        func(s, 0, path, res);
        return res;
    }
    
    public static void func(String s, int idx, ArrayList<String> path, List<List<String>> res) {
        if(idx == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=idx; i<s.length(); i++) {
            if(isPalindromic(s, idx, i)) {
                path.add(s.substring(idx, i+1));
                func(s, i+1, path, res);
                path.remove(path.size()-1);
            }
        }
    }
    
    public static boolean isPalindromic(String s, int start, int end){
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
