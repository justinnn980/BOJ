import java.io.*;                 // 빠른 입출력을 위해 필요한 클래스들을 불러온다
import java.util.*;               // List, Queue, ArrayList, ArrayDeque 등을 쓰기 위해 필요하다

public class dfs2 {               // 백준 제출 시 클래스 이름은 반드시 Main

    static int N, M, V;           // 정점 개수 N, 간선 개수 M, 시작 정점 V
    static List<Integer>[] adj;   // 인접 리스트: 각 정점의 이웃 정점들을 담는 배열
    static boolean[] visited;     // 방문 여부를 기록할 배열

    static StringBuilder dfsOut = new StringBuilder(); // DFS 결과를 저장할 버퍼
    static StringBuilder bfsOut = new StringBuilder(); // BFS 결과를 저장할 버퍼

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 표준 입력(System.in)을 빠르게 읽기 위해 BufferedReader를 생성한다

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 첫 줄(N, M, V)을 공백 단위로 나누기 위해 StringTokenizer를 만든다

        N = Integer.parseInt(st.nextToken());
        // 첫 번째 토큰을 정수로 바꿔 정점 개수 N에 저장한다

        M = Integer.parseInt(st.nextToken());
        // 두 번째 토큰을 정수로 바꿔 간선 개수 M에 저장한다

        V = Integer.parseInt(st.nextToken());
        // 세 번째 토큰을 정수로 바꿔 시작 정점 V에 저장한다
        // (이 문제에서 가장 자주 놓치는 부분)

        adj = new ArrayList[N + 1];
        // 정점이 1번부터 N번까지라고 가정하므로 크기를 N+1로 만든다

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            // 각 정점마다 "이웃 목록"을 담을 빈 리스트를 만들어준다
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 간선 정보를 한 줄 읽어서 다시 토큰화한다

            int u = Integer.parseInt(st.nextToken());
            // 간선의 시작 정점 u를 읽는다

            int v = Integer.parseInt(st.nextToken());
            // 간선의 도착 정점 v를 읽는다

            adj[u].add(v);
            // u에서 v로 갈 수 있음을 기록한다

            adj[v].add(u);
            // 무방향 그래프이므로 v에서도 u로 갈 수 있음을 기록한다
        }

        // "번호가 작은 정점부터 방문" 조건을 만족하기 위해
        // 각 정점의 인접 리스트를 오름차순 정렬한다
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        visited = new boolean[N + 1];
        // 각 정점의 방문 여부를 기록할 배열을 생성한다

        dfs(V);
        // 시작 정점 V에서 DFS를 실행한다

        System.out.println(dfsOut.toString().trim());
        // DFS 결과를 한 줄로 출력한다

        Arrays.fill(visited, false);
        // DFS가 끝났으므로 visited 배열을 다시 false로 초기화한다

        bfs(V);
        // 시작 정점 V에서 BFS를 실행한다

        System.out.println(bfsOut.toString().trim());
        // BFS 결과를 한 줄로 출력한다
    }

    static void dfs(int u) {

        visited[u] = true;
        // 현재 정점 u를 "방문했다"고 표시한다
        // 이 줄이 없으면 같은 정점을 무한히 재귀 호출하게 된다

        dfsOut.append(u).append(' ');
        // 방문한 정점을 출력 버퍼에 기록한다

        for (int v : adj[u]) {
            // u와 연결된 모든 이웃 정점 v를 하나씩 확인한다

            if (!visited[v]) {
                // 아직 방문하지 않은 정점이라면

                dfs(v);
                // 그 정점으로 더 깊이 들어간다 (깊이 우선)
            }
        }
        // 이 for문이 끝나면, u에서 갈 수 있는 모든 경로를 탐색한 상태가 된다
    }

    static void bfs(int start) {

        Queue<Integer> q = new ArrayDeque<>();
        // BFS에서 사용할 큐를 생성한다 (FIFO 구조)

        q.add(start);
        // 시작 정점을 큐에 넣는다

        visited[start] = true;
        // 큐에 넣는 순간 방문 처리하여 중복 삽입을 막는다

        bfsOut.append(start).append(' ');
        // 시작 정점을 방문 결과에 기록한다

        while (!q.isEmpty()) {
            // 큐가 빌 때까지 반복한다

            int u = q.poll();
            // 큐의 맨 앞에 있는 정점을 하나 꺼낸다

            for (int v : adj[u]) {
                // u와 연결된 모든 이웃 정점을 확인한다

                if (!visited[v]) {
                    // 아직 방문하지 않은 정점이라면

                    visited[v] = true;
                    // 방문 처리부터 한다 (중복 enqueue 방지)

                    q.add(v);
                    // 그 정점을 큐의 뒤에 넣는다

                    bfsOut.append(v).append(' ');
                    // 방문한 정점을 결과에 기록한다
                }
            }
        }
    }
}
