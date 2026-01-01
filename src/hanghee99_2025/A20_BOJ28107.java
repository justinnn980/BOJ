package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A20_BOJ28107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer>[] orders = new ArrayDeque[200001];
        for (int i = 0; i < 200001; i++) orders[i] = new ArrayDeque<>();

        int[] bill = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            while(k-->0) {
                orders[Integer.parseInt(st.nextToken())].add(i);
            }
        }
        st = new StringTokenizer(br.readLine());
        while(m-->0) {
            int susi = Integer.parseInt(st.nextToken());
            if (!orders[susi].isEmpty()) {
                bill[orders[susi].pollFirst()] += 1;
            } ///첫 번째 요소 제거 후 반환
        }

        for (int i = 0; i < n; i++) {
            System.out.print(bill[i] + " ");
        }
    }
}
