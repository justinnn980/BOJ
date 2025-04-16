package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hh12_BOJ2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ///  입력
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        /// 로직
        int[] dp = new int[n+1]; ///답을 계산할때 쓸 배열

        dp[1] = arr[0]; /// 1번째 잔

        if(n <= 1){ /// 1보다 작은 배열
            System.out.println(dp[n]);
            return;
        }

        dp[2] = dp[1] + arr[1]; /// 2번째 잔, 2잔을 연속으로 마실 수 있음

        if(n <= 2){ /// 2보다 작은 배열
            System.out.println(dp[n]);
            return;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-3] + arr[i-2] + arr[i-1];
            dp[i] = Math.max(dp[i], dp[i-2] + arr[i-1]);
            dp[i] = Math.max(dp[i], dp[i-1]);
        }

        /// 출력
        System.out.println(dp[n]);
    }
}
