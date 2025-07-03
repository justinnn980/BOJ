package BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bk02_BOJ1926 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1}; // 상하좌우 네 방향을 의미

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        boolean[][] visited = new boolean[n][m];
        int cnt = 0;
        int big = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 이미 방문했다면 무시하고 다음칸
                if (board[i][j] == 0 || visited[i][j]) continue;

                // 통과했다면 새그림 발견한 것
                cnt++;

                // bfs
                Queue<int[]> queue = new LinkedList<>();
                visited[i][j] = true; // 시작점 방문 표시
                queue.add(new int[]{i, j}); // 큐에 시작점 추가

                int area = 0; // 그림의 넓이

                while (!queue.isEmpty()) {
                    area++; // 큐에서 하나 꺼낼때마다 넓이 증가
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];

                    // 꺼낸 좌표에서 상하좌우 확인
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        // 이웃이 범위를 벗어나거나, 그림이 아니거나, 이미 방문했다면 무시
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if (board[nx][ny] == 0 || visited[nx][ny]) continue;
                        // 방문처리
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
                // 최대 값 갱신
                big = Math.max(big, area); // 최댓값 갱신

            }
        }
        System.out.println(cnt);
        System.out.println(big);
    }
}
