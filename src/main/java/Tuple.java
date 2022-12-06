import java.util.*;

public class Tuple {
    public  void main(String[] args) {
        int[] solution = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        for (int s : solution) {
            System.out.println(s);
        }
    }
    public  int[] solution(String s) {
        List<Integer> results = new ArrayList<>();
        List<String> split = List.of(s.split(""));
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 2; i < split.size()-2; i++) {
            stringBuilder.append(split.get(i));
        }

        String filterTuple = stringBuilder.toString();
        List<String> completeFilteredTuples = new ArrayList<>(List.of(filterTuple.split("}," + "\\{")));
        completeFilteredTuples.sort(Comparator.comparing(String::length));

        for (String completeTuple : completeFilteredTuples) {
            String[] tupleStr = completeTuple.split(",");
            addTupleComponent(results, tupleStr);
        }

        int[] answers = new int[results.size()];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = results.get(i);
        }

        return answers;
    }

    private  void addTupleComponent(List<Integer> results, String[] tupleStr) {
        for (String tuple : tupleStr) {
            int number = Integer.parseInt(tuple);
            if(!results.contains(number)) {
                results.add(number);
            }
        }
    }
}
