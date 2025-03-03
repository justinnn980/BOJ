package hanghee99;

import java.util.Scanner;

public class BOJ13_10845 {
    public static int[] queue;
    public static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        queue = new int[n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();

            switch (s){
                case "push":
                    push(sc.nextInt());
                    break;

                case "pop":
                    sb.append(pop()).append("\n");
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "front":
                    sb.append(front()).append('\n');
                    break;

                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int x){
        queue[size] = x;
        size++;
    }

    public static int pop() {
        if(size == 0) return -1;
        else {
            int res = queue[0];
            for(int i = 0; i < size; i++) {
                queue[i] = queue[i+1];
            }
            size--;
            return res;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) return 1;
        else return 0;
    }

    public static int front() {
        if (size == 0) return -1;
        else return queue[0];
    }

    public static int back() {
        if (size == 0) return -1;
        else return queue[size - 1];
    }
}
