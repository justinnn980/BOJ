package BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class BaaaaakingDogStackDFS {
    /// 판
    static int[][] board = {
        {1,1,1,0,1,0,0,0,0,0},
        {1,0,0,0,1,0,0,0,0,0},
        {1,1,1,0,1,0,0,0,0,0},
        {1,1,0,0,1,0,0,0,0,0},
        {0,1,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0}
    };

    static boolean[][] vis = new boolean[502][502];
    static int n = 7, m = 10;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Queue<Pair> q = new LinkedList<>();
        vis[0][0] = true;
        q.offer(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            System.out.print("(" + cur.x + ", " + cur.y + ") -> ");

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (vis[nx][ny] || board[nx][ny] != 1) continue;

                vis[nx][ny] = true;
                q.offer(new Pair(nx, ny));
            }
        }
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
