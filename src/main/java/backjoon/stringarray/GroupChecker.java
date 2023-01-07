package backjoon.stringarray;

import java.util.Scanner;

public class GroupChecker {
    public static void main(String[] args) {
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        for (int i=0; i< cnt; i++) {
            StringBuilder answer = new StringBuilder();

            String word = scanner.next();
            result += findGroup(word);
        }
        System.out.println(result);
    }

    private static int findGroup(String word) {
        String[] split = word.split("");
        String group = split[0];
        for (int i = 1; i < split.length; i++) {
            if(!split[i-1].equals(split[i])) {
                group += split[i];
            }
        }
        String[] groupWords = group.split("");
        for (int i = 0; i < groupWords.length; i++) {
            for (int i1 = i+1; i1 < groupWords.length; i1++) {
                if(groupWords[i].equals(groupWords[i1])){
                    return 0;
                }
            }
        }
        return 1;
    }
}
