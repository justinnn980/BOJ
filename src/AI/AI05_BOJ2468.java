package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AI05_BOJ2468 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int safeArea, max;
    static boolean[][] visited;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                max = Math.max(max,a);
            }
        }

        System.out.println(sol(N,max,map));

    }

    private static int sol(int n, int max,int[][] map) {
        int answer = 0;

        for (int k = 0; k <= max; k++) {
            visited = new boolean[n][n];
            safeArea = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > k && !visited[i][j]){
                        dfs(i,j,k);
                        safeArea++;
                    }
                }
            }
            answer = Math.max(answer, safeArea);
        }

        return answer;
    }

    private static void dfs(int x, int y, int k) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx<0||ny<0||nx>=N||ny>=N) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] <= k) continue;

            dfs(nx,ny,k);
        }
    }
}
