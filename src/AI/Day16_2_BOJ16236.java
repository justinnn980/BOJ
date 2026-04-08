package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Day16_2_BOJ16236 {
    static int N;
    static int[][] map;
    static Queue<int[]> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int fishSize = 2;
    static ArrayList<int[]> fishs;
    static int starti, startj, eatCount, time;
    static boolean[][] vis;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    starti = i;
                    startj = j;
                    map[i][j] = 0;
                }
            }
        }

        Sol(starti, startj);

        System.out.println(time);
    }

    private static void Sol(int i, int j) {
        while (true){
            bfs(i, j);

            if (fishs.isEmpty()) break;

            int[] best = fishs.getFirst();

            for (int k = 1; k < fishs.size(); k++) {
                int[] cur = fishs.get(k);

                if (best[2] > cur[2]) {
                    best = cur;
                }
                if (best[2] == cur[2]) {
                    if (best[1] > cur[1]){
                        best = cur;
                    }
                    if (best[1] == cur[1]) {
                        if (best[0] > cur[0]){
                            best = cur;
                        }
                    }
                }
            }

            time += dist[best[0]][best[1]];
            map[best[0]][best[1]] = 0;
            i = best[0];
            j = best[1];
            eatCount++;

            if (eatCount == fishSize) {
                fishSize++;
                eatCount = 0;
            }
        }

    }

    private static void bfs(int i, int j) {
        q = new LinkedList<>();
        fishs = new ArrayList<>();
        vis = new boolean[N][N];
        dist = new int[N][N];

        q.offer(new int[]{i,j});
        vis[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx<0||ny<0||nx>=N||ny>=N) continue;
                if (vis[nx][ny]) continue;
                if (map[nx][ny] > fishSize) continue;

                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
                vis[nx][ny] = true;

                if (map[nx][ny] > 0 && map[nx][ny] < fishSize){
                    fishs.add(new int[]{nx, ny, dist[nx][ny]});
                }
            }
        }
    }

}
