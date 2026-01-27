package etc;

import java.util.Scanner;

public class BOJ11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] prefixSum = new int[N + 1];

        // 1부터 N까지 입력 받기 (0번째 인덱스는 사용 안 함)
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // 구간 합 구하기
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(prefixSum[y] - prefixSum[x - 1]);
        }

    }
}
