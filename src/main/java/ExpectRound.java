public class ExpectRound {
    public static void main(String[] args) {
        solution(8, 4, 5);
    }

    public static int solution(int n, int a, int b) {
        int answer = 0;
        while(true) {

            if(a == b) {
                break;
            }
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;

        }
        System.out.println(answer);
        return answer;
    }
}
