package search;

import java.util.Scanner;

public class FillBlock {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int columns = scanner.nextInt();
        int[] cases = new int[columns];
        if(columns == 1) {
            System.out.println(1);
        } else if(columns == 2) {
            System.out.println(2);
        } else {
            cases[0] = 1;
            cases[1] = 2;
            System.out.println(findFillBlockCases(columns, cases));
        }

    }

    private static int findFillBlockCases(int columns, int[] cases) {
        for (int i = 2; i < columns; i++) {
            cases[i] = cases[i - 1] + cases[i - 2];
        }
        return cases[columns - 1];
    }
}
