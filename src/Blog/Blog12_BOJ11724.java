package Blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Blog12_BOJ11724 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] edges = new int[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, edges));
    }

    public static int solution(int n, int[][] edges) {
        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        // 배열각 하나에 arraylist 넣기
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            A[u].add(v);
            A[v].add(u);
        }
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        return count;
    }




    // 👉 프로그래머스 스타일
    public static int solution2(int n, int[][] edges) {

        visited = new boolean[n + 1];
        A = new ArrayList[n + 1];

        // 인접 리스트 초기화
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
        }

        // 간선 연결
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            A[u].add(v);
            A[v].add(u);
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        return count;
    }

    private static void DFS(int node) {
        visited[node] = true;

        for (int next : A[node]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }
}