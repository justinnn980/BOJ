package hanghee99;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class hh16_BOJ1927_MinHeapLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        while (n-- > 0) {
            int x = sc.nextInt();
            if (x==0){
                if(pq.isEmpty()){
                    sb.append(-x).append("\n");
                } else {
                    sb.append(-pq.poll()).append("\n");
                }
            }
            else pq.offer(-x);
        }
        System.out.println(sb);
    }

}
