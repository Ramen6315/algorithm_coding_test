package backjoon.stringarray;

import java.util.Scanner;

public class Dial {
    public void main(String[] args) {
        String alphabet = "ABC DEF GHI JKL MNO PQRS TUV WXYZ";
        String[] dials = alphabet.split(" ");

        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        String[] numbers = number.split("");
        int result = 0;
        for (String s : numbers) {
            int loc = 3;
            for (int i = 0; i < dials.length; i++) {
                if(dials[i].contains(s)) {
                    result += loc;
                    break;
                } else {
                    loc++;
                }
            }
        }
        System.out.println(result);

    }
}
