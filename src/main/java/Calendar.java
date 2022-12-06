public class Calendar {
    public  void main(String[] args) {
        System.out.println(solution(11, 30));
    }

    public  String solution(int a, int b) {
        String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int month = -1;
        for(int i=1; i < a; i++) {
            if(i == 2) {
                month += 29;
                continue;
            }
            if(i < 8) {
                if(i % 2 == 1) {
                    month += 31;
                } else {
                    month += 30;
                }
            } else {
                if(i % 2 == 1) {
                    month += 30;
                } else {
                    month += 31;
                }
            }
        }
        month += b;

        int dayIndex = month % 7;
        return days[dayIndex];
    }
}
