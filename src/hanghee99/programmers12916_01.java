package hanghee99;

import java.util.Scanner;

public class programmers12916_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = 0;
        int p = 0;
        String o = sc.next();
        char[] str = o.toCharArray(); /// 하나하나 나누기
        for(int i = 0; i < o.length(); i++) {
            switch (str[i]) {
                case 'y':
                    y++;
                    break;

                case 'Y':
                    y++;
                    break;

                case 'p':
                    p++;
                    break;

                case 'P':
                    p++;
                    break;

            }
        }

        if (y == p){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
