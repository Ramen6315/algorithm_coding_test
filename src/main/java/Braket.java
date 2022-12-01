import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Braket {
    public static void main(String[] args) {
        solution("()()");
    }
    private static boolean solution(String s) {
        if(')' == s.charAt(0)) {
            return false;
        }
        return findCorrectBraket(s);
    }

    private static boolean findCorrectBraket(String s) {
        Stack<Character> braketStacks = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if('(' == s.charAt(i)) {
                braketStacks.push((s.charAt(i)));
            } else if (!braketStacks.isEmpty() && '(' == braketStacks.peek() && ')' == (s.charAt(i))) {
                braketStacks.pop();
            } else {
                braketStacks.push((s.charAt(i)));
            }

        }
        return braketStacks.isEmpty();
    }
}
