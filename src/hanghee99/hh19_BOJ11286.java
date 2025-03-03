package hanghee99;

import java.util.Scanner;

public class hh19_BOJ11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AbsPriorityQueue pq = new AbsPriorityQueue();

        int n = sc.nextInt();
        StringBuilder ans = new StringBuilder();

        while (n-- > 0) {
            int x = sc.nextInt();
            if (x == 0)
                ans.append(pq.pop()).append("\n");
            else
                pq.push(x);
        }

        System.out.println(ans);
    }

    static class AbsPriorityQueue {
        int[] heap;
        int size;

        public AbsPriorityQueue() {
            heap = new int[100001]; // 인덱스 1부터 사용
            size = 0;
        }

        void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public void push(int x) {
            heap[++size] = x;
            int current = size;

            while (current > 1) {
                int parent = current / 2;
                if (compare(heap[parent], heap[current]) <= 0) break;

                swap(parent, current);
                current = parent;
            }
        }

        public int pop() {
            if (size == 0) return 0;
            int ret = heap[1];

            heap[1] = heap[size--];
            int current = 1;

            while (current * 2 <= size) {
                int left = current * 2;
                int right = left + 1;
                int child = left;

                if (right <= size && compare(heap[left], heap[right]) > 0) {
                    child = right;
                }

                if (compare(heap[current], heap[child]) <= 0) break;

                swap(current, child);
                current = child;
            }

            return ret;
        }

        private int compare(int a, int b) {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA == absB) return Integer.compare(a, b); // 값 자체 비교 (음수 우선)
            return Integer.compare(absA, absB); // 절대값 비교
        }
    }
}
