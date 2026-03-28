package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AI44_BOJ16236 {
    static int N;
    static int[][] map;
    static int time, eatCount;
    static int SharkSize = 2;
    static ArrayList<int[]> arr = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        int x = 0;
        int y = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    x = i;
                    y = j;
                }
            }
        }

        while (true) {
            int[] fish = bfs(x, y);

            if (fish == null) break;

            int nx = fish[0];
            int ny = fish[1];
            int d = fish[2];

            map[x][y] = 0;   // 현재 위치 비우고
            x = nx;
            y = ny;
            map[x][y] = 0;   // 먹은 자리도 빈칸 처리

            eatCount++;
            time += d;

            if (SharkSize == eatCount) {
                eatCount = 0;
                SharkSize++;
            }
        }
        System.out.println(time);
    }

    private static int[] bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        int[][] dist = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        visited[x][y] = true;
        dist[x][y] = 0;

        int[] best = null;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ax = cur[0];
            int ay = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = ax + dx[i];
                int ny = ay + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > SharkSize) continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                dist[nx][ny] = dist[ax][ay] + 1;

                if (0 < map[nx][ny] && map[nx][ny] < SharkSize) {
                    if (best == null) {
                        best = new int[]{nx, ny, dist[nx][ny]};
                    } else {
                        if (dist[nx][ny] < best[2]) {
                            best = new int[]{nx, ny, dist[nx][ny]};
                        } else if (dist[nx][ny] == best[2]) {
                            if (nx < best[0]) {
                                best = new int[]{nx, ny, dist[nx][ny]};
                            } else if (nx == best[0] && ny < best[1]) {
                                best = new int[]{nx, ny, dist[nx][ny]};
                            }
                        }
                    }
                }
            }
        }
        return best;
    }
}
