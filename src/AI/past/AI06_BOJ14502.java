package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AI06_BOJ14502 {
    static int N,M;
    static int answer = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solut(N,M,map));
    }

    private static int solut(int n, int m, int[][] map) {
        // 빈칸 0인 곳에 벽을 3개 세우는 모든 경우를 탐색
        makeWall(0,0);

        return answer;
    }

    static void makeWall(int count, int start) {
        if (count == 3) {
            int[][] copy = copyMap();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copy[i][j] == 2) dfs(i, j, copy);
                }
            }

            answer = Math.max(answer, getSafeArea(copy));
            return;
        }

        for (int idx = start; idx < N * M; idx++) {
            int x = idx / M;
            int y = idx % M;

            if (map[x][y] == 0) {
                map[x][y] = 1;
                makeWall(count + 1, idx + 1);
                map[x][y] = 0;
            }
        }
    }


    static void dfs(int x, int y, int[][] copy) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (copy[nx][ny] != 0) continue;

            copy[nx][ny] = 2;
            dfs(nx, ny, copy);
        }
    }

    static int[][] copyMap() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    static int getSafeArea(int[][] copyMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}