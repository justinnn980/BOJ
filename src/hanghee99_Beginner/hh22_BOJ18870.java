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
            dp[i] = arr[i];
        }

        Arrays.sort(dp);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        for (int i = 0; i < n; i++) {
            if(!map.containsKey(dp[i])){
                map.put(dp[i], rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }

}
