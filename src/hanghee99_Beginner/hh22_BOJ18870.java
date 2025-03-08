package hanghee99_Beginner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hh22_BOJ18870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = arr[i]; // 정렬을 위해 복사
        }

        Arrays.sort(dp); // 정렬 O(N log N)

        // 중복 제거 후, 값의 순위 매핑
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        for (int num : dp) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        // 결과를 StringBuilder에 저장 후 한 번에 출력 (출력 속도 최적화)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }

}
