package DBFS;

import java.io.*;
import java.util.*;

public class dfs2 {   // 백준 제출 시 클래스 이름은 Main

    static int N, M, V;
    static List<Integer>[] adj;
    static boolean[] visited;

    static StringBuilder dfsOut = new StringBuilder();
    static StringBuilder bfsOut = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        // 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        // Graphviz용 dot 파일 생성
        exportToDot("graph.dot");

        visited = new boolean[N + 1];

//        dfs(V);
//        System.out.println(dfsOut.toString().trim());
//
//        Arrays.fill(visited, false);
//
//        bfs(V);
//        System.out.println(bfsOut.toString().trim());
    }

    static void dfs(int u) {
        visited[u] = true;
        dfsOut.append(u).append(' ');

        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(start);
        visited[start] = true;
        bfsOut.append(start).append(' ');

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    bfsOut.append(v).append(' ');
                }
            }
        }
    }

    // Graphviz용 .dot 파일 생성
    static void exportToDot(String filename) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

        bw.write("graph G {\n");
        bw.write("  node [shape=circle];\n");

        boolean[][] used = new boolean[N + 1][N + 1];

        for (int u = 1; u <= N; u++) {
            for (int v : adj[u]) {
                if (!used[u][v]) {
                    bw.write("  " + u + " -- " + v + ";\n");
                    used[u][v] = used[v][u] = true; // 중복 방지
                }
            }
        }

        bw.write("}\n");
        bw.close();
    }
}
