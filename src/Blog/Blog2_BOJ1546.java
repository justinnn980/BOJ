package Blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blog2_BOJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        double max = 0;
        double sum = 0;

        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(sum * 100 / max / n);
    }
}
