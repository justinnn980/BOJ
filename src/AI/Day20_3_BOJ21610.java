package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day20_3_BOJ21610 {
    static int N,M;
    static int[][] map;
    static int water;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //첫 비구름 만들기

        for (int z = 0; z < M; z++) {
            int[][] copyMap = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    copyMap[i][j] = map[i][j];
                    if (copyMap[i][j] > 2) {

                    }
                }
            }

            //비구름 이동하기

            //구름 있는 곳에 물양 1씩 증가하기 and 기억하기

            //기억한 칸에 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니 수 만큼 바기누의 물양 증가 시키기

            //바구니에 저장된 물양이 2이상이면서 기억한 칸이 아닌곳에 구름 만들기

        }
    }
}
