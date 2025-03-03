package hanghee99;

import java.util.Scanner;
import java.util.Stack;

public class hh15_BOJ4949 {

    public static int size = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String s = sc.nextLine();
            if (s.equals(".")) break; // 종료 조건

            if (isBalanced(s)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        sc.close();
    }

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == ']') {
                if (stack.isEmpty()) return false; // 닫는 괄호가 나왔는데 스택이 비어 있음

                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[')) {
                    return false; // 짝이 맞지 않음
                }
            }
        }
        return stack.isEmpty(); // 스택이 비어 있으면 균형 잡힘
    }
}
