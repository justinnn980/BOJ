package hundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A02_BOJ1697 {
    static int N, K;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        dist = new int[100001];

        Sol();
    }

    private static void Sol() {
        Queue<Integer> q = new LinkedList<>();

        q.offer(N);
        visited[N] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) {
                System.out.println(dist[cur]);
                break;
            }

            int[] nexts = {cur - 1, cur + 1, cur * 2};

            for (int next : nexts) {
                if (next < 0 || next > 100000) continue;
                if (visited[next]) continue;

                visited[next] = true;
                dist[next] = dist[cur] + 1;
                q.offer(next);
            }
        }
    }
}
