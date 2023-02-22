package PATTERN;

import java.util.Scanner;

public class PascalsPyramid {

    public static void main(String args[]) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            int C = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(C + " ");
                C = C * (i - j) / j;
            }
            System.out.println();
        }
    }
}
