import java.util.*;

public class NewClustering {

    public  void main(String[] args) {
        System.out.println(solution("aa1+aa2", "AAAA12"));
    }

    public  int solution(String str1, String str2) {
        Map<String, Integer> str1Maps = new HashMap<>();
        Map<String, Integer> str2Maps = new HashMap<>();

        splitJakad(str1, str1Maps);
        splitJakad(str2, str2Maps);

        int min = findDuplicate(str1Maps, str2Maps);
        int max = findAll(str1Maps, str2Maps);
        System.out.println(str1Maps);
        System.out.println(str2Maps);
        System.out.println(min);
        System.out.println(max);
        if(min == 0 && max == 0) {
            return 65536;
        }
        return (int) ((double) min / (double) max * 65536);
    }

    private  void splitJakad(String str1, Map<String, Integer> str1Maps) {
        for (int i = 0; i < str1.length() - 1; i++) {
            String substr1 = str1.substring(i, i + 2).toUpperCase(Locale.ROOT);
            if(isOnlyAlphabet(substr1)) {
                if(!str1Maps.containsKey(substr1)) {
                    str1Maps.put(substr1, 1);
                } else {
                    str1Maps.put(substr1, str1Maps.get(substr1) + 1);
                }
            }
        }
    }

    private  int findAll(Map<String, Integer> str1Maps, Map<String, Integer> str2Maps) {
        int results = 0;
        Set<String> strSet = new HashSet<>();
        strSet.addAll(str1Maps.keySet());
        strSet.addAll(str2Maps.keySet());

        for (String setStr : strSet) {
            if(str1Maps.containsKey(setStr) && str2Maps.containsKey(setStr)) {
                if(str1Maps.get(setStr) > str2Maps.get(setStr)) {
                    results += str1Maps.get(setStr);
                } else {
                    results += str2Maps.get(setStr);
                }
            } else if(str1Maps.containsKey(setStr) && !str2Maps.containsKey(setStr)) {
                results += str1Maps.get(setStr);

            } else if(!str1Maps.containsKey(setStr) && str2Maps.containsKey(setStr)) {
                results += str2Maps.get(setStr);
            }
        }
        return results;
    }

    private  int findDuplicate(Map<String, Integer> str1Maps, Map<String, Integer> str2Maps) {
        int answer = 0;
        for (String str1 : str1Maps.keySet()) {
            if(str2Maps.containsKey(str1)) {
                if(str2Maps.get(str1) > str1Maps.get(str1)) {
                    answer += str1Maps.get(str1);
                } else {
                    answer += str2Maps.get(str1);
                }
            }
        }
        return answer;
    }

    private  boolean isOnlyAlphabet(String substr1) {
        String[] split = substr1.split("");
        if((split[0].charAt(0) > 64 && split[0].charAt(0) < 91)
                && (split[1].charAt(0) > 64 && split[1].charAt(0) < 91)) {
            return true;
        }
        return false;
    }
}
