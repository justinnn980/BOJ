package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AI23_BOJ16234 {
    static int N,L,R;
    static int day;
    static int[][] map;
    static boolean[][] visited;
    static boolean moved;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    //1️⃣ 연합 찾기 → BFS
    //2️⃣ 연합 저장 → union 리스트
    //3️⃣ 인구 합 → sum
    //4️⃣ 연합 크기 → union.size()
    //5️⃣ 연합 크기 ≥ 2 → 인구 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        day = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solution();
        System.out.println(day);
    }

    private static void Solution() {

        while (true) {
            visited = new boolean[N][N];
            moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]){
                        bfs(i,j);
                    }
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
        visited[x][y] = true;
        union.add(new int[]{x, y});

        int sum = map[x][y];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
                if (diff >= L && diff <= R) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    union.add(new int[]{nx,ny});
                    sum += map[nx][ny];
                }
            }
        }

        if (union.size() > 1) {
            moved = true;
            int result = sum / union.size();
            for (int[] pos : union) {
                map[pos[0]][pos[1]] = result;
            }
        }

    }
}
