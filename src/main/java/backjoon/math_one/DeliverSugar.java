package backjoon.math_one;

import java.util.Scanner;

public class DeliverSugar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int fiveCount = input / 5;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= fiveCount; i++) {
            int fiveValue = i * 5;
            int threeValue = input - fiveValue;
            int threeCount = threeValue / 3;

            if(i * 5 + threeCount * 3 == input) {
                if(result > i + threeCount) {
                    result = i + threeCount;
                }
            }
        }
        if(result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
