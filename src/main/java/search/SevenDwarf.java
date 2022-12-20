package search;

import java.util.*;

//7개의 합이 100인것을 찾도록 할 수도있지만 전체 값에서 2개를 뺏을때 100인 경우를 찾는 방법도 있을 수 있음
public class SevenDwarf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nineDwarfsHeight = new int[9];
        int index = 0;
        int max = 0;
        while(scanner.hasNextInt()) {
            int levelScoreInput = scanner.nextInt();
            max += levelScoreInput;
            nineDwarfsHeight[index] = levelScoreInput;
            index++;
        }
        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < nineDwarfsHeight.length; i++) {
            for (int j = 0; j < nineDwarfsHeight.length; j++) {
                if(max - nineDwarfsHeight[i] - nineDwarfsHeight[j] == 100 && i != j) {
                    nineDwarfsHeight[i] = 0;
                    nineDwarfsHeight[j] = 0;
                    Arrays.sort(nineDwarfsHeight);
                    for (int k = 2; k < nineDwarfsHeight.length; k++) {
                        System.out.println(nineDwarfsHeight[k]);
                    }
                    return;
                }
            }
        }
    }
}
