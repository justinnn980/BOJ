package hanghee99_Beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class hh23_BOJ1524 {
    public static void main(String[] args) throws IOException { /// 버퍼리더 예외처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {

            // 최대값 변수
            int maxS = 0;  // 세준이 군대 최댓값
            int maxB = 0;  // 세비 군대 최댓값

            // 세준이 군대의 최댓값 찾기
            
            // 세비 군대의 최댓값 찾기

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
