package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
map 전체 탐색
↓
집 발견
↓
count = 0
↓
DFS 시작
↓
집 탐색하면서 count++
↓
DFS 종료
↓
result에 count 저장
↓
단지 수 증가
*/
public class AI02_BOJ2667 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i<N; i++){
            String line = br.readLine();
            for (int j = 0; j<N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> result = solution(N, map);

        System.out.println(result.size());

        for(int num : result){
            System.out.println(num);
        }
    }

    private static ArrayList<Integer> solution(int n, int[][] map) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && visited[i][j] == false){
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);

        return result;
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int d = 0; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx<0||ny<0||nx>=N||ny>=N) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] == 0) continue;

            dfs(nx,ny);
        }

    }
}
