package must;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class must4_BOJ2667 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        /// 완벽

        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) { //새로운 단지라면
                    count++;
                    int size = BFS(i, j); // size 측정
                    result.add(size); // 사이즈 값 저장
                }
            }
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');
        for (int s : result) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);

    }


    /// 사이즈 측정법
    private static int BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();//int로 좌표를 저장할거라서 int
        queue.offer(new int[]{x, y});
        int sized = 1; //시작지체가 1이니 1로시작
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) { // 벽이라면 무시
                    continue;
                }
                if (map[nx][ny] == 1 && !visited[nx][ny]) {// 1이고 방문하지 않은 배열
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});//큐에 넣어서 또 확인
                    sized++;
                }
            }
        }
        return sized;
    }
}
