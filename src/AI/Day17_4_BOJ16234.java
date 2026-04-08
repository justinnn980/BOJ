package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day17_4_BOJ16234 {
    static int N,L,R;
    static int[][] A;
    static boolean[][] vis;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static ArrayList<int[]> union;
    static int sum, day;
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

        while (true) {
            //move
            boolean moved = false;
            //갱신
            vis = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!vis[i][j]){
                        bfs(i,j);

                        // 변경
                        if (union.size() > 1) {
                            moved = true;
                            int avg = sum / union.size();
                            for (int[] q : union){
                                A[q[0]][q[1]] = avg;
                            }
                        }
                    }
                }
            }

            if (moved == false){
                break;
            }

            day++;
        }
        System.out.println(day);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        union = new ArrayList<>();
        sum = 0;

        q.offer(new int[]{i,j});
        union.add(new int[]{i,j});
        vis[i][j] = true;
        sum += A[i][j];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx<0||ny<0||nx>=N||ny>=N) continue;
                if (vis[nx][ny]) continue;
                int diff = Math.abs(A[nx][ny] - A[cur[0]][cur[1]]);

                if (diff >= L && diff <= R) {
                    union.add(new int[]{nx, ny});
                    q.offer(new int[]{nx, ny});
                    vis[nx][ny] = true;
                    sum += A[nx][ny];
                }
            }
        }

    }
}
