package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16_BOJ27961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine().trim());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        long pow = 1; // 2^t
        int t = 0;
        while (pow < N) {
            pow <<= 1;
            t++;
        }

        // 생성 1번 + 복제 t번
        System.out.println(t + 1);
    }
}
