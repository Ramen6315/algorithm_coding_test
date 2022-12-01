import java.util.Arrays;

public class BestAggregate {
    public static void main(String[] args) {
        System.out.println(solution(2, 1));
    }

    public static int[] solution(int n, int s) {
        int middle = s / n;
        int[] middleNum = new int[n];
        if(middle == 0) {
            middleNum = new int[1];
            middleNum[0] = -1;
            return middleNum;
        }

        int standard = 0;
        for (int i = 0; i < middleNum.length; i++) {
            middleNum[i] = middle;
            standard += middle;
        }

        int distance = standard - s;
        if(distance < 0) {
            for (int i = 0; i < middleNum.length; i++) {
                middleNum[i] += 1;

                if(++distance == 0) {
                    break;
                }
            }
        } else if(distance > 0) {
            for (int i = 0; i < middleNum.length; i++) {
                middleNum[i] -= 1;
                if(--distance == 0) {
                    break;
                }
            }
        }
        Arrays.sort(middleNum);
        int[] answer = middleNum;

        for (int a :  answer){
            System.out.println(a);
        }
        return answer;
    }
}
