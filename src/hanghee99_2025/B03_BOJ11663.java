package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B03_BOJ11663 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int result = 0;

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            // b 이하의 개수 - a 미만의 개수
            int right = upperBound(arr, b);
            int left = lowerBound(arr, a);

            sb.append(right - left).append("\n");
        }

        System.out.print(sb);
    }

    // arr에서 value 이상이 처음 나타나는 위치
    public static int lowerBound(int[] arr, int value) {
        int left = 0;
        int right = arr.length; // 주의! length

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= value)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    // arr에서 value 보다 큰 값이 처음 나타나는 위치
    public static int upperBound(int[] arr, int value) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > value)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
