package hanghee99_Middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class hh03_programmers161990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] wallpaper = new String[3];

        wallpaper[0] = ".#...";
        wallpaper[1] = "..#..";
        wallpaper[2] = "...#.";

//        String[] wallpaper = new String[5];
//
//        wallpaper[0] = "..........";
//        wallpaper[1] = ".....#....";
//        wallpaper[2] = "......##..";
//        wallpaper[3] = "...##.....";
//        wallpaper[4] = "....#.....";
//
//        String[] wallpaper = new String[2];
//
//        wallpaper[0] = "..";
//        wallpaper[1] = "#.";


        System.out.println(Arrays.toString(solution(wallpaper)));
    }
    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {

                    if (i < lux){
                        lux = i;
                    }
                    if(i+1 > rdx){
                        rdx = i+1;
                    }
                    if (j < luy){
                        luy = j;
                    }
                    if (j + 1 > rdy){
                        rdy = j + 1;
                    }
                }
            }
        }
        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx; //완
        answer[3] = rdy;

        return answer;
    }
}
