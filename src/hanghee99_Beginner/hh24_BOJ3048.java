package hanghee99_Beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class hh24_BOJ3048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        String firstGroup = br.readLine();
        String secondGroup = br.readLine();
        int t = Integer.parseInt(br.readLine());

        List<Character> ants = new ArrayList<>();
        Map<Character, Integer> direction = new HashMap<>();

        // 첫 번째 그룹은 역순으로 넣어줌 (오른쪽 이동)
        for (int i = n1 - 1; i >= 0; i--) {
            ants.add(firstGroup.charAt(i));
            direction.put(firstGroup.charAt(i), 1); // 오른쪽 이동
        }

        // 두 번째 그룹은 그대로 추가 (왼쪽 이동)
        for (int i = 0; i < n2; i++) {
            ants.add(secondGroup.charAt(i));
            direction.put(secondGroup.charAt(i), -1); // 왼쪽 이동
        }

        // T초 동안 진행
        for (int time = 0; time < t; time++) {
            List<Integer> swapIndices = new ArrayList<>();

            // 개미가 점프할 수 있는 위치 찾기
            for (int i = 0; i < ants.size() - 1; i++) {
                if (direction.get(ants.get(i)) == 1 && direction.get(ants.get(i + 1)) == -1) {
                    swapIndices.add(i);
                }
            }

            // 한 번에 swap (한 스텝에서 영향을 받지 않도록)
            for (int idx : swapIndices) {
                Collections.swap(ants, idx, idx + 1);
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (char ant : ants) {
            sb.append(ant);
        }
        System.out.println(sb.toString());
    }
}
