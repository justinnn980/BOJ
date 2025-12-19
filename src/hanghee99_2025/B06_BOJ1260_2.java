package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B06_BOJ1260_2 {
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>(); // 인접리스트 완성
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list[S].add(E);
            list[E].add(S);
            // 그래프 완성
        }
        
//        for (int i = 1; i <= N; i++) {
//            Collections.sort(list[i]);
//        }

        visited = new boolean[N + 1];
        DFS(start);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(start);
        System.out.println();
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur+" ");
            for (int i = 0; i < list[cur].size(); i++) {
                if (!visited[list[cur].get(i)]) {
                    visited[list[cur].get(i)] = true;
                    queue.add(list[cur].get(i));
                }
            }
        }
    }

    private static void DFS(int start) {
        System.out.print(start+" ");
        visited[start] = true;
        for (int i : list[start]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
