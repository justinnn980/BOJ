package BFSDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bk04_BOJ4179 {

    static String[] board = new String[1002];
    static int[][] dist1 = new int[1002][1002]; // 불의 전파 시간
    static int[][] dist2 = new int[1002][1002]; // 지훈이의 이동 시간
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < r; i++) {
            board[i] = sc.nextLine();
        }

        for (int i = 0; i < r; i++) {
            Arrays.fill(dist1[i], -1);
            Arrays.fill(dist2[i], -1);
        }

        Queue<int[]> q1 = new LinkedList<>(); // 불
        Queue<int[]> q2 = new LinkedList<>(); // 지훈

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i].charAt(j) == 'F') {
                    q1.add(new int[]{i, j});
                    dist1[i][j] = 0;
                }
                if (board[i].charAt(j) == 'J') {
                    q2.add(new int[]{i, j});
                    dist2[i][j] = 0;
                }
            }
        }

        // 불 BFS
        while (!q1.isEmpty()) {
            int[] cur = q1.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
                if (dist1[nx][ny] >= 0 || board[nx].charAt(ny) == '#') {
                    continue;
                }
                dist1[nx][ny] = dist1[cur[0]][cur[1]] + 1;
                q1.add(new int[]{nx, ny});
            }
        }

        // 지훈 BFS
        while (!q2.isEmpty()) {
            int[] cur = q2.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    // 탈출 성공
                    System.out.println(dist2[cur[0]][cur[1]] + 1);
                    return;
                }
                if (dist2[nx][ny] >= 0 || board[nx].charAt(ny) == '#') continue;
                if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur[0]][cur[1]] + 1) continue;
                dist2[nx][ny] = dist2[cur[0]][cur[1]] + 1;
                q2.add(new int[]{nx, ny});
            }
        }

        System.out.println("IMPOSSIBLE");
    }

}
