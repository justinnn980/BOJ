package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hh04_BOJ2468 {

    static int n;
    static int[][] arr;
    static boolean[][] checked;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /// 2차원 배열의 행과 열의 개수를 나타내는 수 N이 입력된다.
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        int maxHeight = 0;
        /// 둘째 줄부터 N개의 각 줄에는 2차원 배열의 첫번째 행부터 N번째 행까지 순서대로 한 행높이 정보 입력
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < n; j++) {
                String[] s = input.split(" ");
                arr[i][j] = Integer.parseInt(s[j]);
                /// 최대 높이 저장
                if (arr[i][j] > maxHeight) {
                    maxHeight = arr[i][j];
                }
            }
        }

        /// 가장 많은 값 저장
        int max = 0;
        /// 모든 비의 높이에 대해 안전 영역 계산
        /// h 1부터 maxHeight 까지 순차적으로 계산
        for (int h = 0; h < maxHeight + 1; h++) {
            checked = new boolean[n][n];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 2. 안전 영역 탐지
                    if (!checked[i][j] && arr[i][j] > h) {
                        cnt += dfs(i, j, h); // 해당 안전영역 탐색 시작
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    private static int dfs(int x, int y, int h) {
        checked[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1) {
                continue;
            }
            if (checked[nx][ny]) {
                continue;
            }
            if (arr[nx][ny] > h) {
                dfs(nx, ny, h);
            }
        }
        return 1;
    }
}
