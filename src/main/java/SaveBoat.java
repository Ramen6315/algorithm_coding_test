import java.util.Arrays;


//정렬후 작은것하고 큰것 하고 비교 하면서 쌓아간다
public class SaveBoat {
    public static void main(String[] args) {
        int[] people = {100, 100, 100, 100,100, 100};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int boatCnt = 0;
        int light = 0;
        int heavy = people.length - 1;

        while(light != heavy) {
            if(people[light] + people[heavy] <= limit) {
                boatCnt++;
                if(light + 1 == heavy) {
                    break;
                }
                light++;
                heavy--;
            } else {
                boatCnt++;
                heavy--;
            }
            if(light == heavy) {
                boatCnt++;
            }
        }
        return boatCnt;
    }

}
