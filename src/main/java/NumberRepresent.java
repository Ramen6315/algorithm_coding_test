public class NumberRepresent {
    public  void main(String[] args) {
        int solution = solution(15);
        System.out.println(solution);
    }

    public  int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += canRepresent(i, n);
        }
        return answer;
    }

    private  int canRepresent(int i, int n) {
        int result = i;
        if(result == n) {
            return 1;
        }
        for (int j = i+1; j <= n; j++) {
            if(result == n) {
                return 1;
            } else if(result > n) {
                return 0;
            }
            result += j;

        }
        return 0;
    }
}
