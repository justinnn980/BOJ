package hanghee99;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hh13_BOJ10845_Queue {

    public static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int n = sc.nextInt();
        int last = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.next();

            switch (s) {
                case "push":
                    last = sc.nextInt();
                    q.add(last);
                    break;

                case "pop":
                    if (q.isEmpty()) {
                        System.out.println("-1");
                        break;
                    } else {
                        System.out.println(q.peek());
                        q.poll();
                        break;
                    }

                case "size":
                    System.out.println(q.size());
                    break;

                case "empty":
                    if (q.isEmpty()) {
                        System.out.println("1");
                        break;
                    } else {
                        System.out.println("0");
                        break;
                    }

                case "front":
                    if (q.isEmpty()) {
                        System.out.println("-1");
                        break;
                    } else {
                        System.out.println(q.peek());
                    }
                    break;

                case "back":
                    if (q.isEmpty()) {
                        System.out.println("-1");
                        break;
                    } else {
                        System.out.println(last);
                        break;
                    }
            }
        }
    }

}
