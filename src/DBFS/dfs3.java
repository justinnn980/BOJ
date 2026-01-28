package DBFS;

import java.io.*;                 // 빠른 입출력을 위해 필요한 클래스들을 불러온다
import java.util.*;               // List, Queue, ArrayList, ArrayDeque 등을 쓰기 위해 필요하다

public class dfs3 {               // 백준 제출 시 클래스 이름은 반드시 Main

    // 정점 개수, 간선 개수, 시작 정점
    static int N, M, V;

    // 인접 리스트: 각 정점의 이웃 정점들을 담는 배열
    static List<Integer>[] adj;

    // 방문 여부를 기록할 배열
    static boolean[] visited;

    // DFS 결과를 저장할 버퍼
    static StringBuilder dfsOut = new StringBuilder();

    // BFS 결과를 저장할 버퍼
    static StringBuilder bfsOut = new StringBuilder();

    public static void main(String[] args) throws Exception {

        // 표준 입력(System.in)을 빠르게 읽기 위해 BufferedReader를 생성한다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄(N, M, V)을 공백 단위로 나누기 위해 StringTokenizer를 만든다
        StringTokenizer st = new StringTokenizer(br.readLine());

        // TODO: 첫 번째 토큰을 정수로 바꿔 정점 개수 N에 저장하라
        // N = ?
        N = Integer.parseInt(st.nextToken());

        // TODO: 두 번째 토큰을 정수로 바꿔 간선 개수 M에 저장하라
        // M = ?
        M = Integer.parseInt(st.nextToken());

        // TODO: 세 번째 토큰을 정수로 바꿔 시작 정점 V에 저장하라
        // V = ?
        V = Integer.parseInt(st.nextToken());

        // TODO: 크기가 N+1인 인접 리스트 배열을 생성하라
        // adj = ?
        adj = new ArrayList[N + 1];

        // 각 정점마다 "이웃 목록"을 담을 빈 리스트를 만들어준다
        for (int i = 1; i <= N; i++) {
            // TODO: adj[i]에 새로운 ArrayList를 할당하라
            adj[i] = new ArrayList<>();
        }

        // M개의 간선을 입력받는다
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 간선 정보를 한 줄 읽어서 다시 토큰화한다

            // TODO: 간선의 시작 정점 u를 읽어라
            // int u = ?
            int u = Integer.parseInt(st.nextToken());

            // TODO: 간선의 도착 정점 v를 읽어라
            // int v = ?
            int v = Integer.parseInt(st.nextToken());

            // TODO: u에서 v로 갈 수 있음을 인접 리스트에 기록하라
            adj[u].add(v);

            // TODO: 무방향 그래프이므로 v에서 u로 갈 수 있음을 기록하라
            adj[v].add(u);

        }

        // "번호가 작은 정점부터 방문" 조건을 만족하기 위해
        // 각 정점의 인접 리스트를 오름차순 정렬한다
        for (int i = 1; i <= N; i++) {
            // TODO: adj[i]를 오름차순 정렬하라
            Collections.sort(adj[i]);
        }

        // TODO: 크기가 N+1인 방문 배열을 생성하라
        // visited = ?
        visited = new boolean[N + 1];

        // TODO: 시작 정점 V에서 DFS를 실행하라
        // dfs( ? );
        dfs(V);

        // TODO: DFS 결과를 한 줄로 출력하라
        System.out.println(dfsOut.toString().trim());

        // TODO: visited 배열을 전부 false로 초기화하라
        Arrays.fill(visited, false);

        // TODO: 시작 정점 V에서 BFS를 실행하라
        // bfs( ? );
        bfs(V);

        // TODO: BFS 결과를 한 줄로 출력하라
        System.out.println(bfsOut.toString().trim());
    }

    static void dfs(int u) {

        // TODO: 현재 정점 u를 방문 처리하라
        visited[u] = true;

        // TODO: 방문한 정점 u를 DFS 결과 버퍼에 기록하라
        dfsOut.append(u).append(' ');
        // u와 연결된 모든 이웃 정점 v를 하나씩 확인한다
        for (int v : adj[u]) {

            // 아직 방문하지 않은 정점이라면
            /* TODO: v가 방문되지 않았는지 조건 작성 */
            if (!visited[v]) {

                // TODO: v로 DFS를 재귀 호출하라
                dfs(v);
            }
        }
        // 이 for문이 끝나면, u에서 갈 수 있는 모든 경로를 탐색한 상태가 된다
    }

    static void bfs(int start) {

        // TODO: BFS에서 사용할 큐를 생성하라
        Queue<Integer> q = new ArrayDeque<>();
        // TODO: 시작 정점을 큐에 넣어라
        q.offer(start);

        // TODO: 시작 정점을 방문 처리하라
        visited[start] = true;
        // TODO: 시작 정점을 BFS 결과 버퍼에 기록하라
        bfsOut.append(start).append(' ');

        // 큐가 빌 때까지 반복한다
        /* TODO: 큐가 비어있지 않은 조건 */
        while (!q.isEmpty()) {

            // TODO: 큐의 맨 앞에 있는 정점을 하나 꺼내 u에 저장하라
            // int u = ?
            int u = q.poll();

            // u와 연결된 모든 이웃 정점을 확인한다
            for (int v : adj[u]) {

                // 아직 방문하지 않은 정점이라면
                /* TODO: v가 방문되지 않았는지 조건 작성 */
                if (!visited[v]) {

                    // TODO: v를 방문 처리하라
                    visited[v] = true;

                    // TODO: v를 큐의 뒤에 넣어라
                    q.offer(v);

                    // TODO: v를 BFS 결과 버퍼에 기록하라
                    bfsOut.append(v).append(' ');
                }
            }
        }
    }
}
