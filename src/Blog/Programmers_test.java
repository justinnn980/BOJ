package Blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];

        // 첫 번째 값은 그대로 복사 (필요에 따라 변경 가능)
        answer[0] = num_list[0];

        for(int i = 1; i < num_list.length; i++){
            if(num_list[i-1] < num_list[i]) {
                answer[i] = num_list[i] - num_list[i-1];
            } else {
                answer[i] = num_list[i] * 2;
            }
        }
        return answer;
    }
}

public class Programmers_test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 예시 입력: 1 3 2 5 4
        System.out.println("숫자들을 공백으로 입력하세요:");
        String[] input = br.readLine().split(" ");

        int[] num_list = new int[input.length];
        for(int i = 0; i < input.length; i++){
            num_list[i] = Integer.parseInt(input[i]);
        }

        Solution sol = new Solution();
        int[] result = sol.solution(num_list);

        System.out.println("결과:");
        System.out.println(Arrays.toString(result));
    }
}