package hanghee99_Beginner;

import java.util.Scanner;

public class hh12_BOJ17608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int top = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int j=n-1; j>=0; j--) {
            if (arr[j] > top) {
                count++;
                top = arr[j];
            }
        }
        System.out.println(count);
    }

}
