package hanghee99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class hh14_BOJ26043 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        List<Integer> A = new ArrayList<>(); // 원하는 메뉴를 먹은 학생 목록
        List<Integer> B = new ArrayList<>(); // 원하지 않는 메뉴를 먹은 학생 목록
        Queue<int[]> list = new LinkedList<>(); // 식당 줄

        int n = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] parts = s.split(" "); // 입력값을 공백 기준으로 나누기

            if (parts[0].equals("1")) { // 학생 도착
                int a = Integer.parseInt(parts[1]); // 학생 번호
                int b = Integer.parseInt(parts[2]); // 선호 메뉴
                list.add(new int[]{a, b});
            } else if (parts[0].equals("2")) { // 식사 준비됨
                int b = Integer.parseInt(parts[1]); // 현재 준비된 메뉴 번호
                if (!list.isEmpty()) {
                    int[] member = list.poll();
                    if (member[1] == b) {
                        A.add(member[0]); // 원하는 메뉴 먹음
                    } else {
                        B.add(member[0]); // 원하지 않는 메뉴 먹음
                    }
                }
            }
        }

        // 결과 출력 함수
        printList(sb, A);
        printList(sb, B);
        List<Integer> C = new ArrayList<>();
        while (!list.isEmpty()) {
            C.add(list.poll()[0]);
        }
        printList(sb, C);

        System.out.println(sb);
    }

    private static void printList(StringBuilder sb, List<Integer> list) {
        if (list.isEmpty()) {
            sb.append("None\n");
        } else {
            Collections.sort(list);
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
    }

}
