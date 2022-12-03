package recursive;

import java.util.Scanner;

public class BetweenOddNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputs = scanner.nextLine();
        String[] inputArr = inputs.split(" ");
        int start = Integer.parseInt(inputArr[0]);
        int end = Integer.parseInt(inputArr[1]);
        betweenOddNumber(start, end);

    }

    private static void betweenOddNumber(int start, int end) {
        if(start > end) {
            return;
        } else {
            if(start % 2 == 1) {
                System.out.println(start);
            }
            betweenOddNumber(start + 1, end);
        }
    }
}
