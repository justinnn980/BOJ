package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AI25_BOJ14503 {
    static int N, M;
    static int r, c, d;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solution();
        System.out.println(result);
    }

    private static void Solution() {
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                result++;
            }

            boolean moved = false;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (map[nx][ny] == 0) {
                    r = nx; // 청소되지 않은 칸으로 한칸 전진
                    c = ny;
                    moved = true;
                    break;
                }
            }

            if (moved) continue; //이미 이동했으면, 이번 턴은 끝났으니까 다음 턴으로 넘어가라

            int back = (d + 2) % 4;
            int bx = r + dx[back];
            int by = c + dy[back];

            if (map[bx][by] == 1) {
                return;
            } else {
                r = bx;
                c = by;
            }
        }
    }
}
