import java.util.Collections;
import java.util.PriorityQueue;


// 지속적으로 최대 값을 찾아야 할 경우에는 우선순위Queue 사용을 생각하자
public class JYPScore {
    public  void main(String[] args) {
        JYPScore jypScore = new JYPScore();
        int[] works = {4, 3, 3};
        int n = 4;
        System.out.println(jypScore.solution(n, works));
    }

    public long solution(int n, int[] works) {
        boolean isNoJYP = true;
        long answer = 0;
        PriorityQueue<Integer> priorityWorks = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            priorityWorks.offer(work);
        }
        for (int i = 0; i < n; i++) {
            Integer maxWork = priorityWorks.poll();
            if(maxWork  <= 0) {
                break;
            }
            priorityWorks.offer(maxWork - 1);
        }
        for (int work : priorityWorks) {
            answer += Math.pow(work, 2);
            if(work > 0) {
                isNoJYP = false;
            }
        }
        if(isNoJYP) {
            return 0;
        }
        return answer;
    }
}
