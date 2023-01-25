package backjoon.stringarray;

import java.util.Scanner;

public class NumberVersus {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        String firstNumber = numbers[0];
        String secondNumber = numbers[1];

        String changeFirstNumber = changeNumber(firstNumber);
        String changeSecondNumber = changeNumber(secondNumber);

        System.out.println(Math.max(Integer.parseInt(changeFirstNumber), Integer.parseInt(changeSecondNumber)));

    }

    private static String changeNumber(String number) {
        StringBuilder result = new StringBuilder();
        String[] split = number.split("");
        for (int i = split.length - 1; i > -1; i--) {
            result.append(split[i]);
        }
        return result.toString();
    }
}
