import java.util.HashSet;
import java.util.Set;

public class Carpet {
    public static void main(String[] args) {
        int[] solution = solution(24, 24);
        System.out.println(solution[0] + " : " + solution[1]);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = findWidthHeight(brown, yellow);
        return answer;
    }

    private static int[] findWidthHeight(int brown, int yellow) {
        int[] result = new int[2];
        Set<Integer> yellowFactor = findFactor(yellow);
        for (int factor : yellowFactor) {
            int brownRow = brown;
            brownRow -= factor * 2;
            int row = yellow / factor;
            if(brownRow / 2 == row + 2 && row + 2 >= factor +2) {
                result[0] = row + 2;
                result[1] = factor + 2;
            }
        }
        return result;
    }

    private static Set<Integer> findFactor(int yellow) {
        Set<Integer> factors = new HashSet<>();
        if(yellow == 1) {
            factors.add(1);
            return factors;
        }
        for (int i = 1; i <= yellow / 2; i++) {

            if(yellow % i == 0) {
                factors.add(i);
                factors.add(yellow / i);
            }
        }
        return factors;
    }
}
