package recursive;

import java.math.BigDecimal;
import java.util.Scanner;

public class FibonachiRecursiveLarge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigDecimal result = BigDecimal.valueOf(1);
        BigDecimal[] memoization = new BigDecimal[n + 1];
        System.out.println(fibonachi(BigDecimal.valueOf(n), result, memoization).remainder(BigDecimal.valueOf(10009)).intValue());
    }

    private static BigDecimal fibonachi(BigDecimal n, BigDecimal result, BigDecimal[] memoization) {
        if(memoization[n.intValue()] != null) {
            return memoization[n.intValue()];
        }
        if(n.intValue() < 3) {
            return BigDecimal.valueOf(1);
        } else {
            //두개의 재귀를 돌리는 방법에 대해서 머릿속으로 생각 할 수 있어야함
            result = fibonachi(n.subtract(BigDecimal.valueOf(2)), result, memoization)
                    .add(fibonachi(n.subtract(BigDecimal.valueOf(1)), result, memoization));
            memoization[n.intValue()] = result;

        }

        return result;
    }
}
