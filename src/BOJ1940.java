import java.util.Arrays;
import java.util.Scanner;

public class BOJ1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();

        long[] arr = new long[(int) n];
        for(int i = 1; i <= n; i++) {
            arr[i - 1] = sc.nextLong();
        }
        int a = 0;
        int b = (int) (n-1);

        Arrays.sort(arr);
        int count = 0;
        while (a<b){
            if(arr[a]+arr[b]<m){
                a++;
            } else if (arr[a] + arr[b] > m) {
                b--;
            }else {
                count++;
                a++; b--;
            }
        }
        System.out.println(count);
    }
}
