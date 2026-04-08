package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day17_1_BOJ2636 {
    static int N, M;
    static int[][] map;
    static int time, piece;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q;
    static ArrayList<int[]> a;
    static boolean[][] vis;

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

        System.out.println(time);
        System.out.println(piece);
    }

    private static void Sol() {
        while (true) {
            bfs();

            if (a.isEmpty()) break;

            piece = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        piece++;
                    }
                }
            }

            for (int[] q : a) {
                map[q[0]][q[1]] = 0;
            }

            time++;
        }

    }

    private static void bfs() {
        q = new LinkedList<>();
        a = new ArrayList<>();
        vis = new boolean[N][M];

        q.offer(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (vis[nx][ny]) continue;

                if (map[nx][ny] == 0) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                } else {
                    vis[nx][ny] = true;
                    a.add(new int[]{nx, ny});
                }
            }
        }
    }
}
