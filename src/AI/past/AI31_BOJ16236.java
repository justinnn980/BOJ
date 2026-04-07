package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AI31_BOJ16236 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int sharkSize = 2;
    static int eatCount = 0;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int x = 0;
        int y = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    x = i;
                    y = j;
                    map[i][j] = 0;
                }
            }
        }

        Soultion(x, y);
        System.out.println(time);
    }

    private static void Soultion(int x, int y) {
        while (true) {
            int[] fish = bfs(x, y);
            //먹을 물고기가 없으면 끝낸다.
            if (fish == null) break;

            //있으면 그 물고기 위치로 이동한다.
            x = fish[0];
            y = fish[1];
            //이동한 만큼 시간을 더한다.
            time += fish[2];
            //그 물고기를 맵에서 없앤다.
            map[x][y] = 0;
            //먹은 횟수를 1 올린다.
            eatCount++;
            //만약 현재 크기만큼 먹었으면 크기를 1 키우고 먹은 횟수를 0으로 초기화한다.
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }
    }

    //현재 상어 위치에서 BFS 시작
    //갈 수 있는 칸만 탐색
    //먹을 수 있는 물고기를 만나면 후보로 저장
    //후보가 여러 개면 거리 → 위 → 왼쪽 순으로 비교
    //가장 좋은 물고기 1마리 반환
    //없으면 null
    private static int[] bfs(int sx, int sy) {
        visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        int fx = -1;
        int fy = -1;
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            //이미 더 가까운 물고기를 찾았는데,
            //지금 칸이 그보다 멀면 볼 필요 없음
            if (dist > minDist) continue;

            //현재 칸이 빈칸이 아니고,
            //상어 크기보다 작은 물고기라면 먹을 수 있다
            if (map[x][y] != 0 && map[x][y] < sharkSize) {
                //지금 물고기가 기존 후보보다 더 좋은 후보인지 비교
                //더 가까우면 무조건 교체
                //거리가 같으면 더 위쪽(행이 작음) 선택
                //거리도 같고 행도 같으면 더 왼쪽(열이 작음) 선택
                if (dist < minDist ||
                        (dist == minDist && x < fx) ||
                        (dist == minDist && x == fx && y < fy)) {

                    fx = x;
                    fy = y;
                    minDist = dist;
                }
                //현재 물고기를 최적 후보로 저장
                //현재 칸이 먹을 물고기라면, 이 칸에서 4방향으로 더 확장하지 않음
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                //현재 칸이 먹을 물고기라면, 이 칸에서 4방향으로 더 확장하지 않음
                if (map[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }
        //끝까지 탐색했는데 먹을 물고기를 못 찾았으면 null 반환
        if (fx == -1) return null;
        //찾은 물고기의 위치와 거리 반환
        return new int[]{fx, fy, minDist};
    }
}
