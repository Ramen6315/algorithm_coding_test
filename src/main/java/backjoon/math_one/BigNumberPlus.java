package backjoon.math_one;

import java.math.BigDecimal;
import java.util.Scanner;

public class BigNumberPlus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");
        BigDecimal firstNum = new BigDecimal(inputs[0]);
        BigDecimal secondNum = new BigDecimal(inputs[1]);

        System.out.println(firstNum.add(secondNum));
    }
}
