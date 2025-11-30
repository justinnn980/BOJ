package hanghee99_2025;

import java.util.*;

public class B01_BOJ2776 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int target = sc.nextInt();

                if (Arrays.binarySearch(arr, target) >= 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
/**
 import java.io.*;
 import java.util.*;

public class B01_BOJ2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                int target = Integer.parseInt(st.nextToken());
                if (Arrays.binarySearch(arr, target) >= 0) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        }

        System.out.print(sb);
    }
}
**/