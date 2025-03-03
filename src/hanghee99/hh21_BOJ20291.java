package hanghee99;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class hh21_BOJ20291 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] parts = s.split("\\."); // 입력값을 공백 기준으로 나누기
            map.put(parts[1], map.getOrDefault(parts[1], 0) + 1);
        }
        TreeMap<String, Integer> sortedMap = new TreeMap<>(map);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
