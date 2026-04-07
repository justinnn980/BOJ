package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AI01_BOJ2178 {
    static int N,M;
    static boolean vitsited[][];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(solution(N, M, map));
    }

    private static int solution(int n, int m,int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        vitsited = new boolean[n][m];

        q.offer(new int[]{0,0});
        vitsited[0][0] = true;

        while (!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx<0 || ny<0|| nx>=n|| ny>=m) continue;
                if (vitsited[nx][ny] == true) continue;
                if (map[nx][ny] == 0) continue;

                vitsited[nx][ny] = true;
                q.offer(new int[]{nx,ny});
                map[nx][ny] = map[x][y] + 1;
            }

        }
        return map[n-1][m-1];
    }

}
