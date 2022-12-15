package search;

import java.util.Scanner;

public class CodeupVersusKoistudy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = Integer.parseInt(scanner.nextLine());
        int[][] levelScores = new int[2][cnt];
        int[][] memoization = new int[2][cnt];
        int index = 0;
        while(scanner.hasNextInt()) {
            String levelScoreInput = scanner.nextLine();
            String[] codeScores = levelScoreInput.split(" ");
            if(index == 0) {
                for (int i = 0; i < codeScores.length; i++) {
                    levelScores[0][i] = Integer.parseInt(codeScores[i]);
                }
                index++;
            } else if (index == 1) {
                for (int i = 0; i < codeScores.length; i++) {
                    levelScores[1][i] = Integer.parseInt(codeScores[i]);
                }
                index++;
            }else {
                break;
            }
        }
        int min = 0;
        if(levelScores[0][0] < levelScores[1][0]) {
            memoization[1][0] = levelScores[1][0];
            min = levelScores[1][0] - levelScores[0][0];
        } else {
            memoization[0][0] = levelScores[0][0];
            min = levelScores[0][0] - levelScores[1][0];
        }

        int numberGap = 0;
        for (int i = 1; i < levelScores[0].length; i++) {
            int beforeMax = Math.max(memoization[0][i - 1], memoization[1][i - 1]);
            if(levelScores[0][i] < levelScores[1][i]) {
                numberGap = levelScores[1][i] - levelScores[0][i];
                memoization[1][i] = levelScores[1][i] +beforeMax;
            } else {
                numberGap = levelScores[0][i] - levelScores[1][i];
                memoization[0][i] = levelScores[0][i] + beforeMax;
            }
            if(numberGap < min) {
                min = numberGap;
            }
        }

        boolean isAllZero = checkAllZero(memoization);
        if(isAllZero) {
            System.out.println(Math.max(memoization[0][memoization[0].length - 1], memoization[1][memoization[1].length - 1]) - min);
        } else {
            System.out.println(Math.max(memoization[0][memoization[0].length - 1], memoization[1][memoization[1].length - 1]));
        }

    }

    private static boolean checkAllZero(int[][] memoization) {
        boolean isZero = true;
        for (int i = 0; i < memoization[0].length; i++) {
            if (memoization[0][i] > 0) {
                isZero = false;
                break;
            }
        }
        if(isZero) {
            return true;
        }
        isZero = true;
        for (int i = 0; i < memoization[0].length; i++) {
            if (memoization[1][i] > 0) {
                isZero = false;
                break;
            }
        }
        if(isZero) {
            return true;
        }
        return isZero;
    }
}
