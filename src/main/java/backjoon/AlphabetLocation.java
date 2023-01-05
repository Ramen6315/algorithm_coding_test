package backjoon;

import java.util.Scanner;

public class AlphabetLocation {
    public static void main(String[] args) {
        int[] alphabetValue = new int[26];

        for (int i = 0; i < alphabetValue.length; i++) {
            alphabetValue[i] = -1;
        }

        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        scanner.close();

        String[] alphabets = word.split("");
        for (int i = 0; i < alphabets.length; i++) {
            int location = alphabets[i].charAt(0) - 97;
            if(alphabetValue[location] == -1){
                alphabetValue[location] = i;
            }

        }

        for (int i : alphabetValue) {
            System.out.print(i + " ");
        }
    }
}
