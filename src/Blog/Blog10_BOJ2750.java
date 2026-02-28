package Blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Blog10_BOJ2750 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Solution(arr);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void Solution(int[] arr) {
        Arrays.sort(arr);
    }
}
