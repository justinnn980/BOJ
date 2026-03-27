package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AI41_BOJ14891 {
    static int[][] map;
    static int K, score;
    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] dir = new int[4];
            int num = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            dir[num] = d;

            //왼쪽으로
            for (int j = num; j > 0; j--) {
                if (map[j][6] != map[j-1][2]) {
                    dir[j-1] = -dir[j];
                } else {
                    break;
                }
            }

            //오른쪽으로
            for (int j = num; j < 3; j++) {
                if (map[j][2] != map[j+1][6]) {
                    dir[j+1] = -dir[j];
                } else {
                    break;
                }
            }

            for (int j = 0; j < 4; j++) {
                if (dir[j] != 0) roter(j, dir[j]);
            }

        }
        Score();
        System.out.println(score);
    }

    public static void Score() {
        if (map[0][0] == 1) score += 1;
        if (map[1][0] == 1) score += 2;
        if (map[2][0] == 1) score += 4;
        if (map[3][0] == 1) score += 8;
    }

    private static void roter(int num, int i) {
        if (i == 1){
            int temp = map[num][7];
            for (int k = 7; k > 0; k--) {
                map[num][k] = map[num][k-1];
            }
            map[num][0] = temp;
        }

        if (i == -1) {
            int temp = map[num][0];
            for (int k = 0; k < 7; k++) {
                map[num][k] = map[num][k+1];
            }
            map[num][7] = temp;
        }
    }


}
