import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertBinary {

    public  void main(String[] args) {
        solution("110010101001");
    }

    public  int[] solution(String s) {
        int[] answer = new int[2];
        List<String> numbersStr = Arrays.asList(s.split(""));

        return findResult(numbersStr);
    }

    private  int[] findResult(List<String> numbersStr) {
        int zeroDeleteCnt = 0;
        int convertCount = 0;

        while(true) {
            List<String> oneStr = new ArrayList<>();
            if(numbersStr.size() == 1 && "1".equals(numbersStr.get(0))){
                break;
            }
            for (String number : numbersStr) {
                if(number.equals("0")) {
                    zeroDeleteCnt++;
                    continue;
                }
                oneStr.add(number);
            }
            int size = oneStr.size();
            List<String> strings = convertBinary(size);
            convertCount++;
            numbersStr = strings;
        }

        int[] answer = new int[2];
        answer[0] = convertCount;
        answer[1] = zeroDeleteCnt;
        return answer;
    }

    private  List<String> convertBinary(int size) {
        List<String> numberStr = new ArrayList<>();
        int number = size;
        while(true) {
            if(number / 2 == 1 && number % 2 == 0) {
                numberStr.add("1");
                numberStr.add("0");
                break;
            }else if(number == 1) {
                numberStr.add("1");
                break;
            }
            if(number % 2 == 1) {
                numberStr.add("1");
                number = number / 2;
            } else {
                numberStr.add("0");
                number = number / 2;
            }
        }
        return numberStr;
    }
}
