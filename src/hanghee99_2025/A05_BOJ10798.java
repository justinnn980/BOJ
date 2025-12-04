package hanghee99_2025;

import java.util.Scanner;

public class A05_BOJ10798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[5][15];
        for (int i = 0; i < 5; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (arr[i][j] != '\u0000') {  // 비어 있지 않으면 출력
                    sb.append(arr[i][j]);
                }
            }
        }
        System.out.println(sb);
    }

}
