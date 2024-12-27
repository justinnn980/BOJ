import java.util.Scanner;

public class BOJ1546 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); /// 값넣기 준비
        int N = sc.nextInt();  /// 과목 개수 및 값 넣기
        float[] arr = new float[N]; /// 배열 선언
        int M = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] >= M) {
                M = (int) arr[i];
            }
        }

        for (int i = 0; i < N; i++) {
            arr[i] = arr[i]/M*100;
        }

        float Total = 0;

        for (int i = 0; i < N; i++) {
            Total += arr[i];
        }

        Total = Total / N;

        System.out.println(Total);
    }
}
