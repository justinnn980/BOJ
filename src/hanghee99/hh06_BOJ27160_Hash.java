package hanghee99;

import java.util.HashMap;
import java.util.Scanner;

public class hh06_BOJ27160_Hash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] str = sc.nextLine().split(" ");
            int existValue = map.getOrDefault(str[0], 0);
            map.put(str[0], existValue +  Integer.parseInt((str[1])));
        }

        if (map.containsValue(5)){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

//        for (String key : map.keySet()) {
//            if (map.get(key) == 5) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
//        }
    }
}
