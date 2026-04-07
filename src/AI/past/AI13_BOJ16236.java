package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AI13_BOJ16236 {
    static int N;
    static int[][] map, start;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int sharkSize = 2;
    static int eat = 0;
    static int time = 0;
    static int sx, sy;
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

        System.out.println(sol(N, map));
    }

    private static int sol(int n, int[][] map) {
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 9){
                    sx = i;
                    sy = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            int[] fish = bfs(sx, sy);

            if (fish == null) break;

            sx = fish[0];
            sy = fish[1];
            time += fish[2];
            map[sx][sy] = 0;

            eat++;
            if (eat == sharkSize) {
                sharkSize++;
                eat = 0;
            }
        }
        return time;
    }

    private static int[] bfs(int sx, int sy) {
        visited = new boolean[N][N];
        int[][] dist = new int[N][N];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        int fx = -1;
        int fy = -1;
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;

                if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
                    if (dist[nx][ny] < minDist ||
                            (dist[nx][ny] == minDist && nx < fx) ||
                            (dist[nx][ny] == minDist && nx == fx && ny < fy)) {
                        fx = nx;
                        fy = ny;
                        minDist = dist[nx][ny];
                    }
                }

                q.offer(new int[]{nx, ny});
            }
        }
        if (fx == -1) return null;
        return new int[]{fx, fy, minDist};
    }
}
