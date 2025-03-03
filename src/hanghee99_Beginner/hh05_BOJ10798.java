package hanghee99_Beginner;

import java.util.Scanner;

public class hh05_BOJ10798 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//
        String[] arr = new String[5];
        for (int j = 0; j < 5; j++) {
            arr[j] = sc.next();
        }

        // 최대 문자열 길이 계산
        int maxLength = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j].length() > maxLength) {
                maxLength = arr[j].length();
            }
        }

        // 세로로 읽어 출력
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i < arr[j].length()) { // 현재 문자열의 길이를 초과하지 않는 경우
                    char currentChar = arr[j].charAt(i);
                    System.out.print(currentChar);
                }
            }
        }

    }
}
