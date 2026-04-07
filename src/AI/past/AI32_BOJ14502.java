package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// makeWall 재귀
// map 복사 + 바이러스 위치 큐에 넣기
// bfs로 copyMap 0을 바이러스(2)로 만들기
// safe수 count

public class AI32_BOJ14502 {
    static int[][] map;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0);

        System.out.println(result);
    }

    private static void makeWall(int count) {
       if (count == 3) {
           spreadVirus();
           return;
       }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(count+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void spreadVirus() {
        Queue<int[]> q = new LinkedList<>();
        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
                if (map[i][j] == 2) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (copyMap[nx][ny] != 0) continue;

                copyMap[nx][ny] = 2;
                q.offer(new int[]{nx,ny});
            }
        }
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safe++;
                }
            }
        }
        result = Math.max(result, safe);
    }


}
