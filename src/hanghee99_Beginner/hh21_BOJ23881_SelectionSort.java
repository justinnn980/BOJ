package hanghee99_Beginner;

import java.util.Scanner;

public class hh21_BOJ23881_SelectionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 배열 크기
        int K = sc.nextInt(); // K번째 교환 횟수
        int[] arr = new int[N];

        // 배열 입력
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int swapCount = 0; // 교환 횟수 카운트

        // 선택 정렬 수행
        for (int last = N - 1; last > 0; last--) {
            int maxIndex = last;

            // A[0] ~ A[last] 중 최댓값 찾기
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }

            // 교환이 필요할 때만 진행
            if (maxIndex != last) {
                swap(arr, maxIndex, last);
                swapCount++;

                // K번째 교환이면 출력
                if (swapCount == K) {
                    int a = Math.min(arr[maxIndex], arr[last]);
                    int b = Math.max(arr[maxIndex], arr[last]);
                    System.out.println(a + " " + b);
                    return;
                }
            }
        }

        // K번째 교환이 발생하지 않은 경우
        System.out.println(-1);
    }

    // 배열 요소 교환 메서드
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
