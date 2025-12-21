package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B06_BOJ1260_2 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];

        // 초기화 하기
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>(); // 초기화
        }
        // 그래프 데이터 저장하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list[S].add(E);
            list[E].add(S);
        }

        // 각 노드를 돌면서 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            list[i].sort(null);
        }

        visited = new boolean[N + 1];
        DFS(start);
        System.out.println(sb.toString());
        sb.setLength(0);
        visited = new boolean[N + 1];
        BFS(start);
        System.out.println(sb.toString());
    }

    /// BFS는 시작 노드로 하는게 아닌 시작 노드를 que에 넣어서 que에 나오는 값으로 구한다
    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); //que에 시작노드 넣기
        visited[start] = true; //방문하면 true
        while (!queue.isEmpty()) { //que가 비었을때까지
            int cur = queue.poll(); // 시작 노드 구하기
            sb.append(cur).append(" "); // 값!!!!
            for (int i = 0; i < list[cur].size(); i++) {
                if (!visited[list[cur].get(i)]) { // 방문하지 않은 노드면
                    visited[list[cur].get(i)] = true;
                    queue.add(list[cur].get(i));
                }
            }
        }
    }

    private static void DFS(int start) {
        sb.append(start).append(" "); // 값 넣기
        visited[start] = true; // 방문하면 true
        for (int i = 0; i < list[start].size(); i++) {
            int idx = list[start].get(i); //리스트 1부터 돌면서
            if (!visited[idx]) { //방문하지 않은 노드면
                DFS(idx); // 반복
            }
        }
    }
}
