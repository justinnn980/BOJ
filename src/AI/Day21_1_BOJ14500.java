package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day21_1_BOJ14500 {
    static int N, M;
    static int[][] map;
    static boolean[][] vis;
    static int max;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        vis = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Sol();

        System.out.println(max);
    }

    private static void Sol() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 1) (i,j)에서 시작하는 DFS 깊이 4
                vis[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                vis[i][j] = false;

                // 2) (i,j)를 중심으로 하는 ㅗ 모양 처리
                checkT(i, j);
            }
        }
    }

    private static void checkT(int i, int j) {
        int low = Integer.MAX_VALUE;
        int Tmax = map[i][j];
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (vis[nx][ny]) continue;

            cnt++;
            Tmax += map[nx][ny];
            low = Math.min(low, map[nx][ny]);
        }
        if (cnt == 4) {
            Tmax -= low;
            max = Math.max(max, Tmax);
        } else if (cnt == 3) {
            max = Math.max(max, Tmax);
        } else if (cnt < 3) {
            return;
        }

    }

    private static void dfs(int i, int j, int depth, int value) {

        if (depth == 4) {
            max = Math.max(max, value);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (vis[nx][ny]) continue;

            vis[nx][ny] = true;
            dfs(nx, ny, depth + 1, value + map[nx][ny]);
            vis[nx][ny] = false;
        }

    }
}
