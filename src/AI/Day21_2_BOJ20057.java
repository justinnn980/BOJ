package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day21_2_BOJ20057 {
    static int N;
    static int[][] map;
    // 좌, 하, 우, 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int sum, sand, spread, amount, alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = N / 2;
        int y = N / 2;
        int len = 1;
        int dir = 0;

        while (true) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < len; j++) {
                    x += dx[dir];
                    y += dy[dir];

                    spread(x, y, dir);

                    if (x == 0 && y == 0) {
                        System.out.println(sum);
                        return;
                    }
                }
                dir = (dir + 1) % 4;
            }
            len++;
        }
    }

    private static void spread(int x, int y, int dir) {
        sand = map[x][y];
        spread = 0;

        if (dir == 0) {
            // 왼쪽 기준
            int[] sx = {-2, -1, -1, -1, 0, 1, 1, 1, 2};
            int[] sy = {0, -1, 0, 1, -2, -1, 0, 1, 0};
            int[] p  = {2, 10, 7, 1, 5, 10, 7, 1, 2};

            int ax = 0;
            int ay = -1;

            // 1. 비율 위치 여러 군데에 퍼뜨리기
            for (int i = 0; i < 9; i++) {
                int nx = x + sx[i];
                int ny = y + sy[i];
                int amount = sand * p[i] / 100;

                // 2. 퍼뜨린 총량 합치기
                spread += amount;

                if (nx<0||ny<0||nx>=N||ny>=N) sum += amount;
                else map[nx][ny] += amount;
            }

            // 3. alpha = sand - spread
            alpha = sand - spread;
            int anx = x + ax;
            int any = y + ay;
            // 4. alpha 위치에 남은 모래 보내기
            if (anx < 0 || any < 0 || anx >= N || any >= N) sum += alpha;
            else map[anx][any] += alpha;

            map[x][y] = 0;
        } else if (dir == 1) {
            // 아래 기준
            int[] sx = {0, 1, 0, -1, 2, 1, 0, -1, 0};
            int[] sy = {-2, -1, -1, -1, 0, 1, 1, 1, 2};
            int[] p  = {2, 10, 7, 1, 5, 10, 7, 1, 2};

            int ax = 1;
            int ay = 0;

            // 1. 비율 위치 여러 군데에 퍼뜨리기
            for (int i = 0; i < 9; i++) {
                int nx = x + sx[i];
                int ny = y + sy[i];
                int amount = sand * p[i] / 100;

                // 2. 퍼뜨린 총량 합치기
                spread += amount;

                if (nx<0||ny<0||nx>=N||ny>=N) sum += amount;
                else map[nx][ny] += amount;
            }

            // 3. alpha = sand - spread
            alpha = sand - spread;
            int anx = x + ax;
            int any = y + ay;
            // 4. alpha 위치에 남은 모래 보내기
            if (anx < 0 || any < 0 || anx >= N || any >= N) sum += alpha;
            else map[anx][any] += alpha;

            map[x][y] = 0;
        } else if (dir == 2) {
            // 오른쪽 기준
            int[] sx = {-2, -1, -1, -1, 0, 1, 1, 1, 2};
            int[] sy = {0, 1, 0, -1, 2, 1, 0, -1, 0};
            int[] p  = {2, 10, 7, 1, 5, 10, 7, 1, 2};

            int ax = 0;
            int ay = 1;

            // 1. 비율 위치 여러 군데에 퍼뜨리기
            for (int i = 0; i < 9; i++) {
                int nx = x + sx[i];
                int ny = y + sy[i];
                int amount = sand * p[i] / 100;

                // 2. 퍼뜨린 총량 합치기
                spread += amount;

                if (nx<0||ny<0||nx>=N||ny>=N) sum += amount;
                else map[nx][ny] += amount;
            }

            // 3. alpha = sand - spread
            alpha = sand - spread;
            int anx = x + ax;
            int any = y + ay;
            // 4. alpha 위치에 남은 모래 보내기
            if (anx < 0 || any < 0 || anx >= N || any >= N) sum += alpha;
            else map[anx][any] += alpha;

            map[x][y] = 0;
        } else {
            // 위 기준
            int[] sx = {0, -1, 0, 1, -2, -1, 0, 1, 0};
            int[] sy = {2, 1, 1, 1, 0, -1, -1, -1, -2};
            int[] p  = {2, 10, 7, 1, 5, 10, 7, 1, 2};

            int ax = -1;
            int ay = 0;

            // 1. 비율 위치 여러 군데에 퍼뜨리기
            for (int i = 0; i < 9; i++) {
                int nx = x + sx[i];
                int ny = y + sy[i];
                int amount = sand * p[i] / 100;

                // 2. 퍼뜨린 총량 합치기
                spread += amount;

                if (nx<0||ny<0||nx>=N||ny>=N) sum += amount;
                else map[nx][ny] += amount;
            }

            // 3. alpha = sand - spread
            alpha = sand - spread;
            int anx = x + ax;
            int any = y + ay;
            // 4. alpha 위치에 남은 모래 보내기
            if (anx < 0 || any < 0 || anx >= N || any >= N) sum += alpha;
            else map[anx][any] += alpha;

            map[x][y] = 0;
        }

    }
}
