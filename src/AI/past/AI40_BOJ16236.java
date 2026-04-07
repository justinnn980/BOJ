package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;
import java.util.StringTokenizer;

public class AI40_BOJ16236 {
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

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        int sx = 0, sy = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = i;
                    sy = j;
                    map[i][j] = 0;
                }
            }
        }

        Sol(sx, sy);
        System.out.println(time);
    }

    private static void Sol(int sx, int sy) {
        while (true) {
            bfs(sx, sy);
        }
    }

    private static int[] bfs(int x, int y) {
        // 1. BFS
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
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