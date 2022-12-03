package recursive;

//TODO : 상세 Flow 하나씩 입력 할 것

import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String result = "";
        System.out.println(createBinary(n, result));
    }

    private static String createBinary(int n, String result) {
        if (n < 2) {
            result += String.valueOf(n);
            return result;
        } else {
            result += createBinary(n / 2, result);
            result += String.valueOf(n % 2);
        }
        return result;
    }
}
