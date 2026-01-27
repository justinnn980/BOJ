package etc;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11286 { ///우선순위 큐
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->{

            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            //절대값이 같은 경우 음수 우선
            if (first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            }
            return first_abs - second_abs; //절대값이 작은 데이터우선
        });

        for(int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            if(x == 0) {
                if(pq.isEmpty()){
                    System.out.println("0");
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(x);
            }
        }
    }
}
