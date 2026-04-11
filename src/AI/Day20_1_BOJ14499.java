package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day20_1_BOJ14499 {
    static int N, M, x, y, K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = new int[6];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int cmd = Integer.parseInt(st.nextToken());

            int nx = x;
            int ny = y;

            if (cmd == 1) ny++;
            else if (cmd == 2) ny--;
            else if (cmd == 3) nx--;
            else if (cmd == 4) nx++;

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            if (cmd == 1) rollEast(dice);
            else if (cmd == 2) rollWest(dice);
            else if (cmd == 3) rollNorth(dice);
            else rollSouth(dice);

            x = nx;
            y = ny;

            if (map[x][y] == 0) {
                map[x][y] = dice[1];
            } else {
                dice[1] = map[x][y];
                map[x][y] = 0;
            }

            System.out.println(dice[0]);
        }
    }

    private static void rollSouth(int[] dice) {
        int top = dice[0];
        int bottom = dice[1];
        int north = dice[2];
        int south = dice[3];

        dice[0] = south;
        dice[1] = north;
        dice[2] = top;
        dice[3] = bottom;
    }

    private static void rollNorth(int[] dice) {
        int top = dice[0];
        int bottom = dice[1];
        int north = dice[2];
        int south = dice[3];

        dice[0] = north;
        dice[1] = south;
        dice[2] = bottom;
        dice[3] = top;
    }

    private static void rollWest(int[] dice) {
        int top = dice[0];
        int bottom = dice[1];
        int west = dice[4];
        int east = dice[5];

        // 동쪽으로 굴린 뒤
        dice[0] = west;
        dice[1] = east;
        dice[4] = bottom;
        dice[5] = top;
    }

    private static void rollEast(int[] dice) {
        int top = dice[0];
        int bottom = dice[1];
        int west = dice[4];
        int east = dice[5];

        dice[0] = east;    // 위가 동쪽
        dice[1] = west;    // 서쪽이 바닥으로
        dice[4] = top;     // 위가 서쪽으로
        dice[5] = bottom;  // 바닥이 동쪽으로
    }
}
