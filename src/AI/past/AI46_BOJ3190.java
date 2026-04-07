package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class AI46_BOJ3190 {
    static int N, K, L, X;
    static char C;
    static int[][] map;
    static int time = 0;
    static int head, tail;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

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
            map[a - 1][b - 1] = 1;
        }

        L = Integer.parseInt(br.readLine());

        int r = 0;
        int c = 0;
        int d = 0;

        HashMap<Integer, Character> turn = new HashMap<>();

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            turn.put(X, C);
        }

        Deque<int[]> snake = new ArrayDeque<>();
        snake.addFirst(new int[]{0, 0});
        map[0][0] = 2;

        while (true) {
            time++;

            //머리이동
            int nx = r + dx[d];
            int ny = c + dy[d];
            //종료
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 2) break;
            // 머리추가
            snake.addFirst(new int[]{nx, ny});
            //사과 확인
            if (map[nx][ny] == 1) {
                // 꼬리 유지
            } else {
                //꼬리 제거
                int[] tail = snake.removeLast();
                map[tail[0]][tail[1]] = 0;
            }
            //map갱신
            map[nx][ny] = 2;
            //방향전황 체크
            r = nx;
            c = ny;

            if (turn.containsKey(time)) {
                char cmd = turn.get(time);
                if (cmd == 'D') d = (d + 1) % 4;
                else d = (d + 3) % 4;
            }

        }
        System.out.println(time);

    }

}
