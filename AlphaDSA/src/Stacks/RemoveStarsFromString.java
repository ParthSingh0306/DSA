package Stacks;
//https://leetcode.com/problems/removing-stars-from-a-string/description/
import java.util.Stack;

public class RemoveStarsFromString {

	public static void main(String[] args) {
		String s = "leet**cod*e";
//		String s = "erase*****";
		System.out.println(removeStars(s));
	}
	
    public static String removeStars(String s) {
        Stack<Character> k = new Stack<>();
        int i = 0;
       while(i < s.length()){
            if(s.charAt(i) == '*'){
                k.pop();
            } else{
                k.push(s.charAt(i));
            }
                i++;
       }

        StringBuffer n = new StringBuffer("");

        while(!k.isEmpty()){
            n.append(k.pop());
        }
        n.reverse();
        return n.toString();
    }

}
