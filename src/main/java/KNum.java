import java.util.ArrayList;
import java.util.List;

public class KNum {
    public  void main(String[] args) {
        System.out.println(solution(437674, 3));
    }

    public  int solution(int n, int k) {
        int answer = 0;
        String kNumStr = findKNum(n, k);

        String[] nums = kNumStr.split("0");
        for (String num : nums) {
            if(num.length()>0) {
                answer += findPrime(num);
            }
        }

        return answer;
    }

    private  int findPrime(String kNumStr) {
        long kNum = Long.parseLong(kNumStr);
        if(kNum <= 1) {
            return 0;
        }
        for (long i = 2; i * i <= kNum; i++) {
            if(kNum % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    private  String findKNum(int n, int k) {
        StringBuilder str = new StringBuilder();
        int num = n;
        List<Integer> kNums = new ArrayList<>();
        while(true) {
            int next = num/k;
            if(next == 0) {
                kNums.add(num%k);
                break;
            } else {
                kNums.add(num%k);
                num = num/k;
            }
        }
        for (int i = kNums.size() - 1; i >= 0; i--) {
            str.append(kNums.get(i));
        }
        return str.toString();
    }
}
