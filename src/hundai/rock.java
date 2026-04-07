package hundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class rock {
    static int h, w, k;
    static int[] low, high;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        low = new int[w + 1];
        high = new int[w + 1];

        for (int i = 0; i <= w; i++) {
            low[i] = -1;
            high[i] = -1;
        }

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            low[x] = a;
            high[x] = b;
        }

        System.out.println(solve());
    }

    static long solve() {
        dp = new long[w + 1][h + 1];

        int startY = h / 2;
        dp[0][startY] = 1;

        for (int x = 0; x < w; x++) {
            for (int y = 1; y <= h - 1; y++) {
                if (dp[x][y] == 0) continue;

                // 1) 점프: y + 1
                int ny1 = y + 1;
                if (isValid(x + 1, ny1)) {
                    dp[x + 1][ny1] += dp[x][y];
                }

                // 2) 활강: y - 2
                int ny2 = y - 2;
                if (isValid(x + 1, ny2)) {
                    dp[x + 1][ny2] += dp[x][y];
                }
            }
        }

        long answer = 0;
        for (int y = 1; y <= h - 1; y++) {
            answer += dp[w][y];
        }
        return answer;
    }

    static boolean isValid(int x, int y) {
        // 공간 밖
        if (y <= 0 || y >= h) return false;

        // 장애물 없음
        if (low[x] == -1) return true;

        // 장애물 있음: a < y < b
        return low[x] < y && y < high[x];
    }
}