package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class A11_BOJ10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch (s) {
                case "push":
                    stack.push(Integer.valueOf(st.nextToken()));
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    } else {
                        sb.append(stack.pop());
                        sb.append("\n");
                        break;
                    }
                case "size":
                    sb.append(stack.size());
                    sb.append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        sb.append("1");
                        sb.append("\n");
                        break;
                    } else {
                        sb.append("0");
                        sb.append("\n");
                        break;
                    }
                case "top":
                    if (stack.isEmpty()) {
                        sb.append("-1");
                        sb.append("\n");
                        break;
                    } else {
                        sb.append(stack.peek());
                        sb.append("\n");
                        break;
                    }
            }

        }
        System.out.println(sb);
    }
}
