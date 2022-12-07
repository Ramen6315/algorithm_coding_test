package recursive;

import java.util.Scanner;

public class FibonachiRecursive {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 1;
        System.out.println(fibonachi(n, result));
    }

    private  int fibonachi(int n, int result) {
        if(n < 3) {
            return 1;
        } else {
            //두개의 재귀를 돌리는 방법에 대해서 머릿속으로 생각 할 수 있어야함
            result = fibonachi(n - 2, result + 100) + fibonachi(n - 1, result+ 100);
        }

        return result;
    }
}
