package recursive;

import java.util.Scanner;

public class CollatzBasic {
    public  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        collatzBasic(n);
    }

    private  void collatzBasic(int n) {
        if(n == 1) {
            System.out.println(n);
            return;
        }
        if(n % 2 == 1) {
            System.out.println(n);
            collatzBasic(3 * n + 1);
            return;
        }
        System.out.println(n);
        collatzBasic(n / 2);
    }
}
