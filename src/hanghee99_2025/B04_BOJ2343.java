package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B04_BOJ2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int left = 0; // 가장 긴 레슨 길이
        int right = 0; // 모든 레슨 길이의 합
        int result = 0;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            left = Math.max(left, arr[i]); // 최소 크기는 가장 긴 레슨보다 큼
            right += arr[i];
        }

        result = right;

        while (left <= right) {
            int mid = (left + right) / 2; // 이분 값

            int count = 1; // 필요 개수
            int sum = 0; // 현재 비디오에 저장된 레슨들의 총 길이
            // time = 지금 넣으려는 레슨 길이
            for (int time : arr) {
                // 지금 넣으려는 레슨을 넣으면 용량을 초과하는지 검사
                // 초과하면 새로운 비디오가 필요
                if (sum + time > mid) {
                    count++;
                    sum = 0;
                }
                // 초과하지 않으면 → 기존 블루레이에 이어서 넣음
                sum += time;
            }

            if (count <= M) {
                // mid 크기로도 m개 이하 블루레이에 담을 수 있다면 더 줄일 수 있다.
                result = mid;
                right = mid - 1;
            } else {
                // mid 가 너무 적어서 개수가 초과 됨.
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

}
