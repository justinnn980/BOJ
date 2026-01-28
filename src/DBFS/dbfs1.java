package DBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class dbfs1 {

    // 출력용 StringBuilder 선언
    static StringBuilder sb;

    // 방문 여부 체크 배열
    static boolean[] visited;

    // 인접 리스트 선언 (1번 노드부터 사용)
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception {

        /*
         * 1. 입력 준비
         * - BufferedReader 생성
         * - StringTokenizer로 N, M, V 읽기
         */

        /*
         * 2. 인접 리스트 배열 생성
         * - 크기 N+1
         * - 1번부터 N번까지 ArrayList 초기화
         */

        /*
         * 3. 간선 정보 입력
         * - M번 반복
         * - S, E 읽기
         * - list[S].add(E)
         * - list[E].add(S) (무방향)
         */

        /*
         * 4. 각 리스트 오름차순 정렬
         * - 1번부터 N번까지 반복
         * - list[i].sort(...)
         */

        /*
         * 5. DFS 실행
         * - visited 배열 초기화
         * - DFS(V)
         * - sb 출력
         */

        /*
         * 6. BFS 실행
         * - sb 초기화
         * - visited 재초기화
         * - BFS(V)
         * - sb 출력
         */
    }

    /**
     * DFS 규칙:
     * - 현재 노드를 출력
     * - 방문 처리
     * - 인접 노드를 오름차순으로 순회
     * - 방문 안 했으면 재귀 호출
     */
    private static void DFS(int x) {

        /*
         * 1. x 출력
         * 2. visited[x] = true
         * 3. list[x] 순회
         *    - 방문 안 한 노드면 DFS(다음 노드)
         */
    }

    /**
     * BFS 규칙:
     * - Queue 생성
     * - 시작 노드를 큐에 넣고 방문 처리
     * - 큐가 빌 때까지 반복
     *   - poll 해서 꺼낸 값 출력
     *   - 인접 노드 순회
     *     - 방문 안 했으면 방문 처리 후 큐에 추가
     */
    private static void BFS(int start) {

        /*
         * 1. Queue 생성
         * 2. start를 큐에 넣기
         * 3. visited[start] = true
         * 4. while (!queue.isEmpty())
         *    - cur = queue.poll()
         *    - cur 출력
         *    - list[cur] 순회
         *      - 방문 안 했으면:
         *        visited 처리
         *        queue에 추가
         */
    }
}
