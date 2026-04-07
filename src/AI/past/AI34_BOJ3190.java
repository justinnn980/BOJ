package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AI34_BOJ3190 {
    static int N, K, L;
    static int[][] map;
    static int time;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int r,c,d;

    static HashMap<Integer, Character> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = 0;
            }
        }
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            hashMap.put(x,c);
        }

        Sol();
        System.out.println(time);
    }

    private static void Sol() {
        Deque<int[]> snake = new LinkedList<>();

        snake.add(new int[]{0,0});
        map[0][0] = 2;
        r = 0;
        c = 0;
        d = 1; // 오른쪽

        while (true) {
            time++;

            int nx = r + dx[d];
            int ny = c + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 2) continue;

            boolean apple = (map[nx][ny] == 1);

            snake.add(new int[]{nx, ny});
            map[nx][ny] = 2;
            r = nx;
            c = ny;

            if (!apple) {
                int[] tail = snake.pollFirst();
                map[tail[0]][tail[1]] = 0;
            }

            if (hashMap.containsKey(time)) {
                char dirInfo = hashMap.get(time);

                if (dirInfo == 'L') {
                    d = (d+3) % 4;
                } else if (dirInfo == 'D') {
                    d = (d+1) % 4;
                }
            }
        }
    }
}
