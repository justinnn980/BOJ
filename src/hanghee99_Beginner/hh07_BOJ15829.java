package hanghee99_Beginner;

import java.util.Scanner;

public class hh07_BOJ15829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        String s = sc.next();
        long total = 0;
        double pow = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            double count = (c-96)*pow;
            pow = (pow * 31) % 1234567891;
            total += count;
        }
        System.out.println(total % 1234567891);
    }
}
