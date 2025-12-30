package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A19_BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->{

            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            //절대값이 같은 경우 음수 우선
            if (first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            }
            return first_abs - second_abs; //절대값이 작은 데이터우선
        });

//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                int first_abs = Math.abs(o1);
//                int second_abs = Math.abs(o2);
//
//                if (first_abs == second_abs) {
//                    return o1 > o2 ? 1 : -1;
//                }
//                return first_abs - second_abs;
//            }
//        });

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if (x != 0) {
                pq.add(x);
            } else if (x == 0) {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
    }

}
