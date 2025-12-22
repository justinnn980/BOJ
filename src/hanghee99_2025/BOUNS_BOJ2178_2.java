package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOUNS_BOJ2178_2 {

    /* 정의 5개 */
    /// 1. 좌우 배열
    /// 2. 방문 2차 배열
    /// 3. 그래프
    /// 4. N,M
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /* 값 받기 및 정의하기 */


        /* 그래프 그리기 */


        /* 함수 실행 및 출력 */

    }

    /* 함수 정의 */
    /// 1. que 정의
    /// 2. 시작 위치 que에 넣기, 방문배열 true
    /// 3. que돌면서 now 확인
    /// 4. 상하좌우 탐색하면서
    /// 행열 양수, 행렬 N,M 이하 + 벽이 아닌지 체크, 방문한 배열이면 안된다
    /// 5. 배열 true, depth 한개 더 크게 넣어줌, que 추가
    private static void BFS(int i, int j) {}
}
