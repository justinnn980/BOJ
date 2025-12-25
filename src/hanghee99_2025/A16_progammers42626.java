package hanghee99_2025;

import java.util.Arrays;
import java.util.PriorityQueue;

public class A16_progammers42626 {
    public static void main(String[] args) {
        int[] scoville;
        scoville = new int[]{1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(solution(scoville, k));
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.offer(s);
        }
        int answer = 0;

        while (pq.size() > 2 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();

            int mixed = first + (second * 2);
            pq.offer(mixed);
            answer ++;
        }

        return pq.peek() >= K ? answer : -1; /// 가장 위 값이 k보다 작으면 -1 출력
    }
}
