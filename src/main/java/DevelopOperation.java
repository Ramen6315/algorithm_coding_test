import java.util.ArrayList;
import java.util.List;

public class DevelopOperation {
    public  void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(solution(progresses, speeds));
    }

    public  int[] solution(int[] progresses, int[] speeds) {
        List<Integer> results = new ArrayList<>();
        int days = calculateMergeDays(progresses[0], speeds[0]);
        int cnt = 1;
        for (int i = 1; i < progresses.length; i++) {
            if(days * speeds[i] + progresses[i] >= 100) {
                cnt++;
                if(i == progresses.length-1) {
                    results.add(cnt);
                    break;
                }
            } else {
                results.add(cnt);
                days = calculateMergeDays(progresses[i], speeds[i]);
                cnt = 1;
                if(i == progresses.length-1) {
                    results.add(cnt);
                    break;
                }
            }
        }

        System.out.println(results);
        int[] answer = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }

    private  int calculateMergeDays(int progress, int speed) {
        int devProgresses = 100 - progress;
        if(devProgresses % speed > 0) {
            return devProgresses / speed + 1;
        }
        return devProgresses / speed;
    }
}
