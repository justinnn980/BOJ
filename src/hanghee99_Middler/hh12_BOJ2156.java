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
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            if(i==1){
                dp[1] = arr[0] + arr[1];
                continue;
            }
            if(i==2){
                dp[2] = Math.max(dp[1], Math.max(arr[0]+arr[2], arr[1]+arr[2]));
                continue;
            }
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i-1] + arr[i]));
        }

        /// 출력
        System.out.println(dp[n-1]);
    }
}
