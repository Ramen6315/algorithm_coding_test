package backjoon.stringarray;

import java.util.Scanner;

public class WordCount {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int answer = 0;
        for (String s2 : s1) {
            if(s2.isBlank() || s2.isEmpty()) {
                continue;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
