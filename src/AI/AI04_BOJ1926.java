package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AI04_BOJ1926 {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int pictureCount = 0;
    static int maxArea = 0;
    static int area;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol(n,m,map);
        System.out.println(pictureCount);
        System.out.println(maxArea);
    }

    private static void sol(int n, int m, int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    area = 0;
                    dfs(i,j);
                    pictureCount++;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        area++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx<0||ny<0||nx>=n||ny>=m) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] == 0) continue;

            dfs(nx,ny);
        }
    }
}