package hanghee99;

import java.util.Scanner;

public class hh03_BOJ2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int r = sc.nextInt();
            String s = sc.next();;
            char[] str = s.toCharArray();

            for (int j = 0; j < str.length; j++) {
                for (int k = 0; k < r; k++) {
                    System.out.print(str[j]);
                }
            }
            System.out.println();
        }
    }
}
