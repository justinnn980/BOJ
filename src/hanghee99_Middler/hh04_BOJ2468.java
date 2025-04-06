package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hh04_BOJ2468 {

    static int n;
    static int[][] arr;
    static boolean[][] checked;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < n; j++) {
                String[] s = input.split(" ");
                arr[i][j] = Integer.parseInt(s[j]);
                if (arr[i][j] > maxHeight) {
                    maxHeight = arr[i][j];
                }
            }
        }
        int max = 0;
        ///1. 모든 지역 탐색
        for (int h = 0; h < maxHeight + 1; h++) {
            checked = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 2. 안전 영역 탐지
                    if (!checked[i][j] && arr[i][j] > h) {
                        cnt += dfs(i, j, h); // 해당 안전영역 탐색 시작
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    private static int dfs(int x, int y, int h) {
        checked[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1) {
                continue;
            }
            if (checked[nx][ny]) {
                continue;
            }
            if (arr[nx][ny] > h) {
                dfs(nx, ny, h);
            }
        }
        return 1;
    }
}
