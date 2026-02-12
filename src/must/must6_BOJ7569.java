package must;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class must6_BOJ7569 {
    static int[] dx = {-1, 1, 0, 0, 0, 0}; // n
    static int[] dy = {0, 0, -1, 1, 0, 0}; // m
    static int[] dz = {0, 0, 0, 0, -1, 1}; // h
    static int N, M, H;
    static int[][][] map;
    static boolean[][][] visited;
    static Deque<int[]> que0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        visited = new boolean[H][N][M];
        Deque<int[]> deque = new ArrayDeque<>();
        que0 = new ArrayDeque<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());

                    if (map[h][n][m] == 0) que0.add(new int[]{h, n, m});
                    else if (map[h][n][m] == 1) deque.add(new int[]{h, n, m});
                }
            }
        }

        int r = floodfill(deque, 0);
        System.out.println(r);
    }

    public static int floodfill(Deque<int[]> deque, int days) {
        if (IsReady())
            return days;

        Deque<int[]> next = new ArrayDeque<>();

        while (deque.size() > 0) {
            int[] cur = deque.poll();
            for (int i = 0; i < 6; i++) {
                int nh = cur[0] + dz[i];
                int nn = cur[1] + dx[i];
                int nm = cur[2] + dy[i];

                if (IsInMap(nh, nn, nm)) {
                    if(map[nh][nn][nm] == 0){
                        map[nh][nn][nm] = 1;
                        next.add(new int[]{nh, nn, nm});
                    }
                }
            }
        }
        if (next.size() > 0) {
            return floodfill(next, days + 1);
        }
        return -1;
    }

    private static boolean IsReady() {
        for (int[] cur:que0) {
            int nx = cur[0];
            int ny = cur[1];
            int nz = cur[2];

            if (map[nx][ny][nz] == 0) {
                return false;
            }else if(map[nx][ny][nz] == 1){
                que0.remove(cur);
            }
        }

        return true;
    }
    public static boolean IsInMap(int h, int n, int m) {
        return h >= 0 && h < H && n >= 0 && n < N && m >= 0 && m < M;
    }


}


