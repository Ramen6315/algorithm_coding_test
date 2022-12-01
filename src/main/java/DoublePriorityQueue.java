import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DoublePriorityQueue {
    public static void main(String[] args) {
        String[] operation = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(solution(operation));
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> storages = new ArrayList<>();

        for (String operation : operations) {
            String[] commandLine = operation.split(" ");
            String command = commandLine[0];
            String target = commandLine[1];
            if("I".equals(command)) {
                storages.add(Integer.parseInt(target));
                storages.sort(Comparator.naturalOrder());
            } else if("D".equals(command)) {
                if("1".equals(target)) {
                    if(!storages.isEmpty()) {
                        storages.remove(storages.size()-1);
                    }
                } else if("-1".equals(target)) {
                    if(!storages.isEmpty()) {
                        storages.remove(0);
                    }
                }
            }
        }

        if(storages.size() == 1) {
            Integer result = storages.get(0);
            answer[0] = result;
            answer[1] = result;
        } else if (storages.size() > 1) {
            answer[0] = storages.get(storages.size()-1);
            answer[1] = storages.get(0);
        }
        return answer;
    }
}
