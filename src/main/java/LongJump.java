
//점화식 -> 1번째 2번째 3번째 가는 방법을 통해서 점화식 찾아서 DP 적용
public class LongJump {
    public  void main(String[] args) {
        solution(2000);
    }

    public  long solution(int n) {
        long answer = findWay(n);
        return answer;
    }

    private  long findWay(int n) {
        long[] ways = new long[n+1];
        ways[0] = 1;
        ways[1] = 1;
        if(n == 1) {
            return 1;
        }
        for (int i = 2; i < ways.length; i++) {
            ways[i] = (ways[i-1] + ways[i-2]) % 1234567;
        }
        return ways[n];
    }
}
