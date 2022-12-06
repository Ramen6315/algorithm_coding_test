import java.util.*;

public class BraketCircle {
    public  void main(String args[]) {
        System.out.println(solution("}]()[{"));
    }

    public  int solution(String s) {
        int answer = 0;
        String[] braketArray = s.split("");
        Queue<String> braketQueue = new LinkedList<>(Arrays.asList(braketArray));

        for(int i=0; i < s.length(); i++) {
            answer += checkCompleteBracket(braketQueue);
            String firstQueueBraket = braketQueue.poll();
            braketQueue.add(firstQueueBraket);
        }

        return answer;
    }

    private  Queue<String> aroundBraketQueue(Queue<String> braketQueue) {
        String firstQueueBraket = braketQueue.poll();
        braketQueue.add(firstQueueBraket);

        return braketQueue;
    }

    private  int checkCompleteBracket(Queue<String> braketQueue) {
        Queue<String> brakets = new LinkedList<>(braketQueue);
        Stack<String> braketStack = new Stack<>();
        while(!brakets.isEmpty()) {
            if(braketStack.isEmpty()) {
                braketStack.push(brakets.poll());
                continue;
            }
            String peek = braketStack.peek();
            if("[".equals(peek) && "]".equals(brakets.peek())) {
                brakets.poll();
                braketStack.pop();
                continue;
            } else if ("{".equals(peek) && "}".equals(brakets.peek())) {
                brakets.poll();
                braketStack.pop();
                continue;
            } else if ("(".equals(peek) && ")".equals(brakets.peek())) {
                brakets.poll();
                braketStack.pop();
                continue;
            }
            braketStack.push(brakets.poll());
        }
        if(braketStack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}
