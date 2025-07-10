package BFSDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bk04_BOJ4179 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();

        String[] maze = new String[r];
        for (int i = 0; i < r; i++) {
            maze[i] = sc.nextLine();
        }

        int[][] fireDist = new int[r][c];
        int[][] jihunDist = new int[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(fireDist[i], -1);
            Arrays.fill(jihunDist[i], -1);
        }

        Queue<int[]> fire = new LinkedList<>(); // 불
        Queue<int[]> jihun = new LinkedList<>(); // 지훈

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (maze[i].charAt(j) == 'F') {
                    fire.add(new int[]{i, j});
                    fireDist[i][j] = 0;
                }
                if (maze[i].charAt(j) == 'J') {
                    jihun.add(new int[]{i, j});
                    jihunDist[i][j] = 0;
                }
            }
        }

        // 불 BFS
        while (!fire.isEmpty()) {
            int[] cur = fire.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
                if (fireDist[nx][ny] >= 0 || maze[nx].charAt(ny) == '#') {
                    continue;
                }
                fireDist[nx][ny] = fireDist[cur[0]][cur[1]] + 1;
                fire.add(new int[]{nx, ny});
            }
        }

        // 지훈 BFS
        while (!jihun.isEmpty()) {
            int[] cur = jihun.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    System.out.println(jihunDist[cur[0]][cur[1]] + 1);
                    return;
                }
                if (jihunDist[nx][ny] >= 0 || maze[nx].charAt(ny) == '#') {continue;}
                if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= jihunDist[cur[0]][cur[1]] + 1) {continue;}
                jihunDist[nx][ny] = jihunDist[cur[0]][cur[1]] + 1;
                jihun.add(new int[]{nx, ny});
            }
        }
        System.out.println("IMPOSSIBLE");
    }

}
