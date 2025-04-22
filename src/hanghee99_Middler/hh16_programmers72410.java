package hanghee99_Middler;

public class hh16_programmers72410 {
    public static void main(String[] args) {
        String s = "...!@BaT#*..y.abcdefghijklm";
//        String s = "for the last week";
        System.out.println(solution(s));
    }
    public static String solution(String new_id) {
        new_id = new_id.toLowerCase();
        String answer = "";
        for(int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);

            if(ch >= 'a' && ch <= 'z') {
                answer += String.valueOf(ch);
            } else if(ch >= '0' && ch <= '9') {
                answer += String.valueOf(ch);
            } else if(ch == '.' || ch == '-' || ch == '_') {
                answer += String.valueOf(ch);
            }
        }

        for (int i = 0; i<answer.length(); i++){
            if (answer.charAt(i) == '.'){
                int j = i+1;
                String dot = ".";

                while(j != answer.length() && answer.charAt(j) == '.') {
                    dot += ".";
                    j++;
                }

                if(dot.length() > 1)
                    answer = answer.replace(dot, ".");
            }
        }
        if(answer.startsWith(".") ) {
            answer = answer.substring(1, answer.length());
        } else if(answer.endsWith(".")) {
            answer = answer.substring(0, answer.length()-1);
        }
        if(answer.length() == 0) {
            answer += "a";
        }
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        if(answer.endsWith(".")) {
            answer = answer.substring(0, answer.length()-1);
        }
        // 7. 2자 이하라면, 마지막 문자 길이 3까지 반복해서 붙임
        String last = answer.charAt(answer.length()-1) + "";
        if(answer.length() == 2) {
            answer = answer + last;
        } else if(answer.length() == 1) {
            answer = answer + last + last;
        }

        return answer;
    }
}
