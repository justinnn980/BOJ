package etc;

import java.util.Scanner;

public class BOJ11720 {

    public static void main(String[] args) {
        long m = 0;
        Scanner sc = new Scanner(System.in); /// 값넣기 준비
        int i = sc.nextInt();  /// i 값넣기
        String s = sc.next(); /// s 값넣기
        char[] str = s.toCharArray(); /// 하나하나 나누기

        for(int j = 0; j < i; j++) {
            ///아스키코드 삭제
            m = m + str[j] - 48;
        }
        System.out.println(m);
    }
}
