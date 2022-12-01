import java.util.HashSet;
import java.util.Set;

public class EnglishGame {
    public static void main(String[] args) {
        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        int n = 5;
        solution(n, words);

    }

    public static int[] solution(int n, String[] words) {

        int[] answer = findResult(n, words);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer[0] + " : " + answer[1]);

        return answer;
    }

    private static int[] findResult(int n, String[] words) {
        boolean isEnd = true;
        Set<String> uponWord = new HashSet<>();
        int playerTurn = 1;
        uponWord.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || uponWord.contains(words[i])) {
                isEnd = false;
                break;
            }
            if(words[i-1].charAt(words[i-1].length()-1) == words[i].charAt(0) && !uponWord.contains(words[i])) {
                uponWord.add(words[i]);
                playerTurn++;
            }
        }
        int player;
        int turn;
        int[] result = new int[2];
        if(playerTurn == words.length && isEnd) {
            player = 0;
            turn = 0;
        } else {
            player = playerTurn % n + 1;
            turn = playerTurn / n + 1;
        }
        result[0] = player;
        result[1] = turn;
        return result;
    }
}
