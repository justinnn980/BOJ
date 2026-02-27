package Blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blog1_BOJ11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        String ss = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = ss.charAt(i) - '0';
        }
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            if(i == 0) {
                s[i] = arr[i];
            } else {
                s[i] = s[i-1] + arr[i];
            }
        }
        System.out.println(s[n-1]);

    }
}
