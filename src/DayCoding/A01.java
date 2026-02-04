package DayCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A01 {
    static int[][] map;
    static long[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        result = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = map[i][j];
                if(v == 0) {
                    continue;
                }
                if (i+v < n) {
                    result[i+v][j] += result[i][j];
                }
                if (j+v < n) {
                    result[i][j+v] += result[i][j];
                }
            }
        }
        System.out.println(result[n-1][n-1]);
    }

}
