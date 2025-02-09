package hanghee99;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10828_Stack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String s = sc.next();

            switch (s) {
                case "push":
                    stack.push(sc.nextInt());
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                        break;
                    } else {
                        System.out.println(stack.peek());
                        stack.pop();
                        break;
                    }
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        System.out.println("1");
                        break;
                    }else {
                        System.out.println("0");
                        break;
                    }
                case "top":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                        break;
                    } else {
                        System.out.println(stack.peek());
                        break;
                    }
            }
        }

    }

}
