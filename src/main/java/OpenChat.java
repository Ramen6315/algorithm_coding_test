//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
////Log 부분을 Map으로 해서 등록한다음에 생성한 시간순으로 구분 해야 하지 않았을까 싶다
//public class OpenChat {
//    public static void main(String[] args) {
//        String[] record = {
//                "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
//        };
//        OpenChat openChat = new OpenChat();
//        String[] solution = openChat.solution(record);
//        System.out.println(solution);
//    }
//
//    public String[] solution(String[] record) {
//        List<Log> logs = new ArrayList<>();
//        for (String log : record) {
//            logs.add(new Log(log.split(" ")));
//        }
//    }
//
//    class Log {
//        String action;
//        String id;
//        String nickname;
//
//        public Log(String[] logs) {
//            if(logs.length == 2) {
//                this.action = logs[0];
//                this.id = logs[1];
//            }
//
//        }
//    }
//}
