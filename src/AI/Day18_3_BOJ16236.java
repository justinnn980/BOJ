package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day18_3_BOJ16236 {
    static int N;
    static int[][] map;
    static int sharkSize = 2;
    static ArrayList<int[]> fishs;
    static int time, eatcount;
    static int startj, starti;
    static boolean[][] vis;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
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
                    startj = j;
                    starti = i;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            dist = new int[N][N];
            fishs = new ArrayList<>();

            Bfs(starti,startj);

            if (fishs.isEmpty()) break;

            fishs.sort((a, b) -> {
                if (a[2] != b[2]) return a[2] - b[2];
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });

            int[] fish = fishs.get(0);

            time += fish[2];
            map[fish[0]][fish[1]] = 0;
            starti = fish[0];
            startj = fish[1];

            eatcount++;
            if (eatcount == sharkSize) {
                sharkSize++;
                eatcount = 0;
            }
        }

        System.out.println(time);
    }

    private static void Bfs(int starti, int startj) {
        Queue<int[]> q = new LinkedList<>();
        vis = new boolean[N][N];

        q.offer(new int[]{starti,startj});
        vis[starti][startj] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx<0||ny<0||nx>=N||ny>=N) continue;
                if (map[nx][ny] > sharkSize) continue;
                if (vis[nx][ny]) continue;

                q.offer(new int[]{nx, ny});
                vis[nx][ny] = true;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;

                if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
                    fishs.add(new int[]{nx, ny, dist[nx][ny]});
                }
            }
        }
    }
}
