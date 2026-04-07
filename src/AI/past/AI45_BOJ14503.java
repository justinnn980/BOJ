package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AI45_BOJ14503 {
    static int N, M;
    static int r, c, d;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
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

        Clean();

        System.out.println(result);
    }

    private static void Clean() {
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                result++;
            }

            boolean canClean = false;

            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                    canClean = true;
                    break;
                }
            }
            if (canClean) {
                d = (d + 3) % d;
                int nx = r + dx[d];
                int ny = c + dy[d];
                if (map[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                }

            }else {
                int ax = r - 1;
                int ay = c - 1;
                if (map[ax][ay] == 1){
                    break;
                }
            }
        }
        System.out.println(result);
    }
}


