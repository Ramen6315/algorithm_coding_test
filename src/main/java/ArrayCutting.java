import java.util.ArrayList;
import java.util.List;

// 이문제는 다시 풀어보는게 좋음
public class ArrayCutting {
    public static void main(String[] args) {
        System.out.println(solution(4, 7, 14));
    }
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int[] num = new int[n];
        for (int i = 0; i < num.length; i++) {
            num[i] = i+1;
        }

        int start = 1;
        start += left / n;

        for (long i = left; i <= right; i++) {
            int index = (int) (i % n);
            if(num[index] < start) {
                answer[(int) (i-left)] = start;
            } else {
                answer[(int) (i-left)] = num[index];
            }
            if(num[index] == n) {
                start++;
            }
        }
        return answer;
    }
}
