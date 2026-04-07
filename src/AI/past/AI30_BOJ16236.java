package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AI30_BOJ16236 {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int time;
    static int fishSize = 2;
    static int eatCount = 0;

    static boolean[][] visited;
    static int[][] dist;
    static List<int[]> fishList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        int sx = 0, sy = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = i;
                    sy = j;
                    map[i][j] = 0; // 시작 위치는 빈칸처럼 처리
                }
            }
        }

        solution(sx, sy);
        System.out.println(time);
    }

    private static void solution(int sx, int sy) {
        while (true) {
            int[] target = bfs(sx, sy);

            if (target == null) break;

            int tx = target[0];
            int ty = target[1];
            int d = target[2];

            time += d;
            eatCount++;

            map[tx][ty] = 0; // 먹음
            sx = tx;
            sy = ty;

            if (eatCount == fishSize) {
                fishSize++;
                eatCount = 0;
            }
        }
    }

    private static int[] bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;


        while (!q.isEmpty()) {
            int[] now = q.poll();
            int ax = now[0];
            int ay = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = ax + dx[i];
                int ny = ay + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > fishSize) continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[ax][ay] + 1;
                q.offer(new int[]{nx, ny});

                if (map[nx][ny] != 0 && map[nx][ny] < fishSize) {
                    fishList.add(new int[]{nx, ny, dist[nx][ny]}); // 먹을 물고기 추가
                }
            }
        }
        if (fishList.isEmpty()) return null;

        Collections.sort(fishList, (a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2]; // 거리
            if (a[0] != b[0]) return a[0] - b[0]; // 행
            return a[1] - b[1]; // 열
        });

        return fishList.get(0);

    }
}