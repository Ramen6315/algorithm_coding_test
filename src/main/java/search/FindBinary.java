package search;

import java.util.Scanner;

public class FindBinary {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] numbers = new int[number];
        if(number == 1) {
            numbers[0] = 2;
        }
        if(number >= 2){
            numbers[0] = 2;
            numbers[1] = 3;
        }
        System.out.println(findBinary(number - 1, numbers));
    }

    private static int findBinary(int number, int[] numbers) {
        if(number < 2) {
            return numbers[number];
        }
        for (int i = 2; i <= number; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }
        return numbers[number];
    }
}
