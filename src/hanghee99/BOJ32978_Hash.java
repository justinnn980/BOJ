package hanghee99;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ32978_Hash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        HashMap<String, Integer> map = new HashMap<>();

        String[] str = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            map.put(str[i], i);
        }

        String[] str2 = sc.nextLine().split(" ");
        HashMap<String, Integer> usedMap = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            usedMap.put(str2[i], i);
        }

        for(String s : map.keySet()){
            if(!usedMap.containsKey(s)){
                System.out.println(s);
                return;
            }
        }
    }
}
