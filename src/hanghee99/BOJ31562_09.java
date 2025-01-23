package hanghee99;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ31562_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        Map<String, String> map = new HashMap<>();
        while (n-- > 0) {
            String[] arr = sc.nextLine().split(" ",3);
            String key = arr[2].substring(0, 5);

            map.put(key, map.containsKey(key) ? "?\n" : arr[1] + "\n");
        }
        while (m-- > 0) {
            System.out.print(map.getOrDefault(sc.nextLine(), "!\n"));
        }
    }

}
