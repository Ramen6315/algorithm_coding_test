package recursive;

import java.util.Scanner;


//호출시점을 잘 파악 해야함
public class CollatzReverse {
    public  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        collatz(n);
        System.out.println(n);
    }

    private  void collatz(int n) {
        if(n == 1) {
            return;
        }
        if(n % 2 == 1) {
            collatz((3*n + 1));
            System.out.println(3*n + 1);
        } else {
            collatz(n / 2);
            System.out.println(n / 2);
        }
    }
}
