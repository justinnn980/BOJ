package must;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class must1_BOJ1260 {
    static int N, M, V;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list[S].add(E);
            list[E].add(S);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }
        visited = new boolean[N + 1];
        DFS(V);
    }
    public static void DFS(int v) {
        System.out.print(v+" ");
        visited[v] = true;
        for (int i = 0; i < list[v].size(); i++) {
            if (!visited[list[v].get(i)]) {
                DFS(list[v].get(i));
            }
        }
    }

}
