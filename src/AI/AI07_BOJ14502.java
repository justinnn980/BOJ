package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AI07_BOJ14502 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
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

        System.out.println(solution(L,R,map));
    }

    private static int solution(int L, int R,int[][] map) {
        int day = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        // bfs or dfs
                        if(bfs(j,j)){
                            moved= true;
                        }
                        // union.size() > 1 이면 moved = true
                        // 평균으로 갱신
                    }
                }
            }

            if (!moved) break;
            day++;
        }
        return day;
    }
    static boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> union = new ArrayList<>();

        q.offer(new int[]{x,y});
        union.add(new int[]{x,y});
        visited[x][y] = true;

        int sum = map[x][y];

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                if (diff < L || diff > R) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                union.add(new int[]{nx, ny});
                sum += map[nx][ny];
            }
        }

        if (union.size() == 1) return false;

        int avg = sum / union.size();
        for (int[] pos : union) {
            map[pos[0]][pos[1]] = avg;
        }

        return true;

    }
}

