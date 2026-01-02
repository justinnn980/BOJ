package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14_BOJ2615 {
    static int[][] arr;
    static int[] dx = {1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[19][19];

        // ✅ 입력 수정: 공백으로 구분된 19개 숫자 읽기
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y < 19; y++) {
            for (int x = 0; x < 19; x++) {
                if (arr[y][x] != 0) {
                    int color = arr[y][x];
                    for (int dir = 0; dir < 4; dir++) {
                        if (isFive(y, x, color, dir)) {
                            System.out.println(color);
                            System.out.println((y + 1) + " " + (x + 1));
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static boolean isFive(int y, int x, int color, int dir) {
        int cnt = 1;
        int nx = x;
        int ny = y;

        // 앞으로 4칸까지 (총 5개 체크)
        for (int i = 0; i < 4; i++) {
            nx += dx[dir];
            ny += dy[dir];
            if (!inRange(nx, ny) || arr[ny][nx] != color) break;
            cnt++;
        }

        if (cnt != 5) return false;

        // 뒤(시작점 이전)가 같은 색이면 6목 이상 -> 실패
        int bx = x - dx[dir];
        int by = y - dy[dir];
        if (inRange(bx, by) && arr[by][bx] == color) return false;

        // 앞(끝점 다음)이 같은 색이면 6목 이상 -> 실패
        int fx = nx + dx[dir];
        int fy = ny + dy[dir];
        if (inRange(fx, fy) && arr[fy][fx] == color) return false;

        return true;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }
}
