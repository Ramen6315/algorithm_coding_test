import java.util.Comparator;
import java.util.PriorityQueue;


//while문이 어떻게 움직이는지 확인해야함
//숫자의 우선순위를 정해놓은 값들과 기존의 값들 두개를 가지고 첫 가장큰수위치를 찾으면서 진행하고 있음
//
public class Printer {
    public static void main(String[] args) {
        int[] pri = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(pri, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int priority : priorities) {
            priorityQueue.add(priority);
        }

        while (!priorityQueue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == priorityQueue.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    priorityQueue.poll();
                    answer++;
                }
            }
        }
        System.out.println(answer);
        return 0;
    }


}
