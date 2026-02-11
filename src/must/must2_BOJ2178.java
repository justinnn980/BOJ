package must;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class must2_BOJ2178 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        BFS(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }

    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) { //  행열 양수, 행렬 N,M 이하
                    if (map[nx][ny] != 0 && !visited[nx][ny]) {// 벽이 아닌지 체크, 방문한 배열이면 안된다
                        visited[nx][ny] = true;
                        map[nx][ny] = map[cur[0]][cur[1]] + 1; //depth 한개 더 크게 넣어줌
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
