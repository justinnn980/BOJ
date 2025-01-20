package hanghee99;

import java.util.Objects;
import java.util.Scanner;

public class BOJ27160_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int strawberry = 0;
        int banana = 0;
        int lime = 0;
        int plum = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int x = sc.nextInt();
            if (Objects.equals(s, "STRAWBERRY")) {
                strawberry = x + strawberry;
            } else if (Objects.equals(s, "BANANA")) {
                banana = x + banana;
            } else if (Objects.equals(s, "LIME")) {
                lime = x + lime;
            } else if (Objects.equals(s, "PLUM")) {
                plum = x + plum;
            }
        }
        if (strawberry == 5 || banana == 5 || lime == 5 || plum == 5){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
