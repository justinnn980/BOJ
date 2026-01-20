package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B20_BOJ19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new PriorityQueue<>();

        Node[] meeting = new Node[n];

        for (int i = 0; i< n;i++){
            st = new StringTokenizer(br.readLine());
            meeting[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meeting);

        q.offer(meeting[0].end);

        for (int i = 1; i < n; i++) {
            if (meeting[i].start >= q.peek()) {
                q.poll();
            }
            q.offer(meeting[i].end);

        }
        System.out.println(q.size());
    }
    static class Node implements Comparable<Node>{
        int start, end;

        public Node (int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node next) {
            if (this.start == next.start) {
                return this.end - next.end;
            }
            else {
                return this.start - next.start;
            }
        }
    }

}
