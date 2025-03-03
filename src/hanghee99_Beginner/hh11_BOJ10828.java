package hanghee99_Beginner;

import java.util.Scanner;

public class hh11_BOJ10828 {
    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        int N = sc.nextInt();

        stack = new int[N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();

            switch (s) {
                case "push":
                    push(sc.nextInt());
                    break;

                case "pop":
                    stringBuilder.append(pop()).append("\n");
                    break;

                case "size":
                    stringBuilder.append(size()).append('\n');
                    break;

                case "empty":
                    stringBuilder.append(empty()).append('\n');
                    break;

                case "top":
                    stringBuilder.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(stringBuilder);

    }

    public static void push(int x){
        stack[size] = x;
        size++;
    }

    public static int pop() {
        if(size == 0) return -1;
        else {
            int res = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return res;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if(size == 0) return -1;
        else return 0;
    }

    public static int top() {
        if(size == 0) return -1;
        else return stack[size - 1];
    }
}
