package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B10_BOJ2573 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int result = 0;

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int components = countComponents();

            if (components >= 2) {
                System.out.println(result);
                return;
            }
            if (components == 0) {
                System.out.println(0);
                return;
            }

            meltOneYear();
            result++;
        }
    }

        // 빙산 덩어리 개수 세기
        static int countComponents() {
            visited = new boolean[n][m];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        static void dfs(int x, int y) {
            visited[x][y] = true;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (map[nx][ny] > 0 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }


        // 1년치 녹이기 (동시 적용)
        static void meltOneYear() {
            int[][] dec = new int[n][m];

            // 감소량 계산
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) continue;

                    int sea = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if (map[nx][ny] == 0) sea++;
                    }
                    dec[i][j] = sea;
                }
            }

            // 한 번에 적용
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > 0) {
                        map[i][j] = Math.max(0, map[i][j] - dec[i][j]);
                    }
                }
            }
    }

}
