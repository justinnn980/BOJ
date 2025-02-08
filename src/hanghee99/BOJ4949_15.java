package hanghee99;

import java.util.Objects;
import java.util.Scanner;

public class BOJ4949_15 {

    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        stack = new int[100];

        while (true) {
            String s = sc.nextLine();

            if (Objects.equals(s, ".")) {
                break;
            }

            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '(' || c == '[') {
                    push(c);
                } else if (c == ')' || c == ']') {
                    int re = pop(c);
                    if (re == 7) {
                        System.out.println("NO");
                        break;
                    }
                } else if (c == '.') {
                    break;
                }
            }

            if (stack[0] == 0) {
                System.out.println("YES");
                size = 0;
            }
        }

    }

    private static void push(char c) {
        if (c == '(') {
            stack[size] = 1;
            size++;
        } else if (c == '[') {
            stack[size] = 2;
            size++;
        }
    }

    private static int pop(char c) {
        if (size != 0) {
            
        }
        return 0;
    }

}
