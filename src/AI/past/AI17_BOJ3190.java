package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AI17_BOJ3190 {
    static int N,K,L,X;
    static String C;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int time, dir;

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
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine());

        System.out.println(play(br, L));

    }

    private static int play(BufferedReader br,int l) throws IOException {
        Map<Integer, Character> turn = new HashMap<>();

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            turn.put(x, c);
        }

        Queue<int[]> snake = new LinkedList<>();

        dir = 0;
        int headX = 0, headY = 0;
        time = 0;

        snake.offer(new int[]{0, 0});
        map[0][0] = 2;

        while (true) {
            time++;

            int nx = headX + dx[dir];
            int ny = headY + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
            if (map[nx][ny] == 2) break;

            if (map[nx][ny] == 1) {
                map[nx][ny] = 2;
                snake.offer(new int[]{nx, ny});
            } else {
                map[nx][ny] = 2;
                snake.offer(new int[]{nx, ny});
                int[] tail = snake.poll();
                map[tail[0]][tail[1]] = 0;
            }

            headX = nx;
            headY = ny;

            if (turn.containsKey(time)) {
                char c = turn.get(time);
                if (c == 'D') dir = (dir + 1) % 4;
                else dir = (dir + 3) % 4;
            }
        }
        return time;
    }
}
