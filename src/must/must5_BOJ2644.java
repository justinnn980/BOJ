package must;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class must5_BOJ2644 {
    static int n, m;
    static int a, b;
    static int x, y;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static int answer = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        visited = new boolean[n + 1];
        DFS(a, b, 0);

        System.out.println(answer);
        // 1️⃣ dot 파일 생성
        exportToDot("family.dot");

        // 2️⃣ png 파일 생성
        exportDotToPng("family.dot", "family.png");

    }

    static void DFS(int cur, int target, int depth) {
        if (cur == target) {
            answer = depth;
            return;
        }

        visited[cur] = true;

        for (int nxt : adj[cur]) { // 현재 사람과 직접 연결된 사람, nxt다음 노드
            if (!visited[nxt]) {
                DFS(nxt, target, depth + 1);
                if (answer != -1) return; // 찾았으면 더 볼 필요 없음(가지치기)
            }
        }
    }


    // Graphviz용 .dot 파일 생성
    static void exportToDot(String filename) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

        bw.write("graph G {\n");
        bw.write("  node [shape=circle];\n");

        boolean[][] used = new boolean[n + 1][n + 1];

        for (int u = 1; u <= n; u++) {
            for (int v : adj[u]) {
                if (!used[u][v]) {
                    bw.write("  " + u + " -- " + v + ";\n");
                    used[u][v] = used[v][u] = true;
                }
            }
        }

        bw.write("}\n");
        bw.close();
    }

    // dot → png 변환
    static void exportDotToPng(String dotFile, String pngFile) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(
            "dot", "-Tpng", dotFile, "-o", pngFile
        );

        pb.redirectErrorStream(true);
        Process process = pb.start();

        // 실행 결과 출력 (에러 확인용)
        BufferedReader br = new BufferedReader(
            new InputStreamReader(process.getInputStream())
        );
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        process.waitFor();
    }
}
