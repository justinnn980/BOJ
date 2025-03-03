package hanghee99_Beginner;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class hh18_BOJ14235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a == 0) {
                if(pq.isEmpty()){
                    sb.append("-1").append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                for (int j = 0; j < a; j++) {
                    pq.offer(sc.nextInt());
                }
            }
        }
        System.out.print(sb);
    }

}
