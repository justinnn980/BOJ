package hanghee99_Beginner;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hh09_BOJ31562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // 버퍼 초기화

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ",3);
            String value = s[2].substring(0, 5);

            map.put(value, map.containsKey(value) ? "?\n" : s[1] + "\n");
        }
        while (m-- > 0) {
            System.out.print(map.getOrDefault(sc.nextLine(), "!\n"));
        }
    }
}
