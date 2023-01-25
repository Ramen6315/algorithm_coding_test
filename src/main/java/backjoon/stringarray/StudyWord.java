package backjoon.stringarray;

import java.util.Locale;
import java.util.Scanner;

public class StudyWord {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] alphabetCnt = new int[26];
        String lowWord = input.toLowerCase();
        String[] lowAlphabets = lowWord.split("");
        int max = 0;
        for (int i = 0; i < lowAlphabets.length; i++) {
            int alphabetLocation = lowAlphabets[i].charAt(0) - 97;
            alphabetCnt[alphabetLocation]++;
            max = Math.max(max, alphabetCnt[alphabetLocation]);
        }
        int cnt = 0;
        char result = '?';
        for (int i = 0; i < alphabetCnt.length; i++) {
            if(alphabetCnt[i] == max) {
                result = (char) (i + 97);
                cnt++;
            }
            if(cnt > 1) {
                result = '?';
            }
        }
        System.out.println(String.valueOf(result).toUpperCase(Locale.ROOT));
        
    }
}
