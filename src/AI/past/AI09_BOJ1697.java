package AI.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AI09_BOJ1697 {
    static int N, K;
    static int answer;
    static boolean[] visited = new boolean[100001];
    static int[] dist = new int[100001];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(p(N, K));
    }

    private static int p(int n, int k) {
        // 시작 위치
        q.offer(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == K) {
                return dist[x];
            }

            int[] next = {x - 1, x + 1, x * 2};

            for (int nx : next) {
                // 범위 체크
                if (nx < 0 || nx > 100000) continue;
                // 방문 체크
                if (visited[nx]) continue;
                // 방문 처리
                visited[nx] = true;
                // dist 갱신
                dist[nx] = dist[x] + 1;
                // 큐에 넣기
                q.add(nx);
            }
        }
        return -1;
    }
}