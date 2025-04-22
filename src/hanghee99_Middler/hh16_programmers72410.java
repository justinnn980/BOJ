package hanghee99_Middler;

public class hh16_programmers72410 {
    public static void main(String[] args) {
        String s = "...!@BaT#*..y.abcdefghijklm";
//        String s = "for the last week";
        System.out.println(solution(s));
    }
    public static String solution(String new_id) {
        // 1단계: 소문자로 치환
        new_id = new_id.toLowerCase();

        // 2단계: 허용된 문자만 StringBuilder에 추가
        StringBuilder sb = new StringBuilder();
        for (char ch : new_id.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9') ||
                ch == '-' || ch == '_' || ch == '.') {
                sb.append(ch);
            }
        }

        // 3단계: 마침표(.)가 2번 이상이면 하나로 치환
        String temp = sb.toString().replaceAll("\\.{2,}", ".");

        // 4단계: 처음과 끝의 마침표 제거
        temp = temp.replaceAll("^\\.|\\.$", "");

        // 5단계: 빈 문자열이면 "a" 대입
        if (temp.isEmpty()) {
            temp = "a";
        }

        // 6단계: 길이가 16자 이상이면 15자로 자르고, 끝이 마침표면 제거
        if (temp.length() >= 16) {
            temp = temp.substring(0, 15);
            temp = temp.replaceAll("\\.$", "");
        }

        // 7단계: 길이가 2자 이하이면, 마지막 문자를 반복
        while (temp.length() < 3) {
            temp += temp.charAt(temp.length() - 1);
        }

        return temp;
    }
}
