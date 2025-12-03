package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A04_BOJ11945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int[] arr = new int[M];
            for (int j = 0; j < M; j++) {
                arr[j] = s.charAt(j) - '0';
            }
            for (int j = M; j > 0; j--) {
                System.out.print(arr[j-1]);
            }
            System.out.println();
        }
    }

}
