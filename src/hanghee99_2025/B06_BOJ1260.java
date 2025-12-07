package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B06_BOJ1260 {
    static boolean[] visited;
    static int[][] graph;
    static int n;

    public static void main(String[] args) throws IOException {
        ///입력 N M V 정점의 개수, 간선의 개수, 정점의 번호
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점 개수(점)
        int m = Integer.parseInt(st.nextToken()); // 간선 개수(선)
        int v = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new int[n + 1][n + 1];

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1; /// a에서 b로 가는 간선 표시
            graph[b][a] = 1; /// b에서 a로 가는 간선도 표시 (무방향이므로 양쪽 다 설정)
        }

        visited = new boolean[n + 1]; /// 중복 방문을 막기 위한 배열
        dfs(v);
        System.out.println();

        visited = new boolean[n + 1];
        bfs(v);
        System.out.println();
    }

    // DFS 구현 (재귀)
    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 1; i <= n; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    // BFS 구현 (큐 사용)
    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");

            for (int i = 1; i <= n; i++) {
                if (graph[cur][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}