package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class A09_BOJ31562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ",3);
            String value = s[2].substring(0, 5);


            map.put(value, map.containsKey(value) ? "?\n" : s[1] + "\n");
        }
        while (M-- > 0) {
            System.out.print(map.getOrDefault(br.readLine(), "!\n"));
        }
    }

}
