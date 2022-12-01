import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zip {
    public static void main(String[] args) {
        Zip zip = new Zip();
        zip.solution("KAKAO");
    }

    public int[] solution(String msg) {

        Map<String, Integer> indexMap = createIndex();
        int index = 0;
        int loc = 0;
        String[] words = msg.split("");
        List<Integer> results = new ArrayList<>();
        int max = 26;
        while(true) {
            index = loc;
            for (int i = words.length - 1; i >= index; i--) {
                String word = msg.substring(index, i+1);
                if(indexMap.containsKey(word)) {
                    results.add(indexMap.get(word));
                    max++;
                    if(i + 1 == words.length) {
                        indexMap.put(msg.substring(index, i + 1), max);
                    } else {
                        indexMap.put(msg.substring(index, i + 2), max);
                    }
                     loc = i + 1;
                    break;
                }
            }
            if(index == words.length) {
                break;
            }
        }
        int[] answer = new int[results.size()];

        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }

    private Map<String, Integer> createIndex() {
        HashMap<String, Integer> createLZWIndex = new HashMap<>();
        for(int i=65; i < 91; i++) {
            createLZWIndex.put(Character.toString(i), i - 64);
        }
        return createLZWIndex;
    }
}
