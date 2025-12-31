package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11_BOJ1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j];
            }
        }

        int min = Integer.MAX_VALUE; /// 정답

        for (int x = 0; x <= N - 8; x++) {
            for (int y = 0; y <= M - 8; y++) {

                int w_cnt = 0; // (i,j) 기준 "W로 시작"일 때 다시 칠해야 하는 수

                for (int k = x; k < x + 8; k++) {
                    for (int l = y; l < y + 8; l++) {
                        char expected = ((k + l) % 2 == 0) ? 'W' : 'B';
                        if (map[k][l] != expected) w_cnt++;
                    }
                }

                min = Math.min(min, Math.min(w_cnt, 64 - w_cnt));
            }
        }

        System.out.println(min);
    }
}
