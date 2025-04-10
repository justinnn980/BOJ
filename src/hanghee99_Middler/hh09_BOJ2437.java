package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class hh09_BOJ2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        String s = br.readLine();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        String[] strs = s.split(" ");
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(strs[i]));
        }
        for (int i = 0; i < n; i++) {
            arr[i] = pq.poll();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(sum + 1 < arr[i]) {
                break;
            }
            sum += arr[i];
        }
        System.out.println(sum +1);
    }

}
