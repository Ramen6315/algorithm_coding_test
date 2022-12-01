package recursive;

import java.util.Scanner;

public class FactorialConsoleOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        factorial(n);
    }

    private static int factorial(int n) {
        if(n == 1) {
            return 1;
        } else {
            System.out.println(n);
            return factorial(n-1);
        }
    }
}
