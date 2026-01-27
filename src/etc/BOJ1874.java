package etc;

import java.util.Scanner;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        int count = 1;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean result = true;

        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i<arr.length; i++) {
            int su = arr[i];
            if (su >= count) {
                while (su >= count) {
                    stack.push(count++);
                    buffer.append("+\n");
                }
                stack.pop();
                buffer.append("-\n");
            } else {
                int j = stack.pop();
                if (j > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    buffer.append("-\n");
                }
            }
        }
        if(result) System.out.println(buffer.toString());
    }
}
