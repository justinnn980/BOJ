package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hh05_BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 첫 번째 K일의 합 구하기
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int max = sum;

        // 슬라이딩 윈도우 기법 적용
        for (int i = k; i < n; i++) {
            sum = sum - arr[i - k] + arr[i]; // 앞의 값을 빼고 새로운 값을 추가
            max = Math.max(max, sum); // 최대값 갱신
        }

        System.out.println(max);
    }

}
