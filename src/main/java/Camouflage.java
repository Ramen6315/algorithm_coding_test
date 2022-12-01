import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//조합 문제 없는 경우까지 추가 해서 중복 선택 제거 하면됨 5 * 4 * 3 * 2
public class Camouflage {

    public static void main(String[] args) {
        String[][] arr= {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        System.out.println(solution(arr));
    }

    public static int solution(String[][] clothes) {
        StringBuffer stringBuffer = new StringBuffer();
        int answer = 1;
        Map<String, List<String>> clothePartMap = new HashMap<>();
        for (String[] clothe : clothes){
            if(clothePartMap.containsKey(clothe[1])) {
                List<String> clotheList = clothePartMap.get(clothe[1]);
                clotheList.add(clothe[0]);
                clothePartMap.put(clothe[1], clotheList);
                continue;
            }
            List<String> clotheList = new ArrayList<>();
            clotheList.add(clothe[0]);
            clothePartMap.put(clothe[1],clotheList);
        }

        for (List<String> clotheList : clothePartMap.values()) {
            answer *= (clotheList.size() + 1);
        }
        answer -= 1;

        return answer;
    }
}
