package BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bk02_BOJ1926 {
    static int[][] board = new int[502][502]; // 1이 파란 칸, 0이 빨간 칸에 대응
    static boolean[][] vis = new boolean[502][502]; // 해당 칸을 방문했는지 여부를 저장
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1}; // 상하좌우 네 방향을 의미

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                /// 도화지의 그림
                board[i][j] = sc.nextInt();
            }
        }

        /// 가장 넒은 그림의 넓이
        int mx = 0;
        /// 그림의 개수
        int num = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { // i,j 를 시작점으로 하고 싶은 상황
                if (board[i][j] == 0 || vis[i][j]) continue; // 색칠이 안되어 있거나 방문한 경우 넘어감

                /// 새로운 그림에 속해있는 시작점
                // 그림의 수 1 증가
                num++;

                Queue<int[]> queue = new LinkedList<>();
                vis[i][j] = true; // 방문 표시
                queue.add(new int[]{i, j});
                int area = 0; // 그림의 넓이

                while (!queue.isEmpty()) {
                    area++; // 큐에서 꺼낼 때마다 넓이 증가
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];
                    for (int k = 0; k < 4; k++) { // 상하좌우 확인
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if (board[nx][ny] == 0 || vis[nx][ny]) continue;
                        vis[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
                mx = Math.max(mx, area); // 최댓값 갱신
            }
        }
        System.out.println(num);
        System.out.println(mx);
    }

}
