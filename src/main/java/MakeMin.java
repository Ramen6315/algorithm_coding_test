import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


//https://school.programmers.co.kr/learn/courses/30/lessons/12941
public class MakeMin {
    public  void main(String args[]) {
        int[] a = {1, 4, 2};
        int[] b = {5, 4, 4};
        solution(a, b);
    }

    public  int solution(int[] A, int[] B) {
        int answer = 0;
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        for (int a : A) {
            aList.add(a);
        }
        for (int b : B) {
            bList.add(b);
        }

        aList.sort(Comparator.naturalOrder());
        bList.sort(Comparator.reverseOrder());

        for (int i = 0; i < aList.size(); i++) {
            answer += aList.get(i) * bList.get(i);
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);

        return answer;
    }
}
