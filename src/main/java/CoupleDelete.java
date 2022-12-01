import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CoupleDelete {
    public static void main(String[] args) {
        solution("baabaa");
    }

    public static int solution(String s) {
        int answer = deleteCoupleDelete(s);

        return answer;
    }

    private static int deleteCoupleDelete(String s) {
        Stack<Character> wordStack = new Stack<>();
        wordStack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(wordStack.isEmpty()) {
                wordStack.push(s.charAt(i));
            }
            else if(!wordStack.peek().equals(s.charAt(i))) {
                wordStack.push(s.charAt(i));
            } else if(wordStack.peek().equals(s.charAt(i))) {
                wordStack.pop();
            }
        }
        if(wordStack.size() == 0) {
            return 1;
        }
        return 0;
    }
}
