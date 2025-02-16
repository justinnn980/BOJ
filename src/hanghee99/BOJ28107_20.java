package hanghee99;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ28107_20 {

    static int n;
    static int m;
    static PriorityQueue<Customer> customers;
    static PriorityQueue<Integer> susis;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        customers = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            while(number-->0) {
                int susi = Integer.parseInt(st.nextToken());
                customers.add(new Customer(susi, i));
            }
        }
        answer = new int[n];

        st = new StringTokenizer(br.readLine());
        susis = new PriorityQueue<>();
        while (m-->0) {
            susis.add(Integer.parseInt(st.nextToken()));
        }

        while (!susis.isEmpty()) {
            int susi = susis.poll();

            while (!customers.isEmpty() && customers.peek().susi < susi) {
                customers.poll();
            }

            if (!customers.isEmpty() && customers.peek().susi == susi) {
                Customer c = customers.poll();

                // System.out.println(susi + " " + c.susi + " " + c.number);

                answer[c.number] += 1;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }

    }

    // 스시 번호 오름차순, 스시 번호 같으면 손님 번호 오름차순
    public static class Customer implements Comparable<Customer> {
        int susi;
        int number;

        Customer(int susi, int number) {
            this.susi = susi;
            this.number = number;
        }

        public int compareTo(Customer customer) {
            if (this.susi == customer.susi) {
                return this.number - customer.number;
            }
            return this.susi - customer.susi;
        }
    }

}
