package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AI21_BOJ16234 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static boolean moved;
    static int day;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        day = 0;
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        System.out.println(day);
    }

    private static void sol() {
        while (true) {
            //초기화
            visited = new boolean[N][N];
            moved = false;
            //모든 좌표 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        //BFS로 연합 찾기
                        bfs(i, j);
                    }
                }
            }
            if (!moved) break;
            day++;
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> union = new ArrayList<>();

        //인구 합 계산
        int sum = map[x][y];

        //연합 크기 계산
        q.offer(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int xx = cur[0];
            int yy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                int diff = Math.abs(map[xx][yy] - map[nx][ny]);
                if (!visited[nx][ny] && diff >= L && diff <= R) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    sum += map[nx][ny];
                }
            }
        }
        if (union.size() > 1) {
            moved = true;
            //평균 인구 = sum / union.size()
            int avg = sum / union.size();

            //union에 있는 모든 좌표에 평균값 넣기
            for (int[] p : union) {
                map[p[0]][p[1]] = avg;
            }
        }
    }

}
