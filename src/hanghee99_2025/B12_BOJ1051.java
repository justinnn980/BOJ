package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12_BOJ1051 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = ch[j] - '0';
            }
        }

        int maxSize = Math.min(N, M);

        // size는 변의 길이 (큰거부터 1까지)
        for (int size = maxSize; size >= 1; size--) {
            int d = size - 1; // 오른쪽/아래로 이동 거리
            /*
            (r, c)           (r, c+d)

            (r+d, c)         (r+d, c+d)
            */
            for (int r = 0; r + d < N; r++) {
                for (int c = 0; c + d < M; c++) {
                    if (search(r, c, d)) {
                        System.out.println(size * size);
                        return;
                    }
                }
            }
        }
    }

    // (r,c)가 좌상단, d가 거리(size-1)
    static boolean search(int r, int c, int d) {
        int v = map[r][c];
        /* 아래 4개가 같으면 된다.
        map[r][c] ==
        map[r+d][c] ==
        map[r][c+d] ==
        map[r+d][c+d]
        */
        return v == map[r + d][c] && v == map[r][c + d] && v == map[r + d][c + d];
    }
}
