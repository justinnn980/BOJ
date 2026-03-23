package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AI33_BOJ15686 {
    static int N, M;
    static int[][] map;
    static int result = Integer.MAX_VALUE;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static boolean[] selected;

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
                if (map[i][j] == 1) {
                    house.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        selected = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int start, int count) {
        if (count == M) {
            // 거리 계산
            result = Math.min(result, getDistance());
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            // i번째 치킨집 선택
            selected[i] = true;
            dfs(i + 1, count + 1);
            // 선택 취소
            selected[i] = false;
        }
    }

    static int getDistance() {
        int sum = 0;

        for (int[] h : house) {
            int hx = h[0];
            int hy = h[1];
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < chicken.size(); i++) {
                if (!selected[i]) continue;

                int cx = chicken.get(i)[0];
                int cy = chicken.get(i)[1];

                int dist = Math.abs(hx - cx) + Math.abs(hy - cy);
                min = Math.min(min, dist);
            }

            sum += min;
        }

        return sum;
    }
}
