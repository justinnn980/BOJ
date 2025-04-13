package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hh10_BOJ1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0;
        if(n == 1){
            count = 1;
        } else if(n == 2){
            count = Math.min(4, ((m+1)/2));
        } else if(m<7){
            count = Math.min(4,m);
        } else if(m>=7){
            count = m -2;
        }

        System.out.println(count);
    }

}
