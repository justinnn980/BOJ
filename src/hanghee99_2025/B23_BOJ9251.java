package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B23_BOJ9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int n = A.length();
        int m = B.length();

        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int prev = 0;
            for (int j = 1; j <= m; j++) {
                int temp = dp[j]; // dp[i-1][j]
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[j] = prev + 1;          // dp[i-1][j-1] + 1
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }

        System.out.println(dp[m]);
    }
}
