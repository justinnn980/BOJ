package hanghee99_Beginner;

import java.util.Scanner;

public class hh25_BOJ31860 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int good = 0;
        int day = 0;
        int dayp = 0;
        int h = 0;
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            dayp += arr[i];
        }
        while (h < n) {

            if (arr[h] / m > k) {
                dayp++;
            } else {
                h++;
            }

        }

        for (int i = 1; i <= day; i++) {
            System.out.println(good);
        }
    }

}
