import java.util.Scanner;

public class BOJ2018  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        while(end_index != n){
            if (sum == n){ /// 같을 땐 카운트 더하고 다음 작업 실행
                count++;
                end_index++;
                sum = sum + end_index;
            } else if (sum > n) { /// 이전 값 더하기
                sum = sum - start_index;
                start_index++;
            } else if (sum < n) { /// 다음 작업 실행
                end_index++;
                sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}
