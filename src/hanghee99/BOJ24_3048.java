package hanghee99;

import java.util.Scanner;

public class BOJ24_3048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.nextLine();
        String[] arr = new String[n];
        String s1 = sc.nextLine();
        String[] arr1 = new String[m];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) + "";
            System.out.println(arr[i]);
        }
    }

}
