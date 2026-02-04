package DayCoding;

import java.io.*;
import java.util.*;

public class A03 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int dfs(int x, int y) {
        visited[x][y] = true;
        int cnt = 1;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] == 0) continue;

            cnt += dfs(nx, ny);
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim(); // "0110101" 형태
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    sizes.add(dfs(i, j));
                }
            }
        }

        Collections.sort(sizes);

        StringBuilder sb = new StringBuilder();
        sb.append(sizes.size()).append('\n');
        for (int s : sizes) sb.append(s).append('\n');

        System.out.print(sb.toString());
    }
}
