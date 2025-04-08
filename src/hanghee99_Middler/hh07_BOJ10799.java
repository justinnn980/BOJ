package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class hh07_BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c); /// 열린 괄호면 스택에 넣음
            } else {
                stack.pop(); /// 닫힌 괄호면 스택에서 하나 꺼냄
                if (input.charAt(i-1) == '(') {
                    result += stack.size(); /// 이전 문자가 '(' 이면 레이저 -> 현재 스택 크기만큼 조각 추가
                } else {
                    result += 1; /// 쇠막대기의 끝이면 조각 하나 추가
                }
            }
        }
        System.out.println(result);

    }
}
