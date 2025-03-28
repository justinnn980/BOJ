package hanghee99_Beginner;

import java.io.*;
import java.util.*;

public class hh20_BOJ28107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer>[] orders = new ArrayDeque[200001];
        for (int i = 0; i < 200001; i++) orders[i] = new ArrayDeque<>();

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            while(k-->0) {
                orders[Integer.parseInt(st.nextToken())].add(i);
            }
        }
        st = new StringTokenizer(br.readLine());
        while(m-->0) {
            int susi = Integer.parseInt(st.nextToken());
            if (!orders[susi].isEmpty()) answer[orders[susi].pollFirst()] += 1; ///첫 번째 요소 제거 후 반환
        }

        for (int i = 0; i < n; i++) System.out.print(answer[i] + " ");
    }

}
