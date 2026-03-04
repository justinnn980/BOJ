package Blog;

import java.io.*;
import java.util.*;

public class Blog16_BOJ1260 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int[][] edges = new int[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(N, M, V, edges));
    }

    public static String solution(int N, int M, int V, int[][] edges) {

        answer = new StringBuilder();

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        // 리스트 초기화
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        // 간선 연결
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            A[u].add(v);
            A[v].add(u);
        }

        // 정렬 (번호 작은 것부터 방문)
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        // DFS
        DFS(V);

        answer.append("\n");

        // visited 초기화
        Arrays.fill(visited, false);

        // BFS
        BFS(V);

        return answer.toString();
    }

    private static void DFS(int node) {
        visited[node] = true;
        answer.append(node).append(" ");

        for (int next : A[node]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    private static void BFS(int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            answer.append(node).append(" ");

            for (int next : A[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}