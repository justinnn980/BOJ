package Blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Blog9_BOJ11286 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Solution(arr);
        System.out.println(sb);
    }

    private static void Solution(int[] x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (Math.abs(a) == Math.abs(b)) {
                        return a - b; // 절댓값 같으면 실제 값 작은 것 우선
                    }
                    return Math.abs(a) - Math.abs(b);
                }
        );
        for (int i = 0; i < N; i++) {
            if(x[i] == 0){
                if (!pq.isEmpty()){
                    sb.append(pq.poll()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }

            } else {
                pq.add(x[i]);
            }
        }
    }
}
