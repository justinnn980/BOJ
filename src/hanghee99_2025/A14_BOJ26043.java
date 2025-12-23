package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class A14_BOJ26043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int student = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                queue.add(String.valueOf(student));
                map.put(student, m);
            } else if (a == 2) {
                int m = Integer.parseInt(st.nextToken());
                if (!queue.isEmpty()){
                int student = Integer.parseInt(queue.poll());
                int q = map.get(student);
                    if(q == m){
                        A.add(student);
                    } else {
                        B.add(student);
                    }
                }

            }
        }

        Collections.sort(A);
        Collections.sort(B);
        if (A.isEmpty()) {
            System.out.println("None");
        } else {
            for (int x : A) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        if (B.isEmpty()) {
            System.out.println("None");
        } else {
            for (int x : B) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        if (queue.isEmpty()) {
            System.out.print("None");
        } else {
            while (!queue.isEmpty()) {
                C.add(Integer.parseInt(queue.poll()));
            }
            Collections.sort(C);
            for (int x : C) {
                System.out.print(x + " ");
            }
        }

    }

}
