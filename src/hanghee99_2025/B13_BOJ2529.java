package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B13_BOJ2529 {
    static int k;
    static char[] sign;
    static boolean[] used;
    static List<String> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        sign = new char[k];
        used = new boolean[10];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken().charAt(0);
        }
        result = new ArrayList<>();
        backTracking2529(0, "");
        Collections.sort(result);
        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }

    private static void backTracking2529(int index, String num) {
        if (num.length() == k+1) {
            result.add(num);
            return;
        }
        for (int i = 0; i < 10; i++) { // 0~9꺼지 탐색
            if (used[i]) {
                continue; // 이미 사용한 숫자는 스킵
            }
            if (num.isEmpty() || check2529(num.charAt(index-1)-'0', i, sign[index-1])){
                used[i] = true;
                backTracking2529(index+1, num + i);
                used[i] = false;
            }
        }
    }

    private static boolean check2529(int a, int b, char op) {
        if (op=='>')return a>b;
        else return a<b;
    }

}
