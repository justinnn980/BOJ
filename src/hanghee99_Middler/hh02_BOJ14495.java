package hanghee99_Middler;

import java.util.Scanner;

public class hh02_BOJ14495 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[117];
        dp[1] = dp[2] = dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-3];
        }
        System.out.print(dp[n]);


    }
}