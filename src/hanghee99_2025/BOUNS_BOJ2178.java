package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOUNS_BOJ2178 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }

        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j}); //시작 위치
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int now[] = queue.poll(); //값

            for (int k = 0; k < 4; k++) { //상하좌우 탐색
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) { //  행열 양수, 행렬 N,M 이하
                    if (A[nx][ny] != 0 && !visited[nx][ny]) {// 벽이 아닌지 체크, 방문한 배열이면 안된다
                        visited[nx][ny] = true;
                        A[nx][ny] = A[now[0]][now[1]] + 1; //depth 한개 더 크게 넣어줌
                         queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
