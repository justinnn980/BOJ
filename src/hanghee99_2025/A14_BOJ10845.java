package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A14_BOJ10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int a = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch (s) {
                case "push":
                    a = Integer.parseInt(st.nextToken());
                    q.offer(a);
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        sb.append("-1");
                        sb.append("\n");
                        break;
                    } else {
                        sb.append(q.poll());
                        sb.append("\n");
                        break;
                    }
                case "size":
                    sb.append(q.size());
                    sb.append("\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        sb.append("1");
                        sb.append("\n");
                        break;
                    } else {
                        sb.append("0");
                        sb.append("\n");
                        break;
                    }
                case "front":
                    if (q.isEmpty()) {
                        sb.append("-1");
                        sb.append("\n");
                        break;
                    } else {
                        sb.append(q.peek());
                        sb.append("\n");
                        break;
                    }
                case "back":
                    if (q.isEmpty()) {
                        sb.append("-1");
                        sb.append("\n");
                        break;
                    } else {
                        sb.append(a);
                        sb.append("\n");
                        break;
                    }
            }
        }
        System.out.println(sb);
    }

}
