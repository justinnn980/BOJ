package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class A06_BOJ27160 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int STRAWBERRY = 0;
        int BANANA = 0;
        int LIME = 0;
        int PLUM = 0;
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            if(Objects.equals(s, "STRAWBERRY")) {
                STRAWBERRY += number;
            } else if (Objects.equals(s, "BANANA")) {
                BANANA += number;
            } else if (Objects.equals(s, "LIME")) {
                LIME += number;
            } else if (Objects.equals(s, "PLUM")) {
                PLUM += number;
            }
        }
        if (STRAWBERRY == 5) {
            System.out.println("YES");
        } else if (BANANA == 5) {
            System.out.println("YES");
        } else if (LIME == 5) {
            System.out.println("YES");
        } else if (PLUM == 5) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
