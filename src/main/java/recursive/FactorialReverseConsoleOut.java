package recursive;

import java.util.Scanner;

public class FactorialReverseConsoleOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        factorial(n);
    }

    private static void factorial(int n) {
        if(n > 0) {
            System.out.println(n);
            factorial(n - 1);
        }
    }
}
