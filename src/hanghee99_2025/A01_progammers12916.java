package hanghee99_2025;

public class A01_progammers12916 {
    public static void main(String[] args) {
        String s = "pPoooyY";
        String s2 = "Pyy";
        System.out.println(solution(s));
        System.out.println(solution(s2));
    }

    static boolean solution(String s) {
        boolean answer = false;
        char[] chars = s.toCharArray();
        int a = 0;
        int b = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'p' || chars[i] == 'P') {
                a++;
            } else if (chars[i] == 'y' || chars[i] == 'Y') {
                b++;
            }
        }
        if (a == b)
            answer = true;

        return answer;
    }
}
