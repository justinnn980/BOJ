package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A17_BOJ19638 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Integer.parseInt(st.nextToken()));
        }

        while (T-- > 0) {
            int top = pq.poll();

            if (top < H) {
                pq.add(top);
                break;
            }

            if (top == 1){
                pq.add(top);
                break;
            }

            top = top/2;
            pq.add(top);
            count++;
        }

        if (pq.peek() < H){
            System.out.println("YES");
            System.out.println(count);
        } else if (pq.peek() >= H) {
            System.out.println("NO");
            System.out.println(pq.peek());
        }
    }

}
