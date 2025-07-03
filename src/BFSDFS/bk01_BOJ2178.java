package BFSDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bk01_BOJ2178 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1}; // 상하좌우 네 방향을 의미
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        String[] board = new String[n];

        for (int i = 0; i < n; i++) {
            board[i] = sc.nextLine();
        }

        /// 준비
        // 최단거리를 저장하기 위한 배열
        int[][] dist = new int[n][m];
        // 모든 값을 -1로 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>(); // 배열을 큐에 넣겠다
        queue.add(new int[]{0,0}); // 큐배열 처음에 0,0을 넣는다.
        dist[0][0] = 0; // 시작점 설정

        /// BFS
        while (!queue.isEmpty()) {
            // 큐에 가장 앞에 있는 좌표를 꺼내 cur 배열에 저장(현재 탐험가가 서있는 위치)
            int[] cur = queue.poll();
            // 현재 위치에서 상,하,좌,우 네 방향을 모두 탐색하기 위한 반복문
            for(int dir = 0; dir < 4; dir++) {
                // 다음으로 이동할 지점의 좌표를 계산
                int x = cur[0] + dx[dir];
                int y = cur[1] + dy[dir];

                // 지도 범위를 벗어 났는가?
                if (x < 0 || y >= n || y < 0 || y >= m) continue;
                // 갈 수 없는곳이거나, 이미 방문한 곳인가?
                if (dist[x][y] >= 0 || board[x].charAt(y) != '1') continue;

                // 새로운 지점 까지의 거리를 기록 현재 위치 cur까지의 거리에 1을 더한다.
                dist[x][y] = dist[cur[0]][cur[1]] + 1;
                /// 새로 방문한 지점을 다음에 탐색할 곳으로 큐에 추가
                queue.add(new int[]{x, y});
            }
        }
        /// 최단 거리에서 1 더하기
        System.out.println(dist[n - 1][m - 1] + 1);
    }
}
