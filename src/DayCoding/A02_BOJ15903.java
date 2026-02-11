package DayCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A02_BOJ15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long x = pq.poll();
            long y = pq.poll();
            long z = x + y;
            pq.offer(z);
            pq.offer(z);
        }
        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();

        }
        System.out.println(result);
    }

}
