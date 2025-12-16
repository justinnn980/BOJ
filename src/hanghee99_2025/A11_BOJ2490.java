package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A11_BOJ2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue; // 안전장치

            StringTokenizer st = new StringTokenizer(line);
            int zero = 0;

            for (int i = 0; i < 4; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 0) zero++;
            }

            if (zero == 1) sb.append("A\n");
            else if (zero == 2) sb.append("B\n");
            else if (zero == 3) sb.append("C\n");
            else if (zero == 4) sb.append("D\n");
            else sb.append("E\n");
        }

        System.out.print(sb); // ✅ 여기서 한 번만 출력
    }
}