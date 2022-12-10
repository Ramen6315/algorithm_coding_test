package recursive;

import java.math.BigDecimal;
import java.util.Scanner;

// 값은 제대로 나오나 효율성 및 메모리 쪽에서 관리가 안됨 다시보고 줄일 수 있는 방법을 찾아야함
public class CollatzLarge {
    static BigDecimal[] memoization;
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String collatz = scanner.nextLine();
        String[] collatzMinMax = collatz.split(" ");
        int min = Integer.parseInt(collatzMinMax[0]);
        int max = Integer.parseInt(collatzMinMax[1]);
        memoization= new BigDecimal[max + 1];
        int resultMax = 0;
        int resultIndex = 0;
        for (int i = min; i <= max; i++) {
            BigDecimal bigDecimal = BigDecimal.valueOf(i);
            BigDecimal result = collatz(bigDecimal, max);
            if(result.intValue() > resultMax) {
                resultMax = result.intValue();
            }
            memoization[i] = result;
        }
        for (int i = 0; i < memoization.length; i++) {
            if(memoization[i] != null && memoization[i].intValue() == resultMax) {
                resultIndex = i;
            }
        }
        System.out.println(resultIndex + " " + resultMax);
    }

    private BigDecimal collatz(BigDecimal bigDecimal, int max) {
        if(bigDecimal.compareTo(BigDecimal.valueOf(max)) > 0) {
            if(bigDecimal.remainder(BigDecimal.valueOf(2)).equals(BigDecimal.valueOf(1))) {
                return BigDecimal.valueOf(1).add(collatz(bigDecimal.multiply(BigDecimal.valueOf(3)).add(BigDecimal.valueOf(1)), max));
            } else {
                return BigDecimal.valueOf(1).add(collatz(bigDecimal.divide(BigDecimal.valueOf(2)), max));
            }
        } else if(bigDecimal.compareTo(BigDecimal.valueOf(max)) < 0  && memoization[bigDecimal.intValue()] != null) {
            return memoization[bigDecimal.intValue()];
        }
        if(bigDecimal.intValue() == 1) {
            return BigDecimal.valueOf(1);
        }
        if(bigDecimal.remainder(BigDecimal.valueOf(2)).equals(BigDecimal.valueOf(1))) {
            memoization[bigDecimal.intValue()] = BigDecimal.valueOf(1).add(collatz(bigDecimal.multiply(BigDecimal.valueOf(3)).add(BigDecimal.valueOf(1)), max));
            return memoization[bigDecimal.intValue()];
        } else {
            memoization[bigDecimal.intValue()] = BigDecimal.valueOf(1).add(collatz(bigDecimal.divide(BigDecimal.valueOf(2)), max));
            return memoization[bigDecimal.intValue()];
        }
    }
}
