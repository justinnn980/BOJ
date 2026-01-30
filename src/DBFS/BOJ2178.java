//import java.io.*;                 // 입력을 빠르게 받기 위한 클래스들을 사용한다
//import java.util.*;               // Queue, LinkedList, StringTokenizer 등을 사용한다
//
//public class Main {               // 백준 제출 시 클래스 이름은 Main 이어야 한다
//
//    // 미로 정보를 저장할 2차원 배열
//    static int[][] map;
//
//    // 세로 크기 N(행), 가로 크기 M(열)
//    static int N, M;
//
//    // 상/하/좌/우 이동을 만들기 위한 방향 배열
//    // dx, dy를 같은 인덱스로 사용하면 "한 번에 4방향 이동"을 깔끔하게 돌릴 수 있다
//    static int[] dx = {0, 1, 0, -1};
//    static int[] dy = {1, 0, -1, 0};
//
//    // 방문 체크 배열 (중복 방문을 막고 무한루프를 방지한다)
//    static boolean[][] visited;
//
//    public static void main(String[] args) throws Exception {
//
//        // 표준 입력을 빠르게 받기 위한 BufferedReader
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        // 첫 줄에서 N, M을 읽기 위한 토큰화
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        // TODO: N을 입력받아 저장하라
//        // N = ?
//
//        // TODO: M을 입력받아 저장하라
//        // M = ?
//
//        // TODO: map을 N행 M열 크기로 생성하라
//        // map = ?
//
//        // TODO: visited를 N행 M열 크기로 생성하라
//        // visited = ?
//
//        // N개의 줄을 읽어 미로를 채운다
//        for (int i = 0; i < N; i++) {
//
//            // TODO: 한 줄을 통째로 입력받아 String line에 저장하라
//            // 예) "101111"
//            // String line = ?
//
//            // i번째 행의 모든 열을 채운다
//            for (int j = 0; j < M; j++) {
//
//                // TODO: line의 j번째 문자를 숫자로 바꿔 map[i][j]에 저장하라
//                // 힌트1: charAt(j) 사용 가능
//                // 힌트2: '0'을 빼면 숫자 변환이 된다
//                // map[i][j] = ?
//            }
//        }
//
//        // TODO: (0,0)에서 BFS를 시작하라
//        // bfs(?, ?)
//
//        // TODO: 도착 지점(N-1, M-1)의 값을 출력하라
//        // System.out.println( ? );
//    }
//
//    static void bfs(int x, int y) {
//
//        // TODO: 큐를 만들고 (x,y)를 넣어라
//        // Queue<int[]> queue = ?
//        // queue.offer(new int[]{x, y});
//
//        // TODO: 시작점을 방문 처리하라
//        // visited[x][y] = ?
//
//        // 큐가 빌 때까지 반복한다 (BFS의 기본 뼈대)
//        while ( /* TODO: 큐가 비어있지 않은 조건 */ ) {
//
//            // TODO: 큐에서 현재 좌표를 꺼내라
//            // int[] cur = ?
//
//            // 상/하/좌/우 4방향을 모두 시도한다
//            for (int i = 0; i < 4; i++) {
//
//                // TODO: 다음 좌표(nx, ny)를 계산하라
//                // int nx = ?
//                // int ny = ?
//
//                // 1) 범위 안인지 확인한다 (배열 밖으로 나가면 터진다)
//                if ( /* TODO: nx, ny가 0..N-1, 0..M-1 범위인지 조건 작성 */ ) {
//
//                    // 2) 갈 수 있는 칸인지 + 아직 방문 안 했는지 확인한다
//                    // map[nx][ny] != 0 이면 길(1)이고 0이면 벽이다
//                    if ( /* TODO: 미방문 && 길인지 조건 작성 */ ) {
//
//                        // TODO: 방문 처리한다 (이 타이밍이 중요: 중복으로 큐에 들어가는 걸 막는다)
//                        // visited[nx][ny] = ?
//
//                        // TODO: 거리(혹은 이동 횟수)를 갱신한다
//                        // 핵심: 다음 칸의 거리 = 현재 칸의 거리 + 1
//                        // map[nx][ny] = map[cur[0]][cur[1]] + 1;
//
//                        // TODO: 다음 좌표를 큐에 넣는다
//                        // queue.offer(new int[]{nx, ny});
//                    }
//                }
//            }
//        }
//    }
//}
