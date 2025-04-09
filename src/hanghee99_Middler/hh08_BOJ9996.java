package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hh08_BOJ9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        int starIndex = s.indexOf('*');
        String prefix = s.substring(0, starIndex);
        String suffix = s.substring(starIndex + 1);

        for (int i = 0; i < n; i++) {
            String sd = br.readLine();

            if (sd.length() < prefix.length() + suffix.length()) {
                System.out.println("NE");
                continue;
            }

            // 앞부분이 prefix인지, 뒷부분이 suffix인지 확인
            boolean matches = sd.startsWith(prefix) && sd.endsWith(suffix);
            System.out.println(matches ? "DA" : "NE");
        }
    }

}
