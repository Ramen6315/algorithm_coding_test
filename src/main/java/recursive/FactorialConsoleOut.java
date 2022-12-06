package recursive;

import java.util.Scanner;

public class FactorialConsoleOut {
    public  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        factorialConsoleOut(n);
    }

    private  void factorialConsoleOut(int n) {
        if(n > 1) {
            factorialConsoleOut(n - 1);
        }
        System.out.println(n);
    }
}
