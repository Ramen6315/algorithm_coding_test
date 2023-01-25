package backjoon.math_one;

import java.util.Scanner;

/**
 * 해당 숫자가 포함된 위치가 짝수, 홀수 냐에 따라
 * 짝수 분자 = 현재 위치 - 이전 원소 갯수 = 현재 원소의 갯수 - 분자 + 1
 * 홀수 분모 = 현재 위치 - 이전 원소 갯수, 분자 = 현재 원소의 갯수 - 분모 + 1
 * 로 되는데 여기서 +1 을 하는 이유는 분자 + 분모의 값은 현재 위치한 대각선 열의 값보다 1이 많기 때문에 + 1을 해준다
 *
 */
public class FindFraction {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loc = scanner.nextInt();
        int start = 1;
        int count = 0;
        while(true) {
            if(loc <= start + count) {
                if(start % 2 == 1) {
                    int head = start - (loc - count - 1);
                    int bot = loc - count;
                    System.out.println(head + "/" + bot);
                    break;
                } else {
                    int head = loc - count;
                    int bot = start - (loc - count - 1);
                    System.out.println(head + "/" + bot);
                    break;
                }
            }
            count += start;
            start++;
        }

    }
}
