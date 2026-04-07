package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AI35_BOJ15686 {
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
                if (map[i][j] == 1){
                    house.add(new int[]{i,j});
                } else if (map[i][j] == 2){
                    chicken.add(new int[]{i, j});
                }

            }
        }

        //선택된 치킨 집
        selected = new boolean[chicken.size()];

        dfs(0, 0);

        System.out.println(result);
    }

    private static void dfs(int idx, int count) {
        if (count == M) {
            calc();
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            selected[i] = true;
            dfs(i+1, count+1);
            selected[i] = false;
        }
    }

    private static void calc() {
        // 모든 집의 최소 치킨 거리 합
        int sum = 0;
        for (int[] h : house) {
            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                if (selected[i]) {
                    int[] c = chicken.get(i);
                    int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    minDist = Math.min(minDist, dist);
                }
            }
            sum += minDist;
        }
    }

}
