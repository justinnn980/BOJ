package hanghee99;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hh10_BOJ32953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        int count = 0;
        // 학생들의 수강 횟수를 저장할 HashMap
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            sc.nextLine();

            String[] studentIds = sc.nextLine().split(" ");

            for (int j = 0; j < studentIds.length; j++) {
                String studentId = studentIds[j];
                if (map.containsKey(studentId)) {
                    map.put(studentId, map.get(studentId) + 1);
                } else {
                    map.put(studentId, 1);
                }
            }
        }
        // M개 이상의 수업을 들은 학생 수 카운트
        for (int frequency : map.values()) {
            if (frequency >= m) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
