package etc;

import java.util.Scanner;

public class BOJ1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String o = sc.next(); /// o 값넣기
        char[] str = o.toCharArray(); /// 하나하나 나누기

        /// 직접 버블 정렬 방식으로 내림차순 구현
        for (int i = 0; i < str.length - 1; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i] < str[j]) {
                    char temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }

        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
    }
}
