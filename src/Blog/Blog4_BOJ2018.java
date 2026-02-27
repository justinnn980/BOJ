package Blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blog4_BOJ2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start_index = 1;
        int end_index = 1;
        int count = 0;
        int sum = 1;
        int N = Integer.parseInt(br.readLine());
        while (start_index <= N) {
            if(sum == N){
                count++;
                sum = sum - start_index;
                start_index++;
            } else if (sum < N) {
                end_index++;
                sum = sum + end_index;
            } else {
                sum = sum - start_index;
                start_index++;
            }
        }
        System.out.print(count);

    }
}
