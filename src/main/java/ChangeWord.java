import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ChangeWord {
    public  void main(String[] args) {
        ChangeWord changeWord = new ChangeWord();
        String begin = "aab";
        String target = "aba";
        String[] words = {"abb", "aba"};
        System.out.println(changeWord.solution(begin, target, words));
    }
    int answer;
    boolean[] visit;
    public int solution(String begin, String target, String[] words) {
        boolean noneMatch = Arrays.stream(words)
                .noneMatch(word -> word.equals(target));
        if(noneMatch) {
            return 0;
        }
        answer = words.length;
        visit = new boolean[words.length];
        dfs(0,visit, begin, target, words);

        return answer;
    }

    private void dfs(int depth, boolean[] visit, String begin, String target, String[] words) {
        if(begin.equals(target)) {
            answer = Math.min(answer, depth);
        }
//        if(depth == words.length && !begin.equals(target)) {
//            answer = 0;
//        }
        for (int i = 0; i < words.length; i++) {
            if(isTargetWord(begin, words[i]) && !visit[i]) {
                visit[i] = true;
                dfs(depth + 1, visit, words[i], target, words);
                visit[i] = false;
            }
        }
    }


    private boolean isTargetWord(String target, String word) {
        String[] alphas = word.split("");
        String[] targetAlphas = target.split("");
        int cnt = 0;
        for (int i = 0; i < alphas.length; i++) {
            if(alphas[i].equals(targetAlphas[i])) {
                cnt++;
            }
        }
        return cnt == target.length() - 1;
    }
}
