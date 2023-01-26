package backjoon.math_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        int result = 0;
        String[] inputs = numbers.split(" ");
        for (int i = 0; i < cnt; i++) {
            if(findPrime(inputs[i])) {
                 result++;
            }
        }
        System.out.println(result);

    }

    private static boolean findPrime(String input) {
        int number = Integer.parseInt(input);
        if(number < 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
