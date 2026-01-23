package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B24_BOJ2225 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[k+1][n+1];

        for (int j = 0; j <= n; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= k; i++) {
            dp[i][0] = 1; // 합이 0이면 전부 0만 쓰는 1가지
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD;
            }
        }

        System.out.println(dp[k][n] % MOD);
    }

}
