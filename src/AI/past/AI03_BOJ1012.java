package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AI03_BOJ1012 {
    static int T,M,N,K;
    static boolean[][] visited;
    static int[][] map;
    static int count;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int te = 0; te < T; te++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            visited = new boolean[N][M];
            map = new int[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int f = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[b][f] = 1;
            }

            System.out.println(solution(N,M,map));
        }
    }

    private static int solution(int n, int m, int[][] map) {
        int list = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]==1&&!visited[i][j]){
                    dfs(i, j);
                    list++;
                }

            }
        }
        return list;
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx<0||ny<0||nx>=N||ny>=M) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }
}