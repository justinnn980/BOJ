package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hh20_BOJ17265 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int max = 0;
        int min = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
        }

        System.out.println(max);
        System.out.println(min);
    }

}
