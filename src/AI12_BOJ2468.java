import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AI12_BOJ2468 {
    static int N;
    static int[][] map;
    static int max = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int maxresult = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        int safeArea = 0;

        for (int i = 0; i <= max; i++) {
            visited = new boolean[N][N];
            safeArea = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] > i && visited[j][k] == false){
                        sol(i, j, k);
                        safeArea++;
                    }
                }
            }
            maxresult = Math.max(maxresult, safeArea);
        }

        System.out.println(maxresult);
    }

    private static void sol(int max, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || ny >= N || nx >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] <= max) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx,ny});
            }
        }
    }
}
