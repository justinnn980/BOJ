package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFSdongbinFreezenDrinkBufferd {
    static int n,m;
    static int[][] arr;
    static boolean[][] visited;

    // 상, 하, 좌, 우 방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // br + 문자로 값 받기 중요!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizes = br.readLine().split(" ");
        n = Integer.parseInt(sizes[0]);
        m = Integer.parseInt(sizes[1]);
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0'; // 문자를 숫자로 변환
            }
        }
        int result = 0;
        /// 특정지점의 상하좌우를 살펴본 뒤에 주변 지점 중에서 값이 0이면서 아직 방문하지 않은 지점이 있다면 해당 지점을 방문
        /// 방문한 지점에서 다시 상하좌우를 삺보면서 방문을 진행하는 과정을 반복하면, 연결된 모든 지점을 방문
        /// 모든 노드에 대하여 1,2번을 반복, 방문하지 않은 지점의 수를 카운트
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean dfs(int x, int y) {
        // 범위 벗어나면 false
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        if (arr[x][y] == 0) {
            arr[x][y] = 1; // 방문 처리

            // 상하좌우 재귀적으로 호출
            for (int i = 0; i < 4; i++) {
                dfs(x + dx[i], y + dy[i]);
            }
            return true;
        }
        return false;
    }
}
