package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day22_1_BOJ19237 {
    static int N,M,K;
    static int[][] map;
    static int[] sx,sy,sd; //위치 방향
    static boolean[] alive; //생존 여부
    static int[][][] priority;//번호,방향,우선순위
    static int[][] smellOwner;
    static int[][] smellTime;//남은 냄새 시간
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        sx = new int[M + 1];
        sy = new int[M + 1];
        sd = new int[M + 1];
        alive = new boolean[M + 1];

        priority = new int[M+1][5][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    int num = map[i][j];
                    sx[num] = i;
                    sy[num] = j;
                    alive[num] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            sd[i] = Integer.parseInt(st.nextToken());
        }

        //M번 반복
        for (int i = 1; i <= M; i++) {
            //위 왼 아래 오
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                //우선순위
                for (int k = 0; k < 4; k++) {
                    priority[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        //냄새 남기기
        for (int i = 1; i <= M; i++) {
            if (alive[i]){
                smellOwner[sx[i]][sy[i]] = i;
                smellTime[sx[i]][sy[i]] = K;
            }
        }

        //상어 없어질때까지 ㄱㄱ
        int time = 0;
        while (time < 1000) {
            time++;

            //임시배열
            int[] nsx = new int[M + 1];
            int[] nsy = new int[M + 1];
            int[] nsd = new int[M + 1];

            //상어가 이동할 칸 결정
            sharkMoved(nsx, nsy, nsd);

            int[][] nextMap = new int[N][N];

            //충돌 처리해서 작은 번호만 생존
            for (int i = 1; i <= M; i++) {
                if (!alive[i]) continue;

                int nx = nsx[i];
                int ny = nsy[i];

                if (nextMap[nx][ny] == 0) {
                    nextMap[nx][ny] = i;
                } else {
                    //이미 자리에 상어가 있으면 죽음
                    alive[i] = false;
                }
            }


            // 위치 갱신
            for (int i = 1; i <= M; i++) {
                if (!alive[i]) continue;
                sx[i] = nsx[i];
                sy[i] = nsy[i];
                sd[i] = nsd[i];
            }

            map = nextMap;

            //냄새 1 감소
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (smellTime[i][j] > 0) {
                        smellTime[i][j]--;
                        if (smellTime[i][j] == 0) smellOwner[i][j] = 0;
                    }
                }
            }

            //살아있는 상어가 새 냄새 남김
            for (int i = 1; i <= M; i++) {
                if (!alive[i]) continue;
                smellOwner[sx[i]][sy[i]] = i;
                smellTime[sx[i]][sy[i]] = K;
            }

            //1번만 남았는지 확인
            int cnt = 0;
            for (int i = 1; i <= M; i++) {
                if (alive[i]) cnt++;
            }
            if (cnt == 1 && alive[1]){
                System.out.println(time);
                return;
            }
        }
        System.out.println(-1);
    }

    private static void sharkMoved(int[] nsx,int[] nsy,int[] nsd) {
        //상어가 이동할 칸 결정
        for (int i = 1; i <= M; i++) {
            if (!alive[i]) continue;

            // i번 상어의 다음 칸 결정
            boolean moved = false;

            //냄새 없는 칸 찾기
            for (int j = 0; j < 4; j++) {
                int nd = priority[i][sd[i]][j];
                int nx = sx[i] + dx[nd];
                int ny = sy[i] + dy[nd];

                if (nx<0||ny<0||nx>=N||ny>N) continue;
                //냄새 없다면 이동
                if (smellTime[nx][ny] == 0) {
                    nsx[i] = nx;
                    nsy[i] = ny;
                    nsd[i] = nd;
                    moved = true;
                    break;
                }
            }

            //2. 없으면 자기 냄새 칸 찾기
            if (!moved) {
                for (int j = 0; j < 4; j++) {
                    int nd = priority[i][sd[i]][j];
                    int nx = sx[i] + dx[nd];
                    int ny = sy[i] + dy[nd];

                    if (nx<0||ny<0||nx>=N||ny>N) continue;
                    //냄새 없다면 이동
                    if (smellOwner[nx][ny] == i && smellTime[nx][ny] > 0) {
                        nsx[i] = nx;
                        nsy[i] = ny;
                        nsd[i] = nd;
                        break;
                    }
                }
            }
        }
    }
}
