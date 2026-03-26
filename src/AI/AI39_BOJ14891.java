package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class AI39_BOJ14891 {
    static int K;
    static int[][] arr = new int[4][8];
    static int score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String a = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = a.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());


        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] dir = new int[4];   // 각 톱니가 이번에 어떻게 회전할지 저장
            int num = Integer.parseInt(st.nextToken()) - 1; // 1~4번을 0~3번으로 변환
            int d = Integer.parseInt(st.nextToken()); // 회전 방향

            dir[num] = d;

            //톱니 기준 왼쪽
            for (int j = num; j > 0; j--) {
                if (arr[j][6] != arr[j - 1][2]) {
                    dir[j - 1] = -dir[j];
                } else {
                    break;
                }
            }


            //톱니 기준 오른쪽
            for (int j = num; j < 3; j++) {
                if (arr[j][2] != arr[j + 1][6]) {
                    dir[j + 1] = -dir[j];
                } else {
                    break;
                }
            }


            for (int j = 0; j < 4; j++) {
                if (dir[j] != 0) {
                    rotate(j, dir[j]);
                }
            }

        }
        Score();

        System.out.println(score);

    }

    private static void Score() {
        if (arr[0][0] == 1) {
            score += 1;
        }
        if (arr[1][0] == 1) {
            score += 2;
        }
        if (arr[2][0] == 1) {
            score += 4;
        }
        if (arr[3][0] == 1) {
            score += 8;
        }
    }

    private static void rotate(int idx, int d) {
        if (d == 1) {
            int temp = arr[idx][7];
            for (int i = 7; i > 0; i--) {
                arr[idx][i] = arr[idx][i - 1];
            }
            arr[idx][0] = temp;
        } else if (d == -1) {
            int temp = arr[idx][0];
            for (int i = 0; i < 7; i++) {
                arr[idx][i] = arr[idx][i + 1];
            }
            arr[idx][7] = temp;
        }

    }


}
