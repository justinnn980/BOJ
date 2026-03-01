package Blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blog13_BOJ15649 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String result = solution(N, M);
        System.out.print(result);
    }

    // 👉 프로그래머스 스타일
    public static String solution(int n, int m) {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n + 1];
        int[] selected = new int[m];

        dfs(0, n, m, visited, selected, sb);

        return sb.toString();
    }

    private static void dfs(int depth, int n, int m, boolean[] visited, int[] selected, StringBuilder sb) {
        // 종료 조건
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = i;

                dfs(depth + 1, n, m, visited, selected, sb);

                visited[i] = false;  // 🔥 백트래킹 핵심
            }
        }
    }
}