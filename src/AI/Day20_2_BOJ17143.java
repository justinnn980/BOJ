package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day20_2_BOJ17143 {
    static int R,C,M;
    static int r,c,s,d,z;
    static int result;
    static Shark[][] map;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            //칸에 상어 넣기
            map[r - 1][c - 1] = new Shark(r - 1, c - 1, s, d, z);
        }

        for (int i = 0; i < C; i++) {
            //R칸에 있는 가장 위 상어 삭제 and 있다면 result += 상어크기
            for (int row = 0; row < R; row++) {
                if (map[row][i] != null) {
                    result += map[row][i].z;
                    map[row][i] = null;
                    break;
                }
            }

            //상어 이동
            moveSharks();
        }

        System.out.println(result);
    }

    private static void moveSharks() {
        Shark[][] next = new Shark[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == null) continue;

                Shark shark = map[i][j];

                int nr = shark.r;
                int nc = shark.c;
                int nd = shark.d;

                int move;
                if (nd == 1 || nd == 2) {
                    move = shark.s % ((R - 1) * 2);
                } else {
                    move = shark.s % ((C - 1) * 2);
                }

                for (int m = 0; m < move; m++) {
                    int tr = nr + dx[nd];
                    int tc = nc + dy[nd];

                    if (tr < 0 || tc < 0 || tr >= R || tc >= C) {
                        // 방향 반전
                        if (nd == 1) nd = 2;
                        else if (nd == 2) nd = 1;
                        else if (nd == 3) nd = 4;
                        else nd = 3;

                        tr = nr + dx[nd];
                        tc = nc + dy[nd];
                    }

                    nr = tr;
                    nc = tc;
                }

                Shark moved = new Shark(nr, nc, shark.s, nd, shark.z);

                if (next[nr][nc] == null) {
                    next[nr][nc] = moved;
                } else {
                    // 큰 상어만 남기기
                    if (next[nr][nc].z < moved.z) {
                        next[nr][nc] = moved;
                    }
                }
            }
        }

        map = next;
    }

    static class Shark {
        int r, c, s, d, z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
