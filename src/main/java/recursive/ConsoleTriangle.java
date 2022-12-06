package recursive;

import java.util.Scanner;

public class ConsoleTriangle {
    public  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String result = "*";
        printTriangle(n, result);
    }

    //result를 하나 출력 하고 -> 그다음에 하나 증가 시킨다 (단순하게 생각해서 풀면되는 문제 였음)
    private  void printTriangle(int n, String result) {
        if(n > 0) {
            System.out.println(result);
            printTriangle(n - 1, result + "*");
        }
    }
}
