import java.util.*;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {1, 4};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        List<Integer> citationList = new ArrayList<>();
        for (int citation : citations) {
            citationList.add(citation);
        }
        citationList.sort(Comparator.naturalOrder());
        int max = 0;
        for (int i = 0; i <= citationList.get(citationList.size()-1); i++) {
            int maxCnt = 0;
            for (int j = 0; j < citationList.size(); j++) {
                if(citationList.get(j) > i) {
                    maxCnt++;
                }
            }
            int standard = i;
            if( i == 0 ) {
                standard = 1;
            }
            if (maxCnt == standard
                    && citationList.size() - maxCnt <= standard
                    && maxCnt > max) {
                max = maxCnt;
            }
        }
        return max;
    }
}
