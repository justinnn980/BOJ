package etc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 행의 크기
        M = sc.nextInt(); // 열의 크기
        sc.nextLine(); // 버퍼 비우기
        A = new int[N][M];
        visited = new boolean[N][M];

        // 입력 처리
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j) - '0'; // 문자열을 숫자로 변환
            }
        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j] = true; // 방문 처리
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if (A[nx][ny]!=0 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        A[nx][ny] = A[cur[0]][cur[1]] + 1;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}
