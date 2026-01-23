package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B25_BOJ1351 {
    static long P, Q;
    static Map<Long, Long> memo = new HashMap<>();

    static long A(long n) {
        if (memo.containsKey(n)) return memo.get(n);

        long value = A(n / P) + A(n / Q);
        memo.put(n, value);
        return value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        memo.put(0L, 1L); // A0 = 1

        System.out.println(A(N));
    }
}
