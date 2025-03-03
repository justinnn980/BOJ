package hanghee99_Beginner;

import java.util.Scanner;

public class hh08_BOJ32978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        for (int i = 0; i < n-1; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                if (s.equals(arr[j])) {
                    arr[j] = null;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != null) {
                System.out.println(arr[i]);
            }
        }
    }

}
