package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B18_BOJ17503 {
    static class Beer {
        int v; // preference
        int c; // alcohol
        Beer(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //기간
        int M = Integer.parseInt(st.nextToken()); //선호도
        int K = Integer.parseInt(st.nextToken()); //맥주 종류 수
        Beer[] beers = new Beer[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            beers[i] = new Beer(v, c);
        }
        // 도수 오름차순(같으면 선호도 오름차순은 필수는 아님)
        Arrays.sort(beers, (a, b) -> {
            if (a.c != b.c) return Integer.compare(a.c, b.c);
            return Integer.compare(a.v, b.v);
        });

        // 지금까지 본 맥주 중 "선호도"를 N개 유지 (가장 작은 선호도부터 빼기)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumPref = 0;

        for (int i = 0; i < K; i++) {
            minHeap.add(beers[i].v);
            sumPref += beers[i].v;

            if (minHeap.size() > N) {
                sumPref -= minHeap.poll();
            }

            // N개를 유지하면서 합이 M 이상이면, 현재 도수(c)가 가능한 최소
            if (minHeap.size() == N && sumPref >= M) {
                System.out.println(beers[i].c);
                return;
            }
        }

        System.out.println(-1);
    }



}
