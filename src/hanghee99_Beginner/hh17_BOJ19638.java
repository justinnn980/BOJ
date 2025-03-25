package hanghee99_Beginner;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class hh17_BOJ19638 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");

        int n = Integer.parseInt(strs[0]);
        int h = Integer.parseInt(strs[1]);
        int t = Integer.parseInt(strs[2]);

        int[] arr = new int[n];
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }

        for (int i = 0; i < t; i++) {
            int max = pq.poll();

            if (max < h) {
                pq.add(max);
                break;
            }
            if (max == 1) {
                pq.add(max);
                break;
            }

            pq.add(max / 2);
            count++;
        }

        // 최대값 확인
        int maxValue = pq.peek();

        if(maxValue < h) {
            System.out.println("YES");
            System.out.println(count);
        } else {
            System.out.println("NO");
            System.out.println(maxValue);
        }
    }

}
