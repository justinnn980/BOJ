package Blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Blog17_BOJ2178 {
    static int N,M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(solution(N, M, maze));
    }

    public static int solution(int N, int M, int[][] maze) {
    // 자료구조 초기화

    // 시작위치 큐에 넣고 방문처리

    // BFS
        // 노드 꺼내기
        // x,y

        // 4방향 탐색

            // 범위, 방문여부, 벽인지
            // 방문처리
            // 거리 갱신, 현재 거리 + 1
            // 다음좌표 큐에 넣기


    // 정답 리턴
        return 0;
    }

    public static int solution4(int N, int M, int[][] maze) {
        // 자료구조 초기화
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][M];

        // 시작위치 큐에 넣고 방문처리
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        // BFS
        while (!q.isEmpty()){
            // 노드 꺼내기
            int[] now = q.poll();
            // x,y
            int x = now[0];
            int y = now[1];
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위, 방문여부, 벽인지
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if (visited[nx][ny] == true) continue;
                if (maze[nx][ny] == 0) continue;
                // 방문처리
                visited[nx][ny] = true;
                // 거리 갱신, 현재 거리 + 1
                maze[nx][ny] = maze[x][y] + 1;
                // 다음좌표 큐에 넣기
                q.offer(new int[]{nx, ny});
            }
        }


        // 정답 리턴
        return maze[N-1][M-1];
    }
    public static int solution3(int N, int M, int[][] maze) {
        // 자료구조 초기화
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        // 큐에 넣고 방문처리
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        // BFS
        while(!q.isEmpty()){
            // 노드 꺼내기
            int[] now = q.poll();
            // 값넣기
            int x = now[0];
            int y = now[1];

            // 다음 칸 탐색
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 이동 조건
                // 범위, 방문여부, 벽인지
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(visited[nx][ny]) continue;
                if(maze[nx][ny]==0) continue;

                // 방문처리
                visited[nx][ny] = true;
                // 거리 갱신, 현재 거리 + 1
                maze[nx][ny] = maze[x][y] + 1;
                // 다음좌표 큐에 넣기
                q.offer(new int[]{nx, ny});
            }
        }

        return maze[N-1][M-1];
    }









    // 👉 프로그래머스 스타일
    public static int solution2(int N, int M, int[][] maze) {

        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && maze[nx][ny] == 1) {

                        visited[nx][ny] = true;
                        maze[nx][ny] = maze[x][y] + 1; // 거리 누적
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return maze[N - 1][M - 1];
    }
}