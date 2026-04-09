package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day19_1_BOJ17144 {
    static int R, C, T;
    static int[][] A;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        A = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int z = 0; z < T; z++) {
            //확산
            spread();

            //위쪽 공기청정기위치
            int topx = 0;
            //아래쪽 공기청정기위치
            int bottomx = 0;
            for (int j = 0; j < R; j++) {
                if (A[j][0] == -1) {
                    //위쪽 공기청정기위치
                    topx = j;
                    //아래쪽 공기청정기위치
                    bottomx = j + 1;
                    break;
                }
            }
            //위쪽 순환
            // 위쪽 공기청정기 (반시계)
            for (int i = topx - 1; i > 0; i--) A[i][0] = A[i - 1][0]; // 왼쪽 열 (아래 → 위)
            for (int i = 0; i < C - 1; i++) A[0][i] = A[0][i + 1];   // 위쪽 행 (왼 → 오)
            for (int i = 0; i < topx; i++) A[i][C - 1] = A[i + 1][C - 1]; // 오른쪽 열 (위 → 아래)
            for (int i = C - 1; i > 1; i--) A[topx][i] = A[topx][i - 1];  // 아래쪽 행 (오 → 왼)

            // 공기청정기 바로 오른쪽은 0
            A[topx][1] = 0;
            // 아래쪽 공기청정기 (시계)
            for (int i = bottomx + 1; i < R - 1; i++) A[i][0] = A[i + 1][0]; // 왼쪽 열 (위 → 아래)
            for (int i = 0; i < C - 1; i++) A[R - 1][i] = A[R - 1][i + 1];   // 아래쪽 행 (왼 → 오)
            for (int i = R - 1; i > bottomx; i--) A[i][C - 1] = A[i - 1][C - 1]; // 오른쪽 열 (아래 → 위)
            for (int i = C - 1; i > 1; i--) A[bottomx][i] = A[bottomx][i - 1];  // 위쪽 행 (오 → 왼)

            // 공기청정기 바로 오른쪽은 0
            A[bottomx][1] = 0;
        }

        int result = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] > 0) {
                    result += A[i][j];
                }
            }
        }

        System.out.println(result);
    }

    private static void spread() {
        int topx = 0, bottomx = 0;
        for (int i = 0; i < R; i++) {
            if (A[i][0] == -1) {
                topx = i;
                bottomx = i + 1;
                break;
            }
        }

        int[][] temp = new int[R][C];
        temp[topx][0] = -1;
        temp[bottomx][0] = -1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] > 0) {
                    spreadMicroDust(i, j, temp);
                }
            }
        }

        A = temp;
    }

    private static void spreadMicroDust(int i, int j, int[][] temp) {
        int count = 0;
        int spreadAmount = A[i][j] / 5;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (A[nx][ny] == -1) continue;

            temp[nx][ny] += spreadAmount;
            count++;
        }

        temp[i][j] += A[i][j] - (spreadAmount * count);
    }
}
