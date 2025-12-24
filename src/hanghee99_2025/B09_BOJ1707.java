package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B09_BOJ1707 {

    static ArrayList<Integer>[] list;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 노드 개수
            int E = Integer.parseInt(st.nextToken()); // 에지 개수
            list = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            IsEven = true;
            for (int j = 1; j <= V; j++) {
                list[j] = new ArrayList<>();
            }
            // 에지 데이터 저장하기
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list[start].add(end);
                list[end].add(start);
            }
            // 모든 노드에서 DFS 실행
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && IsEven) {
                    DFS(j);
                }
            }

            if (IsEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void DFS(int start) {
        visited[start] = true; // 방문하면 true
        for (int i = 0; i < list[start].size(); i++) {
            int idx = list[start].get(i); //리스트 1부터 돌면서
            if (!visited[idx]) { //방문하지 않은 노드면
                check[idx] = (check[start] + 1) % 2;
                DFS(idx); // 반복
            } else if (check[start] == check[idx]) {
                IsEven = false;
            }
        }
    }
}
