package backjoon.math_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPrimeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        int result = 0;
        int max = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if(findPrime(i)) {
                result +=i;
                if(max > i) {
                    max = i;
                }
            }
        }
        if(result == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
        System.out.println(max);

    }

    private static boolean findPrime(int input) {
        if(input < 2) {
            return false;
        }
        for (int i = 2; i * i <= input; i++) {
            if(input % i == 0) {
                return false;
            }
        }
        return true;
    }
}

