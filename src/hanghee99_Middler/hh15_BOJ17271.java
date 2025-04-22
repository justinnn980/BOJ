package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hh15_BOJ17271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /// 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[Math.max(2,n+1)];
        dp[0] = 1; // i == M일때 B가 추가되는 경우의 수 때문에 1로 채웁니다.
        dp[1] = 1;
        int divNum = 1_000_000_007;
        for (int i = 2; i <= n; i++) {
            if(i<m) {
                dp[i] = dp[i-1]%divNum;
            }else {
                dp[i] = (dp[i-1] + dp[i-m])%divNum;
            }
        }



        /// 출력
        System.out.println(dp[n]);

    }


}
