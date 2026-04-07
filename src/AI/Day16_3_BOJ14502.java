package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day16_3_BOJ14502 {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxSafe;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makewall(0);

        System.out.println(maxSafe);
    }

    private static void makewall(int i) {
        if (i == 3) {
            spreadvirus();
            return;
        }

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if (map[j][k] == 0) {
                    map[j][k] = 1;
                    makewall(i + 1);
                    map[j][k] = 0;
                }
            }
        }
    }

    private static void spreadvirus() {
        int[][] copyMap = new int[N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
                if (copyMap[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (copyMap[nx][ny] != 0) continue;

                copyMap[nx][ny] = 2;
                q.offer(new int[]{nx, ny});
            }
        }
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safe++;
                }
            }
        }
        maxSafe = Math.max(maxSafe, safe);
    }


}
