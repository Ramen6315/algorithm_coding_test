package search;

import java.util.Scanner;

public class TheaterBlank {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");

        int emptyChair = Integer.parseInt(inputs[0]);
        int audience = Integer.parseInt(inputs[1]);
        if(emptyChair - audience * 2 + 1 > 0) {
            findCase(emptyChair, audience);
            System.out.println(count);
        } else {
            System.out.println(0);
        }

    }

    private static void findCase(int emptyChair, int audience) {
        if(audience == 0) {
            count +=1;
            return;
        } else if(audience == 1) {
            count += emptyChair;
            return;
        }
        for (int i = audience*2 - 3; i <= emptyChair - 2; i++) {
            findCase(i, audience - 1);
        }
    }
}
