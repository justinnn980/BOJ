package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B19_BOJ1946 {
    static class Person {
        int doc, interview;
        Person(int doc, int interview) {
            this.doc = doc;
            this.interview = interview;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            Person[] arr = new Person[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                arr[i] = new Person(doc, interview);
            }

            Arrays.sort(arr, (a, b) -> Integer.compare(a.doc, b.doc));

            int count = 0;
            int bestInterview = Integer.MAX_VALUE;

            for (Person p : arr) {
                // 지금까지 본 사람들 중 면접 등수 최솟값보다 더 좋으면(숫자 작으면) 선발
                if (p.interview < bestInterview) {
                    count++;
                    bestInterview = p.interview;
                }
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb.toString());
    }

}
