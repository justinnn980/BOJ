package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AI43_BOJ16236 {
    static int N, time, eatCount;
    static int[][] map;
    static int SharkSize = 2;
    static ArrayList<int[]> fish = new ArrayList<>();
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        int x = 0;
        int y = 0;

        eatCount = 0;
        time = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    x = i;
                    y = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            bfs(x, y);

            if (fish.isEmpty()) break;

            //후보 중 우선순위대로 1마리 선택
            fish.sort((a, b) -> {
                if (dist[a[0]][a[1]] != dist[b[0]][b[1]]) {
                    return dist[a[0]][a[1]] - dist[b[0]][b[1]];
                }
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });

            //그 물고기 위치로 이동
            int[] cur = fish.get(0);
            x = cur[0];
            y = cur[1];

            map[x][y] = 0;
            time += dist[x][y];
            eatCount++;
            if (eatCount == SharkSize) {
                SharkSize++;
                eatCount = 0;
            }

        }
        System.out.println(time);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});

        visited = new boolean[N][N];
        dist = new int[N][N];
        fish = new ArrayList<>();

        visited[x][y] = true;

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

                if (map[nx][ny] != 0 && map[nx][ny] < SharkSize) {
                    fish.add(new int[]{nx, ny});
                }
            }
        }
    }
}
