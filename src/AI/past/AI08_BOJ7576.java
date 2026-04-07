package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AI08_BOJ7576 {
    static int M, N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 초기에 익은 토마토 큐에 넣기
                if(map[i][j] == 1){
                    q.offer(new int[]{i, j});
                }
            }
        }

        System.out.println(sol());
    }

    private static int sol() {
        BFS();
        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // TODO: 안 익은 토마토 남아있으면 -1 출력 후 종료
                if (map[i][j] == 0) {
                    return -1;
                }
                // TODO: max 갱신
                max = Math.max(max, map[i][j]);
            }
        }

        return max - 1;
    }

    private static void BFS() {
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d]; // 옆 토마토
                int ny = y + dy[d];

                // 1. 범위 체크
                if (nx<0 || ny<0 || nx>=N||ny>=M) continue;
                // 2. 안 익은 토마토인지 체크
                if (map[nx][ny] !=0) continue;
                // 3. 날짜 갱신
                map[nx][ny] = map[x][y] + 1; // 전 토마토의 하루 뒤
                // 4. 큐에 넣기
                q.offer(new int[]{nx, ny});

            }
        }
    }
}