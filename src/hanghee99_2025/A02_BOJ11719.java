package hanghee99_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A02_BOJ11719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader ///문자 입력을 버퍼 단위로 모아서 읽어 빠르게 처리
//            (new InputStreamReader(System.in)); /// system.in은 키보드 입력이고(byte), 바이트를 문자로 바꿔줌 byte -> char 변환(InputStreamReader)
//        String line;
//
//        while ((line = br.readLine()) != null) {   // 끝까지 읽음
//            System.out.println(line);              // 읽은 그대로 출력
//        }
//    }
}
