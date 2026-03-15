package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AI22_BOJ14503 {
    static int N,M;
    static int[][] map;
    static int r,c,d;
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
        Solution();
        System.out.println(result);

    }

    private static void Solution() {
        // 0 청소 안된칸, 1 벽, 2 청소완료

        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                result++;
            }
            //왼쪽 회전
            boolean moved = false;
            // 2. 주변 4칸 중 청소 안 된 칸 있는지 확인(중요)
            for (int i = 0; i <4 ; i++) {
                //반시계 방향으로 90도 회전
                d = (d + 3) % 4;
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 앞칸이 청소 안 된 칸이면 전진
                if (map[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }
            }
            // 3. 4방향 다 못갔면 뒤로 가기
            if (!moved) {
                // 뒤로 한 칸 후진
                int bx = r - dx[d];
                int by = c - dy[d];

                // 뒤가 벽이면 종료
                if (bx < 0 || by < 0 || bx >= N || by >= M || map[bx][by] == 1) {
                    break;
                }

                r = bx;
                c = by;
            }

        }
    }
}