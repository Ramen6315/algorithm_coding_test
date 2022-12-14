package recursive;

import java.util.Scanner;

public class NSum {
    public  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(recursiveSum(n));
    }

    private  int recursiveSum(int n) {
        if(n > 0) {
            n += recursiveSum(n - 1);
        }
        return n;
    }
}
