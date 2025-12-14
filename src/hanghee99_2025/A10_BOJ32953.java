package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class A10_BOJ32953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < a; j++) {
                String s = st.nextToken();
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        int result = 0;
        for (int value : map.values()) {
            if (value >= m) {
                result++;
            }
        }
        System.out.println(result);
    }

}
