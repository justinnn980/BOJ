package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Day17_2_BOJ14891 {
    static int[][] gear;
    static int K;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gear = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = s.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            Change(g, c);
        }

        Score();

        System.out.println(result);
    }

    private static void Change(int g, int c) {
        int[] rotate = new int[4];
        //이것만 외워 몇번째 톱니를 어떻게 할건지
        rotate[g] = c;
        for (int i = g; i < 3; i++) {
            if (gear[i][2] != gear[i+1][6]) {
                rotate[i+1] = -rotate[i];
            } else {
                break;
            }
        }
        for (int i = g; i > 0; i--) {
            if (gear[i][6] != gear[i-1][2]) {
                rotate[i-1] = -rotate[i];
            } else {
                break;
            }
        }

        for (int i = 0; i<4; i++) {
            if (rotate[i] != 0) {
                rotateGear(i, rotate[i]);
            }
        }
    }

    private static void rotateGear(int idx, int dir) {
        if (dir == -1) {
            int temp = gear[idx][0];
            for (int i = 0; i < 7; i++) {
                gear[idx][i] = gear[idx][i+1];
            }
            gear[idx][7] = temp;
        } else {
            int temp = gear[idx][7];
            for (int i = 7; i > 0; i--) {
                gear[idx][i] = gear[idx][i-1];
            }
            gear[idx][0] = temp;
        }
    }

    private static void Score() {
        if (gear[0][0] == 1) result += 1;
        if (gear[1][0] == 1) result += 2;
        if (gear[2][0] == 1) result += 4;
        if (gear[3][0] == 1) result += 8;
    }
}
