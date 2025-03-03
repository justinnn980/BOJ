package hanghee99;

import java.util.Scanner;

public class hh04_BOJ11945 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();


        for (int i = 0; i < x; i++) {
            char[] arr = sc.next().toCharArray();
            for (int j=y-1; j>=0; j--) {
                System.out.print(arr[j]);
            }
            System.out.println();
        }
    }
}
