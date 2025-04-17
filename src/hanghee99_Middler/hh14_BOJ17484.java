package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hh14_BOJ17484 {
    static final int INF = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp[i][j][k] : i행 j열에 k방향으로 도착했을 때 최소 연료
        int[][][] dp = new int[n][m][3];

        // 초기값 설정
        for (int j = 0; j < m; j++) {
            for (int d = 0; d < 3; d++) {
                dp[0][j][d] = arr[0][j];
            }
        }

        // DP 계산
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 3; d++) {
                    dp[i][j][d] = INF;
                    for (int prevD = 0; prevD < 3; prevD++) {
                        if (d == prevD) continue; // 같은 방향은 제외

                        int prevJ = j;
                        if (d == 0) prevJ = j + 1;      // ↙ 왔다는 건 이전에 ↘
                        else if (d == 2) prevJ = j - 1; // ↘ 왔다는 건 이전에 ↙

                        if (prevJ < 0 || prevJ >= m) continue;

                        dp[i][j][d] = Math.min(dp[i][j][d], dp[i - 1][prevJ][prevD] + arr[i][j]);
                    }
                }
            }
        }

        // 마지막 행에서 최소값 찾기
        int answer = INF;
        for (int j = 0; j < m; j++) {
            for (int d = 0; d < 3; d++) {
                answer = Math.min(answer, dp[n - 1][j][d]);
            }
        }

        System.out.println(answer);
    }

}
