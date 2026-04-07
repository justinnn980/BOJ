package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AI26_BOJ14891 {
    static int K;
    static int[][] gear = new int[4][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = s.charAt(j) - '0';
            }
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            reotateGear(num, dir);
        }

        int answer = 0;
        if (gear[0][0] == 1) answer += 1;
        if (gear[1][0] == 1) answer += 2;
        if (gear[2][0] == 1) answer += 4;
        if (gear[3][0] == 1) answer += 8;

        System.out.println(answer);
    }

    private static void reotateGear(int num, int dir) {
        int[] rotate = new int[4]; // 회전 방향 저장 배열
        rotate[num] = dir; // n번째 톱니 회전

        // 왼쪽 전파
        for (int j = num; j > 0; j--) {
            if (gear[j - 1][2] != gear[j][6]) {
                rotate[j - 1] = -rotate[j]; // 방향
            } else {
                break;
            }
        }

        // 오른쪽 전파
        for (int j = num; j < 3; j++) {
            if (gear[j][2] != gear[j + 1][6]) {
                rotate[j + 1] = -rotate[j];
            } else {
                break;
            }
        }

        // 실제 회전
        for (int j = 0; j < 4; j++) {
            if (rotate[j] != 0) {
                rotateOneGear(j, rotate[j]);
            }
        }
    }

    private static void rotateOneGear(int j, int i) {
        if (i == 1) {
            int temp = gear[j][7];
            for (int k = 7; k > 0; k--) {
                gear[j][k] = gear[j][k-1];
            }
            gear[j][0] = temp;
        } else {
            int temp = gear[j][0];
            for (int k = 0; k < 7; k++) {
                gear[j][k] = gear[j][k+1];
            }
            gear[j][7] = temp;
        }
    }
}