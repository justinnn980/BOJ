package hanghee99_Beginner;

import java.util.Scanner;

public class hh21_BOJ23881_SelectionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inputArgs = sc.nextLine().split(" ");
        int itemCount = Integer.parseInt(inputArgs[0]);
        int findAt = Integer.parseInt(inputArgs[1]);

        String[] numbers = sc.nextLine().split(" ");
        int[] arr = new int[itemCount];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        int changeCount = 0;

        for (int last = arr.length - 1; last >= 1; last--) {
            int maxIdx = last;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[maxIdx]) {
                    maxIdx = i;
                }
            }

            if (last != maxIdx) {
                int temp = arr[last];
                arr[last] = arr[maxIdx];
                arr[maxIdx] = temp;
                changeCount++;

                if (changeCount == findAt) {
                    System.out.println(
                        Math.min(arr[last], arr[maxIdx]) + " " + Math.max(arr[last], arr[maxIdx]));
                    break;
                }
            }

        }
        if (changeCount < findAt) {
            System.out.println(-1);
        }
    }
}
