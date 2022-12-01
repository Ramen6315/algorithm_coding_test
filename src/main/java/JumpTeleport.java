//DP 방식과 비슷하게 규칙성을 찾는게 포인트임

public class JumpTeleport {
    public static void main(String[] args) {
        System.out.println(solution(5000));
    }

    public static int solution(int n) {
        return calculateWays(n);
    }

    private static int calculateWays(int n) {
        int cnt = 1;
        int number = n ;
        while(true) {
            if(number == 1) {
                break;
            }

            if(number % 2 == 1) {
                number = number - 1;
                cnt++;
            } else {
                number = number / 2;
            }
        }
        return cnt;
    }
}
