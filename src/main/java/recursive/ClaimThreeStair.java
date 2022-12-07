package recursive;

import java.math.BigDecimal;
import java.util.Scanner;

public class ClaimThreeStair {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigDecimal[] memoization = new BigDecimal[3];

        fibonachi(n, memoization);
        System.out.println(memoization[n%3].remainder(BigDecimal.valueOf(1000)).intValue());
    }

    private static BigDecimal fibonachi(int n, BigDecimal[] memoization) {
        for (int i = 0; i <= n; i++) {
            if(i < 2) {
                memoization[i % 3] = BigDecimal.valueOf(1);
            } else if(i == 2) {
                memoization[i % 3] = BigDecimal.valueOf(2);
            } else {
                memoization[i % 3] = memoization[i % 3].add(memoization[(i - 1) % 3]).add(memoization[(i - 2) % 3]);
            }

        }
        return memoization[n % 3].remainder(BigDecimal.valueOf(1000));
    }
}
