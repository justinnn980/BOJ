package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hh06_BOJ4963 {

    static int[][] arr;
    static boolean[][] visit;
    static int[] dirX = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dirY = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int w, h, nowX, nowY;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str;

        while (!(str = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(str);

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new int[h][w];
            visit = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int island_count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visit[i][j] && arr[i][j] == 1) {
                        island_count++;
                        DFS(i, j);
                    }
                }
            }

            sb.append(island_count).append('\n');  // while 루프마다 append
        }

        System.out.println(sb);  // 전체 출력
    }

    static void DFS(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 8; i++) {
            nowX = dirX[i] + x;
            nowY = dirY[i] + y;

            if (range_check() && !visit[nowX][nowY] && arr[nowX][nowY] == 1) {
                DFS(nowX, nowY);
            }
        }
    }

    static boolean range_check() {
        return (nowX >= 0 && nowY >= 0 && nowX < h && nowY < w);
    }
}
