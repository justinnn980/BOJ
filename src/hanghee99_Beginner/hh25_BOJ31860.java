package hanghee99_Beginner;

import java.io.*;
import java.util.*;

public class hh25_BOJ31860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 해야 할 일의 개수
        int m = Integer.parseInt(st.nextToken()); // 중요도 감소량
        int k = Integer.parseInt(st.nextToken()); // 완료 기준 중요도

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int day = 0;  // 총 걸린 날짜
        int Y = 0;    // 전날 만족도
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int P = pq.poll(); // 현재 가장 높은 중요도 선택

            if (P <= k) continue; // 이미 완료된 일은 건너뜀

            day++;
            int T = (Y / 2) + P; // 오늘의 만족감 계산
            sb.append(T).append("\n");
            Y = T; // 다음 날을 위해 업데이트

            P -= m; // 중요도 감소 후 다시 큐에 삽입
            if (P > k) {
                pq.offer(P);
            }
        }

        // 총 걸린 날짜 출력
        System.out.println(day);
        System.out.print(sb.toString());
    }
}

