package backjoon;

import java.util.Scanner;

public class SumOfNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String numStr = scanner.next();
        scanner.close();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += numStr.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}
