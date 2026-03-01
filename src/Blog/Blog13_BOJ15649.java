package Blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blog13_BOJ15649 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String result = solution(N, M);
        System.out.print(result);
    }

    // 👉 프로그래머스 스타일
    public static String solution(int n, int m) {

        // 여기에 백트래킹 로직 작성

        return "";
    }
}