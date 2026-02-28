package Blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blog6_BOJ12891 {
    static int myArr[] = new int[4];
    static int checkArr[] = new int[4];
    static int checkSecret = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int count = 0;

        char[] arr = br.readLine().toCharArray(); //배열에 전체 문자열 저장
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken()); // 정답 배열 저장
            if (checkArr[i] == 0){
                checkSecret++; //이게 4면 정답에 1 증가
            }
        }

        for (int i = 0; i < P; i++) { //처음 값 세팅
            Add(arr[i]);
        }
        if (checkSecret == 4) count++; //이게 4면 정답에 1 증가

        //슬라이딩 원도우
        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(arr[i]);
            Remove(arr[j]);  // ✅ 이게 맞음
            if (checkSecret == 4) count++;
        }
        System.out.println(count);
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
}
