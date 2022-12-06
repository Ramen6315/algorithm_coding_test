import java.util.Comparator;
import java.util.PriorityQueue;

public class MoreHot {
    public  void main(String[] args) {
        MoreHot moreHot = new MoreHot();
        int[] scoville =  {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(moreHot.solution(scoville, K));
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovillePriority = new PriorityQueue<>(Comparator.naturalOrder());
        for (int scov : scoville) {
            scovillePriority.add(scov);
        }
        int count = 0;
        while(true) {
            if(scovillePriority.size() < 2 && scovillePriority.peek() < K) {
                return -1;
            }
            if(scovillePriority.peek() < K) {
                count++;
                Integer lowestScoville = scovillePriority.poll();
                Integer secondlowestScoville = scovillePriority.poll();
                scovillePriority.add(lowestScoville + (secondlowestScoville *2));
            } else {
                break;
            }



        }
        return count;
    }
}
