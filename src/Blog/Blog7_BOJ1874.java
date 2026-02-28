package Blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Blog7_BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (A[i] >= num) {
                while (A[i]>= num){
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }else if(A[i] < num){
                int re = stack.pop();
                if (re != A[i]) {
                    System.out.println("NO");
                    return;
                }
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }

}
