package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class AI38_BOJ13460 {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int rx, ry, bx, by;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);

                if (c == '#') map[i][j] = '#';
                else if (c == '.') map[i][j] = '.';
                else if (c == 'O') map[i][j] = 'O';
                else if (c == 'R') {
                    rx = i;
                    ry = j;
                    map[i][j] = '.';
                } else if (c == 'B') {
                    bx = i;
                    by = j;
                    map[i][j] = '.';
                }
            }
        }
        Sol();
    }

    private static void Sol() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][M][N][M];

        q.offer(new int[]{rx, ry, bx, by, 0});
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int crx = cur[0];
            int cry = cur[1];
            int cbx = cur[2];
            int cby = cur[3];
            int depth = cur[4];

            if (depth >= 10) continue;

            for (int dir = 0; dir < 4; dir++){
                int[] red = move(crx, cry, dir);
                int[] blue = move(cbx, cby, dir);

                int nrx = red[0];
                int nry = red[1];
                int rCnt = red[2];

                int nbx = blue[0];
                int nby = blue[1];
                int bCnt = blue[2];

                if (map[nbx][nby] == 'O') continue;
                if (map[nrx][nry] == 'O') {
                    System.out.println(depth + 1);
                    return;
                }

                if (nrx == nbx && nry == nby) {
                    if (rCnt > bCnt) {
                        nrx -= dx[dir];
                        nry -= dy[dir];
                    } else {
                        nbx -= dx[dir];
                        nby -= dy[dir];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.offer(new int[]{nrx, nry, nbx, nby, depth + 1});
                }

            }
            System.out.println(-1);
        }
    }

    private static int[] move(int x, int y, int dir) {
        int cnt = 0;

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 벽이면 멈춤
            if (map[nx][ny] == '#') break;

            x = nx;
            y = ny;
            cnt++;

            // 구멍이면 멈춤
            if (map[x][y] == 'O') break;
        }
        return new int[]{x, y, cnt};
    }
}
