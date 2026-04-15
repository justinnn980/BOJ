package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day22_2_BOJ20056 {
    static int N, M, K;
    static int[][] map;
    static int r, c, m, s, d;
    static int result;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        balls = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            balls.add(new Fireball(r - 1, c - 1, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            move();
            merge();
        }

        for (Fireball b : balls) result += b.m;
        System.out.println(result);
    }

    static class Fireball {
        int r, c, m, s, d;

        Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static ArrayList<Fireball> balls;
    static ArrayList<Fireball>[][] board;

    static void move() {
        board = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        for (Fireball cur : balls) {
            int nr = (cur.r + dx[cur.d] * (cur.s % N) + N * 1000) % N;
            int nc = (cur.c + dy[cur.d] * (cur.s % N) + N * 1000) % N;
            board[nr][nc].add(new Fireball(nr, nc, cur.m, cur.s, cur.d));
        }
    }

    static void merge() {
        ArrayList<Fireball> newBalls = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j].size() == 0) continue;

                if (board[i][j].size() == 1) {
                    newBalls.add(board[i][j].get(0));
                    continue;
                }

                int sumM = 0, sumS = 0, cnt = board[i][j].size();
                boolean allEven = true;
                boolean allOdd = true;

                for (Fireball f : board[i][j]) {
                    sumM += f.m;
                    sumS += f.s;
                    if (f.d % 2 == 0) allOdd = false;
                    else allEven = false;
                }

                int nm = sumM / 5;
                if (nm == 0) continue;

                int ns = sumS / cnt;
                int[] nds = allEven || allOdd ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};

                for (int d : nds) {
                    newBalls.add(new Fireball(i, j, nm, ns, d));
                }
            }
        }

        balls = newBalls;
    }
}
