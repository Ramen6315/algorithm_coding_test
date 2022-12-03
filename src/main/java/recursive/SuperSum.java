package recursive;

import java.util.Scanner;

public class SuperSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String next = scanner.nextLine();
            String[] s = next.split(" ");
            int k = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            int[][] memoization = new int[k+1][n+1];
            System.out.println(superSum(k, n, memoization));
        }
    }

    private static int superSum(int k, int n, int[][] memoization) {
        int result = 0;
        if (k > 0) {
            for (int i = 1; i <= n; i++) {
                if (memoization[k][i] != 0) {
                    result += memoization[k][i];
                } else {
                    memoization[k][i] = superSum(k - 1, i, memoization);
                    result += memoization[k][i];
                }
            }
        } else {
            memoization[0][n] = n;
            result += n;
        }
        return result;
    }
}
