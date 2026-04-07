package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AI37_BOJ14889 {
    static int N;
    static int[][] map;
    static int result;
    static boolean[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N  = Integer.parseInt(st.nextToken());

        map  = new int[N][N];
        selected = new boolean[N];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0,0);
        System.out.println(result);
    }

    private static void comb(int idx, int depth) {
        if (depth == N / 2) {
            calc();
            return;
        }

        for (int i = idx; i < N; i++) {
            selected[i] = true;
            comb(i + 1, depth + 1);
            selected[i] = false;
        }
    }

    private static void calc() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (selected[i] && selected[j]) {
                    start += map[i][j] + map[j][i];
                } else if (!selected[i] && !selected[j]) {
                    link += map[i][j] + map[j][i];
                }
            }
        }

        result = Math.min(result, Math.abs(start - link));

    }
}
