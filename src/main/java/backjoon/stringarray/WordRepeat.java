package backjoon.stringarray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordRepeat {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();

        for (int i=0; i< cnt; i++) {
            StringBuilder answer = new StringBuilder();
            int repeatCnt = scanner.nextInt();
            String word = scanner.next();
            String[] split = word.split("");
            for (String s : split) {
                answer.append(s.repeat(repeatCnt));
            }
            System.out.println(answer);
        }
    }
}
