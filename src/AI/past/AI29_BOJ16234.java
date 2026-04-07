package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AI29_BOJ16234 {
    static int N, L, R;
    static int[][] map;
    static int day;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static boolean moved;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Soution();
        System.out.println(day);
    }

    private static void Soution() {
        while (true) {
            visited = new boolean[N][N];
            moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bfs(i,j);
                }
            }
            if (!moved) break;
            day++;
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        q.offer(new int[]{x,y});
        union.add(new int[]{x, y});
        visited[x][y] = true;
        int sum = map[x][y];

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                int diff = Math.abs(map[x][y] - map[nx][ny]);

                if (diff >= L && diff <= R) {
                    q.offer(new int[]{nx,ny});
                    union.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    sum += map[nx][ny];
                }
            }
            if (union.size() > 1) {
                moved = true;
                int avg = sum / union.size();
                for (int[] i : union) {
                    map[i[0]][i[1]] = avg;
                }
            }
        }
    }
}
