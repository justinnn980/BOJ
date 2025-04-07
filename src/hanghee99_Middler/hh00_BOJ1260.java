package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hh00_BOJ1260 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;

    static int node, line, start;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        ///입력 N M V 정점의 개수, 간선의 개수, 정점의 번호
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start= Integer.parseInt(st.nextToken());

        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        for(int i = 0 ; i < line ; i ++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] =  1;
        }

        ///출력 DFS로 탐색할때 노드를 순차적으로 첫줄에 출력
        /// BFS 로 탐색할때 노드를 순차적으로 둘째줄에 출력
        //sb.append("\n");
        dfs(start);
        sb.append("\n");
        check = new boolean[node+1];

        bfs(start);

        System.out.println(sb);

    }
    ///로직 주어진 간선리스트를 통해서 DFS와 BFS 구현

    public static void dfs(int start) {

        check[start] = true;
        sb.append(start + " ");

        for(int i = 0 ; i <= node ; i++) {
            if(arr[start][i] == 1 && !check[i])
                dfs(i);
        }

    }

    public static void bfs(int start) {
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {

            start = q.poll();
            sb.append(start + " ");

            for(int i = 1 ; i <= node ; i++) {
                if(arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }

}
