package hanghee99_Beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hh23_BOJ1524 {
    public static void main(String[] args) throws IOException { /// 버퍼리더 예외처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String L = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 최대값 변수
            int maxS = 0;  // 세준이 군대 최댓값
            int maxB = 0;  // 세비 군대 최댓값

            // 세준이 군대의 최댓값 찾기
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int S = Integer.parseInt(st.nextToken());

                if(maxS < S) maxS = S;
            }
            // 세비 군대의 최댓값 찾기
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int B = Integer.parseInt(st.nextToken());

                if(maxB < B) maxB = B;
            }

            // 승자 판별
            if (maxS > maxB) {
                System.out.println("S");
            } else if (maxS < maxB) {
                System.out.println("B");
            } else {
                System.out.println("S");
            }
        }
    }
}
