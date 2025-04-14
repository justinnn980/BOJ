package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hh11_BOJ16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        String[] arr = s.split(" ");
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(arr1);

        int left = 1;
        int right = arr1[n-1];

        while (left <= right) {
            int mid = (left + right) / 2; /// 중앙값

            int count = 0;

            ///해당 과자길이로 모든 조카들에게 같이 나눠줄 수 있는지 확인합니다.
            ///middle값인 5만큼 나눠준다고 생각하자.
            ///현재 과자길이보다 middle값이 작다면, 나눠줄수 있고, 해당과자를 몇번 나눠줄 수 있는지 확인한다.
            for (int i = 0; i < n; i++) {
                if (arr1[i] >= mid) {
                    count+=arr1[i]/mid;
                }
            }

            ///조카의 수보다 나눠준 값이 같거나 많다면,
            ///최대값이 아니다.
            ///나눠주는 값을 올려야 합니다.
            if (count >= m) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

}
