package backjoon.stringarray;

import java.util.Scanner;

public class CroatiaAlphabet {
    public void main(String[] args) {
        String[] croatiaConverts = {
                "c=",
                "c-",
                "dz=",
                "d-",
                "lj",
                "nj",
                "s=",
                "z="
        };

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int result = 0;
        boolean[] visit = new boolean[s.length()];
        for (int i = 0; i < croatiaConverts.length; i++) {
            if(s.contains(croatiaConverts[i])) {
                result += findWordCnt(croatiaConverts[i], s, visit);
            }
        }
        for (boolean b : visit) {
            if(!b) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static int findWordCnt(String croatiaConvert, String s, boolean[] visit) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            String words = s.substring(i);
            if(i + croatiaConvert.length() < s.length()) {
                words = s.substring(i, i + croatiaConvert.length());
            }

            boolean isVisit = visit[i];
            if(croatiaConvert.equals(words) && !isVisit) {
                checkWord(visit, i, croatiaConvert.length());
                cnt++;
            }
        }

        return cnt;
    }

    private static void checkWord(boolean[] visit, int i, int length) {
        for (int j = i; j < i + length; j++) {
            visit[j] = true;
        }
    }
}
