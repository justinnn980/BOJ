package must;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class must3_BOJ2606 {
    static int n, m;
    static boolean[] visited;
    static int[][] map;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        map = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        dfs(1);
        System.out.println(count);
    }
    private static void dfs(int cur) {
        visited[cur] = true;

        for (int i = 1; i <= n; i++) {
            // 아직 감염되지 않은 컴퓨터인가? cur컴퓨와 i 컴퓨터가 직접 연결되어 있는가?
            // map[cur][i] == 1 > cur 컴퓨터와 i 컴퓨터 사이에 케이블(연결선)이 있다.
            if (!visited[i] && map[cur][i] == 1) {
                count++;      // 새로 감염되는 컴퓨터
                dfs(i);
            }
        }
    }
}
