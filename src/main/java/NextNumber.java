import java.util.ArrayList;
import java.util.List;

public class NextNumber {
    public static void main(String[] args) {
        System.out.println(solution(78));
    }

    public static int solution(int n) {
        int answer = findNextNumber(n);
        return answer;
    }

    private static int findNextNumber(int n) {
        int answer = 0;
        int nOneCnt = findOneCnt(n);
        for (int i = n+1; i <= 1000000; i++) {
            answer = findOneCnt(i, nOneCnt);
            if (answer != 0) {
                break;
            }
        }
        return answer;
    }

    private static int findOneCnt(int n) {
        int cnt = 0;
        int number = n;
        while(true) {
            if (number == 1 || number == 2) {
                cnt++;
                break;
            }
            if(number > 2) {
                if(number % 2 == 1) {
                    cnt++;
                }
                number = number/2;
            }
        }
        return cnt;
    }

    private static int findOneCnt(int i, int nOneCnt) {
        int cnt = 0;
        int number = i;
        while(true) {
            if (number == 1 || number == 2) {
                cnt++;
                if(cnt == nOneCnt) {
                    return i;
                }
                break;
            }
            if(number > 2) {
                if(number % 2 == 1) {
                    cnt++;
                }
                if (cnt > nOneCnt) {
                    break;
                }
                number = number/2;

            }
        }
        return 0;
    }
}
