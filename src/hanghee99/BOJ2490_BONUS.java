package hanghee99;

import java.util.Scanner;

public class BOJ2490_BONUS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int zeroCount = 0;

        while (sc.hasNextLine()) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) break; // 빈 줄 입력 시 종료

            String[] s = input.split(" ");

            for (String str : s) {
                if (str.equals("0")) {
                    zeroCount++;
                }
            }

            if(zeroCount == 4){
                System.out.println("D");
            } else if(zeroCount == 1){
                System.out.println("A");
            } else if (zeroCount == 2) {
                System.out.println("B");
            } else if (zeroCount == 3){
                System.out.println("C");
            } else {
                System.out.println("E");
            }
            zeroCount = 0;
        }


    }
}
