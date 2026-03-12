package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AI19_BOJ14891 {
    static int K;
    static int[][] gear;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gear = new int[4][8];

        for (int i = 0; i<4; i++){
            String s = br.readLine();
            for(int j=0;j<8;j++){
                gear[i][j] = s.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());


        for (int i = 0; i < K; i++) {
            int[] dir = new int[4];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            //시작 톱니는 dir[x] = d
            dir[x] = d;

            //왼쪽 전파
            for (int j = x; j > 0; j--) {
                if (gear[j][6] != gear[j - 1][2]) {
                    dir[j - 1] = -dir[j];
                } else {
                    break;
                }
            }
            //오른쪽 전파
            for (int j = x; j < 3; j++) {
                if (gear[j][2] != gear[j + 1][6]) {
                    dir[j + 1] = -dir[j];
                } else {
                    break;
                }
            }
            //그 다음 실제 회전
            for (int j = 0; j < 4; j++) {
                if (dir[j] == 1) {
                    // 시계 회전
                    int temp = gear[j][7];
                    for (int k = 7; k > 0; k--) {
                        gear[j][k] = gear[j][k - 1];
                    }
                    gear[j][0] = temp;
                } else if (dir[j] == -1) {
                    // 반시계 회전
                    int temp = gear[j][0];
                    for (int k = 0; k < 7; k++) {
                        gear[j][k] = gear[j][k + 1];
                    }
                    gear[j][7] = temp;
                }
            }
        }
        int result = 0;
        if (gear[0][0] == 1) result += 1;
        if (gear[1][0] == 1) result += 2;
        if (gear[2][0] == 1) result += 4;
        if (gear[3][0] == 1) result += 8;
        System.out.println(result);
    }
}
