import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] registered = {"cow", "cow1", "cow2", "cow3", "cow4", "cow5", "cow6"};
        solution.solution(registered, "cow");
    }
    public String solution(String[] registered_list, String new_id) {

        String answer = checkResultId(registered_list, new_id);
        System.out.println(answer);
        return answer;
    }

    private String checkResultId(String[] registered_list, String new_id) {
        boolean isContain = false;
        List<String> strings = Arrays.asList(registered_list);
        while(!isContain) {
            if(strings.contains(new_id)) {
                isContain = false;
                new_id = createNewId(new_id);
            } else {
                isContain = true;
            }
        }
        return new_id;

    }

    private String createNewId(String new_id) {
        String intStr = new_id.replaceAll("[^0-9]", "");
        String idStr = new_id.replaceAll("[0-9]", "");

        if(intStr.isEmpty()) {
            intStr = "0";
        }
        Integer idNumber = Integer.valueOf(intStr);
        idNumber += 1;
        return idStr + String.valueOf(idNumber);
    }

}
