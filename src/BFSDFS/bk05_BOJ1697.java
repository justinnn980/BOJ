package BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bk05_BOJ1697 {
    static final int Max = 100000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int result = bfs(n,k);
        System.out.println(result);
    }
    private static int bfs(int start, int end) {
        if(start == end) return 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] time = new int[Max+1];
        boolean[] visited = new boolean[Max+1];

        queue.add(start);
        visited[start] = true;
        time[start] = 0;

        while(!queue.isEmpty()){
            int now = queue.poll();
            int[] nextPositions = {now - 1, now + 1
                , now * 2};

            for(int next : nextPositions){
                if(next >= 0 && next <= Max && !visited[next]){
                    visited[next] = true;
                    time[next] = time[now] + 1;
                    queue.add(next);
                    if(next == end) {
                        return time[next];
                    }
                }
            }
        }

        return -1;
    }
}
