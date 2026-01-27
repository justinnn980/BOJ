package etc;

import java.util.Scanner;

public class BOJ12891 {
    static int[] arr = new int[4];
    static int[] arr2 = new int[4];
    static int check = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int p = sc.nextInt();
        int count = 0;


        String o = sc.next(); /// o 값넣기
        char[] str = o.toCharArray(); /// 하나하나 나누기


        for(int i = 0; i < 4; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < p; i++) {
            Add(str[i]);
        }

        if(check == 4) {
            check++;
        }

        for(int i = p; i < s; i++) {
            int j = i - p;
            Add(str[i]);
            Remove(str[j]);
            if(check == 4) {count++;}

        }

        System.out.println(count);
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                arr2[0]++;
                if (arr2[0] == arr[0]) {
                    check++;
                }
                break;

                case 'C':
                    arr2[1]++;
                    if (arr2[1] == arr[1]) {
                        check++;
                    }
                    break;

                    case 'G':
                        arr2[2]++;
                        if (arr2[2] == arr[2]) {
                            check++;
                        }
                        break;

                        case 'T':
                            arr2[3]++;
                            if (arr2[3] == arr[3]) {
                                check++;
                            }
                            break;

        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                arr2[0]--;
                if (arr2[0] == arr[0]) {
                    check--;
                    break;
                }
            case 'C':
                arr2[1]--;
                if (arr2[1] == arr[1]) {
                    check--;
                    break;
                }
            case 'G':
                arr2[2]--;
                if (arr2[2] == arr[2]) {
                    check--;
                    break;
                }
            case 'T':
                arr2[3]--;
                if (arr2[3] == arr[3]) {
                    check--;
                    break;
                }
        }
    }
}
