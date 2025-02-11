package hanghee99;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ19638_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] parts = s.split(" "); // 입력값을 공백 기준으로 나누기

        int n = Integer.parseInt(parts[0]);
        int h = Integer.parseInt(parts[1]);
        int t = Integer.parseInt(parts[2]);

        int count = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < t; i++) {
            Arrays.sort(arr);
            if (arr[arr.length - 1] >= h && arr[arr.length - 1] != 1) {
                count++;
                arr[arr.length - 1] =  arr[arr.length - 1] / 2;
            } else {
                break;
            }

        }

        if (arr[arr.length - 1] < h && arr[arr.length - 1] != 0) {
            System.out.println("YES");
            System.out.println(count);
        } else {
            System.out.println("NO");
            System.out.println(arr[arr.length - 1]);
        }
    }

}
