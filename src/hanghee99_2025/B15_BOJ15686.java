package hanghee99_2025;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15_BOJ15686 {
    static List<Point> chikenShops, homes;
    static int MinChickenDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        chikenShops = new ArrayList<>();
        homes = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) homes.add(new Point(r, c));
                else if (x == 2) chikenShops.add(new Point(r, c));
            }
        }

        chikenShopsCombination(0, M, new Point[M]);
        System.out.println(MinChickenDist);
    }

    private static void chikenShopsCombination(int si, int ti, Point[] picked) {
        if (ti == 0) {
            check15686(picked);
            return;
        }

        // ✅ 가지치기: 남은 가게 수 < 더 뽑아야 할 수 이면 종료
        if (chikenShops.size() - si < ti) return;

        for (int i = si; i < chikenShops.size(); i++) { // ✅ <= -> <
            picked[ti - 1] = chikenShops.get(i);
            chikenShopsCombination(i + 1, ti - 1, picked);
        }
    }

    private static void check15686(Point[] picked) {
        int distSum = 0;

        for (Point home : homes) {
            int minDist = Integer.MAX_VALUE;
            for (Point store : picked) {
                int dist = Math.abs(home.x - store.x) + Math.abs(home.y - store.y);
                minDist = Math.min(minDist, dist);
            }
            distSum += minDist;

            // (선택) 가지치기: 이미 최솟값보다 커지면 더 볼 필요 없음
            if (distSum >= MinChickenDist) return;
        }

        MinChickenDist = Math.min(distSum, MinChickenDist);
    }
}
