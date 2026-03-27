package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AI42_BOJ14503 {
    static int N, M;
    static int r, c, d;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}; //북 남
    static int[] dy = {0, 1, 0, -1}; //동 서
    static int clean = 0;

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

        System.out.println(clean);
    }

    private static void Clean() {
        while (true) {
            //현재칸 청소
            if (map[r][c] == 0) {
                map[r][c] = 2;
                clean++;
            }
            // 2. 주변 4칸 중 청소 안 된 빈 칸 있는지 확인
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
                // 3. 회전
                d = (d + 3) % 4;
                // 4. 앞칸 확인
                int nx = r + dx[d];
                int ny = c + dy[d];

                // 5. 청소 안 된 빈 칸이면 전진
                if (map[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                }

            } else {
                // 6. 후진
                int bx = r - dx[d];
                int by = c - dy[d];

                // 7. 뒤가 벽이면 종료
                if (map[bx][by] == 1) break;

                // 8. 아니면 후진
                r = bx;
                c = by;
            }
        }
    }
}
