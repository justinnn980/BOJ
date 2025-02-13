package hanghee99;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11286_absHeapLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->{

            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            //절대값이 같은 경우 음수 우선
            if (first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            }
            return first_abs - second_abs; //절대값이 작은 데이터우선
        });

        while (n-- > 0) {
            int x = sc.nextInt();
            if (x==0){
                if(pq.isEmpty()){
                    sb.append("0").append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            }
            else pq.add(x);
        }
        System.out.println(sb);
    }

}
