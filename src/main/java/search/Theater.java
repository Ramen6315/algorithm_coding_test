package search;

import java.util.Scanner;

public class Theater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");

        int emptyChair = Integer.parseInt(inputs[0]);
        int audience = Integer.parseInt(inputs[1]);
        long totalCase = 1;
        long deleteCase = 1;
        for (int i = emptyChair; i > emptyChair - audience; i--) {
            totalCase *= i;
        }
        for (int i = 1; i <= audience; i++) {
            deleteCase *= i;
        }

        System.out.println((int) (totalCase / deleteCase));
    }

}
