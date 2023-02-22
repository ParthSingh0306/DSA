package PATTERN;

import java.util.Scanner;

public class InvertedHalfPyramid {

    public static void main(String args[]) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > n - i; j--) {
                System.out.print(" ");
            }
            for (int j = n; j >= i; j--) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
