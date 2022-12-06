import java.util.LinkedList;
import java.util.Queue;

public class TargetNumber {

    public  void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(targetNumber.solution(numbers, target));
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        Num num = new Num(0, 0);
        Queue<Num> bfs = new LinkedList<>();
        bfs.add(num);
        while(!bfs.isEmpty()) {
            Num targetNum = bfs.poll();
            if(targetNum.getCnt() == numbers.length && targetNum.getVal() == target) {
                answer++;
                continue;
            }

            if(targetNum.getCnt() < numbers.length){
                int cnt = targetNum.getCnt() + 1;
                bfs.add(new Num(cnt, targetNum.getVal() + numbers[targetNum.getCnt()]));
                bfs.add(new Num(cnt, targetNum.getVal() - numbers[targetNum.getCnt()]));
            }

        }
        return answer;
    }

    class Num {
        int cnt;
        int val;

        public Num(int cnt, int val) {
            this.cnt = cnt;
            this.val = val;
        }

        public int getCnt() {
            return cnt;
        }

        public int getVal() {
            return val;
        }
    }
}
