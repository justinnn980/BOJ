package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B05_BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);

        int left = 0; //첫번호
        int right = arr1.length - 1; //막번호

        int result = Integer.MAX_VALUE; // 가장 큰 값
        int ans1 = 0;
        int ans2 = 0;

        while (left < right) {
            int sum = arr1[left] + arr1[right]; //

            if (Math.abs(sum) < Math.abs(result)) {//절대값이 0 근처여야 실행
                result = sum;
                ans1 = arr1[left];//첫번호
                ans2 = arr1[right];//막번호
            }

            if (sum > 0) {//합이 양수면 더 작은값으로
                right--;
            } else {//합이 음수면 더 큰값으로
                left++;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }

}
