package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day20_3_BOJ21610 {
    static int N,M;
    static int[][] map;
    static ArrayList<int[]> clouds = new ArrayList<>();
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] cx = {-1, -1, 1, 1};
    static int[] cy = {-1, 1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //첫 비구름 만들기
        clouds.add(new int[]{N - 1, 0});
        clouds.add(new int[]{N - 1, 1});
        clouds.add(new int[]{N - 2, 0});
        clouds.add(new int[]{N - 2, 1});

        for (int cmd = 0; cmd < M; cmd++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            boolean[][] wasCloud = new boolean[N][N];
            ArrayList<int[]> movedClouds = new ArrayList<>();

            // 1. 구름 이동
            for (int[] cloud : clouds) {
                int x = cloud[0];
                int y = cloud[1];

                int nx = (x + dx[d] * s) % N;
                int ny = (y + dy[d] * s) % N;

                if (nx < 0) nx += N;
                if (ny < 0) ny += N;

                movedClouds.add(new int[]{nx, ny});
            }

            // 2. 비 내리기 + 이번 턴 구름 칸 기록
            for (int[] cloud : movedClouds) {
                int x = cloud[0];
                int y = cloud[1];
                map[x][y]++;
                wasCloud[x][y] = true;
            }

            // 3. 물복사버그
            for (int[] cloud : movedClouds) {
                int x = cloud[0];
                int y = cloud[1];
                int count = 0;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + cx[dir];
                    int ny = y + cy[dir];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (map[nx][ny] > 0) count++;
                }

                map[x][y] += count;
            }

            // 4. 새 구름 생성
            clouds = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!wasCloud[i][j] && map[i][j] >= 2) {
                        clouds.add(new int[]{i, j});
                        map[i][j] -= 2;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }
}
