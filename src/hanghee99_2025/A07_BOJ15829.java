package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A07_BOJ15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        long mod = 1234567891;
        long result = 0;
        long pow = 1; //r^0 = 1
        for (int i = 0; i < L; i++) {
            int a = s.charAt(i) - 'a' + 1; //아스키코드
            result = (result + a * pow) % mod; // 문제의 값
            pow = (pow * 31) % mod;         // i 0 이후 값 r = 31

        }
        System.out.println(result);
    }

}
