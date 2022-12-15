package search;

import java.util.Scanner;

public class RGBCoast {

    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = Integer.parseInt(scanner.nextLine());
        int[][] rgbs = new int[cnt][3];
        int[][] memoization = new int[cnt][3];
        int result = 0;
        int index = 0;
        while(scanner.hasNextInt()) {
            try{
                String s = scanner.nextLine();
                String[] rgb = s.split(" ");

                rgbs[index][RED] = Integer.parseInt(rgb[RED]);
                rgbs[index][GREEN] = Integer.parseInt(rgb[GREEN]);
                rgbs[index][BLUE] = Integer.parseInt(rgb[BLUE]);
                index += 1;
            } catch(Exception e) {
                return;
            }
        }
        memoization[0][RED] = rgbs[0][RED];
        memoization[0][GREEN] = rgbs[0][GREEN];
        memoization[0][BLUE] = rgbs[0][BLUE];
        for (int i = 1; i < rgbs.length; i++) {
            memoization[i][RED] = Math.min(memoization[i-1][GREEN], memoization[i-1][BLUE]) + rgbs[i][RED];
            memoization[i][GREEN] = Math.min(memoization[i-1][RED], memoization[i-1][BLUE]) + rgbs[i][GREEN];
            memoization[i][BLUE] = Math.min(memoization[i-1][RED], memoization[i-1][GREEN]) + rgbs[i][BLUE];
        }

        System.out.println(Math.min(memoization[memoization.length - 1][RED],
                Math.min(memoization[memoization.length - 1][GREEN], memoization[memoization.length - 1][BLUE])));
    }
}
