package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A08_BOJ32978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N-1; i++) {
            String s = st.nextToken();
            for (int j = 0; j < N; j++) {
                if (s.equals(arr[j])) {
                    arr[j] = null;
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (arr[i] != null) {
                System.out.println(arr[i]);
            }
        }
    }

}
