package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day16_4_BOJ16234 {
    static int N, L, R;
    static int[][] A;
    static int day, sum;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] vis;
    static boolean moved;
    static ArrayList<int[]> union;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Sol();

        System.out.println(day);
    }

    private static void Sol() {
        //다시한번 전체반복
        while (true) {
            vis = new boolean[N][N];
            moved = false;

            //모든 영역 돌면서 후보군 찾고 평균 끝난곳은 방문 체크
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!vis[i][j]){
                        bfs(i,j);

                        if (union.size() > 1) {
                            int avg = sum / union.size();
                            for (int[] q : union) {
                                A[q[0]][q[1]] = avg;
                            }
                            moved = true;
                        }
                    }

                }
            }

            if (!moved) break;
            day++;
        }
    }

    private static void bfs(int i, int j) {
        q = new LinkedList<>();
        union = new ArrayList<>();
        sum = 0;

        q.offer(new int[]{i, j});
        union.add(new int[]{i,j});
        sum += A[i][j];
        vis[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx<0||ny<0||nx>=N||ny>=N) continue;
                if (vis[nx][ny]) continue;
                int diff = Math.abs(A[nx][ny] - A[cur[0]][cur[1]]);

                if (diff >= L && diff <= R) {
                    q.offer(new int[]{nx,ny});
                    union.add(new int[]{nx, ny});
                    sum += A[nx][ny];
                    vis[nx][ny] = true;
                }
            }
        }
    }

}
