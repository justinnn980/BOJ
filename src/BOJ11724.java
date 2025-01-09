import java.util.ArrayList;
import java.util.Scanner;

public class BOJ11724 {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n+1];
        A = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            A[u].add(v);
            A[v].add(u);
        }
        int count = 0;
        for (int i = 1; i < n+1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    private static void DFS(int e) {
        if (visited[e]) { ///방문노드이면
            return;
        }
        visited[e] = true; ///방문 할 노드
        for (int j : A[e]) { ///현재 노드와 연결되어 있는 노드 탐색
            if (!visited[j]) { ///아직 탐색하지 않은 노드가 있다면 자신을 다시 실행
                DFS(j);
            }
        }
    }
}
