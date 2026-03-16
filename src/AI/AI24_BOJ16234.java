package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AI24_BOJ16234 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static boolean moved;
    static int day;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

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

        Soultion();
        System.out.println(day);
    }

    private static void Soultion() {
        while (true) {
            moved = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
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
        union.add(new int[]{x,y});

        visited[x][y] = true;
        //틀린부분 합
        int sum = map[x][y];

        while (!q.isEmpty()){
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);

                if (diff >= L && diff <= R){
                    q.offer(new int[]{nx,ny});
                    union.add(new int[]{nx,ny});
                    //연합 인구수 합 계산
                    sum += map[nx][ny];
                    visited[nx][ny] = true;
                }
            }

        }
        if (union.size() > 1) {
            moved = true;

            //인구수 계산
            int avg = sum / union.size();
            // 인구수 넣기
            for (int[] i : union) {
                map[i[0]][i[1]] = avg;
            }
        }
    }

}
