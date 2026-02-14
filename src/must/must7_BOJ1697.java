package must;

import java.io.*;
import java.util.*;

public class must7_BOJ1697 {
    static int[] dist = new int[100002];
    static int n, k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Arrays.fill(dist, -1);
        dist[n] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (dist[k] == -1) {
            int cur = q.poll();
            for (int next : new int[]{cur - 1, cur + 1, 2 * cur}) {
                if (next < 0 || next > 100000) continue;
                if (dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }

        System.out.println(dist[k]);
    }
}
