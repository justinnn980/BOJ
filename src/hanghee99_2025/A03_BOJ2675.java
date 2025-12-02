package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A03_BOJ2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S;

        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            S = st2.nextToken();
            for (int i = 0; i < S.length(); i++) {
                char t = S.charAt(i);
                for (int j = 0; j < a; j++) {
                    System.out.print(t);
                }
            }

            System.out.println();
        }

    }

}
