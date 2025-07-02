package BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bk03_BOJ7576 {

    static int[][] board = new int[1002][1002];
    static int[][] dist = new int[1002][1002];
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
                if (board[i][j] == 0) {
                    dist[i][j] = -1; // 익지 않은 토마토는 -1로 초기화
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (dist[nx][ny] >= 0) {
                    continue;
                }

                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans, dist[i][j]);
            }
        }

        System.out.println(ans);
    }
}
