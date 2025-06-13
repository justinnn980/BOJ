package hanghee99_Middler;

import java.util.HashMap;
import java.util.Map;

public class hh00_DP {
    /// 큰 문제를 여러 작은 문제로 나누어 푸는 해결 기법
    /// 풀어나가는 방법은 크게 2가지



    /// 탑 다운
    /// 목표 지점부터 처음올 내려오면서, 우리가 필요한 계산을 하는것

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int solution(int n) {
        if(memo.containsKey(n)) {
            return memo.get(n);
        }

        if(n <= 1) {
            return n;
        }

        int answer = solution(n-1) + solution(n-2);
        memo.put(n, answer);

        return answer;
    }





    /// 바텀 업
    /// 처음부터 목표 지점까지 진행하면서 계산을 하다가, 원하는 타겟점이 나오면 거기서 답을 꺼내는것.
    /// 모든 경우를 다 계산하기 때문에 > 데이터량이 너무 많으면 바텀업을 사용하기 힘들어짐
    /// 누적이 되어가는 경우 사용하기

    public static int solution2(int n) {
        if(n <= 1) {
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
