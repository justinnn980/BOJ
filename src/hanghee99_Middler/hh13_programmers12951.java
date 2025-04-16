package hanghee99_Middler;

public class hh13_programmers12951 {

    public static void main(String[] args) {
        String s = "3people unFollowed me";
//        String s = "for the last week";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStartOfWord = true;

        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                sb.append(c);
                isStartOfWord = true; // 다음 문자가 단어의 시작임
            } else {
                if (isStartOfWord) {
                    sb.append(Character.toUpperCase(c));
                    isStartOfWord = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }

        return sb.toString();
    }

}
