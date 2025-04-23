package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hh18_BOJ27971 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /// 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        /// 금지 구간 처리 (boolean 배열로)
        boolean[] forbidden = new boolean[N + 1]; // 0부터 N까지
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            for (int j = L; j <= R; j++) {
                if (j <= N) forbidden[j] = true;
            }
        }

        /// BFS
        int[] visited = new int[N + 1]; /// 최소 행동 수 저장
        Arrays.fill(visited, -1);  /// visited 배열의 모든 값을 -1로 초기화
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : new int[]{cur + A, cur + B}) {
                if (next <= N && !forbidden[next] && visited[next] == -1) {
                    visited[next] = visited[cur] + 1;
                    q.add(next);
                }
            }
        }



        /// 출력
        System.out.println(visited[N]);
    }

}
