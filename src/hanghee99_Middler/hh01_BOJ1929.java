package hanghee99_Middler;

import java.util.Scanner;

public class hh01_BOJ1929 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean[] p = new boolean[n + 1];
        p[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!p[i]) {
                for (int j = i * i; j <= n; j += i) {
                    p[j] = true;
                }
            }
        }
        for (int i = m; i <= n; i++) {
            if (!p[i]) {
                System.out.println(i);
            }
        }
    }
}
