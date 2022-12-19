package search;

import java.util.Scanner;
//재귀로 풀 수 있는데 해당 조건을 적용할 수 있는 State값의 진행상황을 지속해서 확인 할 수 있어야함
public class ShortLeg {
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int start = 0;
        int threeStepCnt = 0;
        moveStep(start, input, threeStepCnt);
        System.out.println(cnt);
    }

    private static void moveStep(int start, int input, int threeStepCnt) {
        if(start > input) {
            return;
        }
        if(start == input) {
            cnt++;
            return;
        }

        if(threeStepCnt < 1) {
            moveStep(start + 3, input, threeStepCnt + 2);
            moveStep(start+1, input, threeStepCnt);
            moveStep(start+2, input, threeStepCnt);
        } else {
            moveStep(start + 1, input, threeStepCnt - 1);
            moveStep(start + 2, input, threeStepCnt - 1);
        }
    }
}
