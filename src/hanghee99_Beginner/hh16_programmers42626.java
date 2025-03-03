package hanghee99_Beginner;

import java.util.PriorityQueue;

public class hh16_programmers42626 {
    public static void main(String[] args) {
        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            q.add(scoville[i]);
        }

        while (q.peek() < K) {
            if (q.size() == 1) return -1;

            q.add(q.poll() + (q.poll()) * 2);
            answer++;
        }
        return answer;
    }

}
